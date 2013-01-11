package com.technophobia.substeps.email.runner;

import com.technophobia.substeps.model.Configuration;

import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 * User: dmoss
 * Date: 09/01/13
 * Time: 09:05
 * To change this template use File | Settings | File Templates.
 */
public class EmailSubstepsConfiguration {

    private static final boolean SMTP_ENABLED;
    private static final int SMTP_PORT;
    private static final String SMTP_BIND_ADDRESS;

    private static final boolean SMTPS_ENABLED;
    private static final int SMTPS_PORT;
    private static final String SMTPS_BIND_ADDRESS;

    private static final boolean POP3_ENABLED;
    private static final int POP3_PORT;
    private static final String POP3_BIND_ADDRESS;

    private static final boolean POP3S_ENABLED;
    private static final int POP3S_PORT;
    private static final String POP3S_BIND_ADDRESS;

    private static final boolean IMAP_ENABLED;
    private static final int IMAP_PORT;
    private static final String IMAP_BIND_ADDRESS;

    private static final boolean IMAPS_ENABLED;
    private static final int IMAPS_PORT;
    private static final String IMAPS_BIND_ADDRESS;

    static {
        final URL defaultConfigurationURL = EmailSubstepsConfiguration.class.getResource("/default-email-substeps.properties");
        Configuration.INSTANCE.addDefaultProperties(defaultConfigurationURL, "default-email");

        SMTP_ENABLED = Configuration.INSTANCE.getBoolean("email.smtp.enabled");
        SMTP_PORT = Configuration.INSTANCE.getInt("email.smtp.port");
        SMTP_BIND_ADDRESS = Configuration.INSTANCE.getString("email.smtp.bindAddress");

        SMTPS_ENABLED = Configuration.INSTANCE.getBoolean("email.smtps.enabled");
        SMTPS_PORT = Configuration.INSTANCE.getInt("email.smtps.port");
        SMTPS_BIND_ADDRESS = Configuration.INSTANCE.getString("email.smtps.bindAddress");


        POP3_ENABLED = Configuration.INSTANCE.getBoolean("email.pop3.enabled");
        POP3_PORT = Configuration.INSTANCE.getInt("email.pop3.port");
        POP3_BIND_ADDRESS = Configuration.INSTANCE.getString("email.pop3.bindAddress");


        POP3S_ENABLED = Configuration.INSTANCE.getBoolean("email.pop3s.enabled");
        POP3S_PORT = Configuration.INSTANCE.getInt("email.pop3s.port");
        POP3S_BIND_ADDRESS = Configuration.INSTANCE.getString("email.pop3s.bindAddress");


        IMAP_ENABLED = Configuration.INSTANCE.getBoolean("email.imap.enabled");
        IMAP_PORT = Configuration.INSTANCE.getInt("email.imap.port");
        IMAP_BIND_ADDRESS = Configuration.INSTANCE.getString("email.imap.bindAddress");


        IMAPS_ENABLED = Configuration.INSTANCE.getBoolean("email.imaps.enabled");
        IMAPS_PORT = Configuration.INSTANCE.getInt("email.imaps.port");
        IMAPS_BIND_ADDRESS = Configuration.INSTANCE.getString("email.imaps.bindAddress");
    }

    public static boolean isSmtpEnabled() {
        return SMTP_ENABLED;
    }

    public static int getSmtpPort() {
        return SMTP_PORT;
    }

    public static String getSmtpBindAddress() {
        return SMTP_BIND_ADDRESS;
    }

    public static boolean isSmtpsEnabled() {
        return SMTPS_ENABLED;
    }

    public static int getSmtpsPort() {
        return SMTPS_PORT;
    }

    public static String getSmtpsBindAddress() {
        return SMTPS_BIND_ADDRESS;
    }

    public static boolean isPop3Enabled() {
        return POP3_ENABLED;
    }

    public static int getPop3Port() {
        return POP3_PORT;
    }

    public static String getPop3BindAddress() {
        return POP3_BIND_ADDRESS;
    }

    public static boolean isPop3sEnabled() {
        return POP3S_ENABLED;
    }

    public static int getPop3sPort() {
        return POP3S_PORT;
    }

    public static String getPop3sBindAddress() {
        return POP3S_BIND_ADDRESS;
    }

    public static boolean isImapEnabled() {
        return IMAP_ENABLED;
    }

    public static int getImapPort() {
        return IMAP_PORT;
    }

    public static String getImapBindAddress() {
        return IMAP_BIND_ADDRESS;
    }

    public static boolean isImapsEnabled() {
        return IMAPS_ENABLED;
    }

    public static int getImapsPort() {
        return IMAPS_PORT;
    }

    public static String getImapsBindAddress() {
        return IMAPS_BIND_ADDRESS;
    }
}
