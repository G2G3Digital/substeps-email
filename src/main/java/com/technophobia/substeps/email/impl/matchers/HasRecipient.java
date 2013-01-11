package com.technophobia.substeps.email.impl.matchers;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.Address;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

public final class HasRecipient extends TypeSafeMatcherPredicate<MimeMessage> {

    private static final Logger LOG = LoggerFactory.getLogger(HasRecipient.class);

    private final String expectedRecipient;

    public HasRecipient(String expectedRecipient) {
        this.expectedRecipient = expectedRecipient;
    }

    public void describeTo(final Description description) {
        description.appendText("does not contain recipient");
    }

    @Override
    protected boolean matchesSafely(final MimeMessage item) {
        try {
            for (Address address : item.getAllRecipients()) {
                LOG.debug("Checking if recipient {} matches {}", address, expectedRecipient);
                if (address.toString().equals(expectedRecipient)) {
                    LOG.debug("Found a matching recipient");
                    return true;
                }
            }
        } catch (MessagingException ex) {
            LOG.warn("Error encountered while retrieving recipients from email.", ex);
        }
        LOG.debug("No recipient match found");
        return false;
    }

    @Factory
    public static MatcherPredicate<MimeMessage> hasRecipient(String expectedRecipient) {
        return new HasRecipient(expectedRecipient);
    }
}
