package com.technophobia.substeps.email.impl.runner;

import com.technophobia.substeps.email.runner.EmailSubstepsConfiguration;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

public class EmailSubstepsConfigurationTest {


    //Enabled state

    @Test
    public void smtpShouldBeEnabledByDefault() {
        assertThat(EmailSubstepsConfiguration.isSmtpEnabled(), is(true));
    }

    @Test
    public void smtpsShouldBeEnabledByDefault() {
        assertThat(EmailSubstepsConfiguration.isSmtpsEnabled(), is(true));
    }

    @Test
    public void pop3ShouldBeEnabledByDefault() {
        assertThat(EmailSubstepsConfiguration.isSmtpsEnabled(), is(true));
    }

    @Test
    public void pop3sShouldBeEnabledByDefault() {
        assertThat(EmailSubstepsConfiguration.isSmtpsEnabled(), is(true));
    }

    @Test
    public void imapShouldBeEnabledByDefault() {
        assertThat(EmailSubstepsConfiguration.isSmtpsEnabled(), is(true));
    }

    @Test
    public void imapsShouldBeEnabledByDefault() {
        assertThat(EmailSubstepsConfiguration.isSmtpsEnabled(), is(true));
    }

    //Ports

    @Test
    public void smtpShouldBeOnPort3025ByDefault() {
        assertThat(EmailSubstepsConfiguration.getSmtpPort(), is(3025));
    }

    @Test
    public void smtpsShouldBeOnPort30465ByDefault() {
        assertThat(EmailSubstepsConfiguration.getSmtpsPort(), is(30465));
    }

    @Test
    public void pop3ShouldBeOnPort30110ByDefault() {
        assertThat(EmailSubstepsConfiguration.getPop3Port(), is(30110));
    }

    @Test
    public void pop3sShouldBeOnPort30995ByDefault() {
        assertThat(EmailSubstepsConfiguration.getPop3sPort(), is(30995));
    }

    @Test
    public void imapShouldBeOnPort30143ByDefault() {
        assertThat(EmailSubstepsConfiguration.getImapPort(), is(30143));
    }

    @Test
    public void imapsShouldBeOnPort30993ByDefault() {
        assertThat(EmailSubstepsConfiguration.getImapsPort(), is(30993));
    }


    //Bind Addresses

    @Test
    public void smtpBindAddressShouldBeNullByDefault() {
        assertThat(EmailSubstepsConfiguration.getSmtpBindAddress(), is(nullValue()));
    }

    @Test
    public void smtpsBindAddressShouldBeNullByDefault() {
        assertThat(EmailSubstepsConfiguration.getSmtpsBindAddress(), is(nullValue()));
    }

    @Test
    public void pop3BindAddressShouldBeNullByDefault() {
        assertThat(EmailSubstepsConfiguration.getPop3BindAddress(), is(nullValue()));
    }

    @Test
    public void pop3sBindAddressShouldBeNullByDefault() {
        assertThat(EmailSubstepsConfiguration.getPop3sBindAddress(), is(nullValue()));
    }

    @Test
    public void imapBindAddressShouldBeNullByDefault() {
        assertThat(EmailSubstepsConfiguration.getImapBindAddress(), is(nullValue()));
    }

    @Test
    public void imapsBindAddressShouldBeNullByDefault() {
        assertThat(EmailSubstepsConfiguration.getImapsBindAddress(), is(nullValue()));
    }

}
