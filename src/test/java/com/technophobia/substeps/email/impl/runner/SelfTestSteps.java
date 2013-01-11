package com.technophobia.substeps.email.impl.runner;


import com.icegreen.greenmail.util.GreenMailUtil;
import com.icegreen.greenmail.util.ServerSetup;
import com.technophobia.substeps.email.runner.EmailSubstepsConfiguration;
import com.technophobia.substeps.model.SubSteps.Step;
import com.technophobia.substeps.model.SubSteps.StepImplementations;

@StepImplementations
public class SelfTestSteps {

    @Step("When I've sent an email to \"([^\"]*)\" with the subject \"([^\"]*)\"")
    public void sendTestEmail(String recipient, String subject) {
        GreenMailUtil.sendTextEmail(recipient, "substeps@example.com", subject, GreenMailUtil.random(), new ServerSetup(EmailSubstepsConfiguration.getSmtpPort(), null, ServerSetup.PROTOCOL_SMTP));
    }


}
