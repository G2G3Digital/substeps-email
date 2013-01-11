package com.technophobia.substeps.email.runner;

import com.icegreen.greenmail.util.GreenMail;
import com.icegreen.greenmail.util.ServerSetup;

import javax.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.technophobia.substeps.email.runner.EmailSubstepsConfiguration.*;

/**
 * Simple class to provide access to emails received by the system
 */
public class EmailServerContext {

    final GreenMail greenMail;

    public EmailServerContext() {

        List<ServerSetup> serverSetups = new ArrayList<ServerSetup>();

        if (isImapEnabled()) {
            serverSetups.add(new ServerSetup(getImapPort(), getImapBindAddress(), ServerSetup.PROTOCOL_IMAP));
        }

        if (isImapsEnabled()) {
            serverSetups.add(new ServerSetup(getImapsPort(), getImapsBindAddress(), ServerSetup.PROTOCOL_IMAPS));
        }

        if (isPop3Enabled()) {
            serverSetups.add(new ServerSetup(getPop3Port(), getPop3BindAddress(), ServerSetup.PROTOCOL_POP3));
        }

        if (isPop3sEnabled()) {
            serverSetups.add(new ServerSetup(getPop3sPort(), getPop3sBindAddress(), ServerSetup.PROTOCOL_POP3S));
        }

        if (isSmtpEnabled()) {
            serverSetups.add(new ServerSetup(getSmtpPort(), getSmtpBindAddress(), ServerSetup.PROTOCOL_SMTP));
        }

        if (isSmtpsEnabled()) {
            serverSetups.add(new ServerSetup(getSmtpsPort(), getSmtpsBindAddress(), ServerSetup.PROTOCOL_SMTPS));
        }

        greenMail = new GreenMail(serverSetups.toArray(new ServerSetup[serverSetups.size()]));
    }

    public void start() {
        greenMail.start();
    }

    public void stop() {
        greenMail.stop();
    }

    public Iterable<MimeMessage> getReceivedMessages() {
        return Arrays.asList(greenMail.getReceivedMessages());
    }

}
