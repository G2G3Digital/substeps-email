package com.technophobia.substeps.email.impl.matchers;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

public final class HasSubjectContaining extends TypeSafeMatcherPredicate<MimeMessage> {

    private static final Logger LOG = LoggerFactory.getLogger(HasSubjectContaining.class);

    private final String partialSubject;

    public HasSubjectContaining(String partialSubject) {
        this.partialSubject = partialSubject;
    }

    @Override
    protected boolean matchesSafely(final MimeMessage item) {
        LOG.debug("Checking if email subject contains {}", partialSubject);
        try {
            final String subject = item.getSubject();
            return subject != null && subject.contains(partialSubject);
        } catch (MessagingException ex) {
            LOG.warn("Error encountered while retrieving subject from email.", ex);
        }
        LOG.debug("No subject match found.");
        return false;
    }

    public void describeTo(final Description description) {
        description.appendText("does not have subject containing");
    }

    @Factory
    public static MatcherPredicate<MimeMessage> hasSubjectContaining(String expectedSubject) {
        return new HasSubjectContaining(expectedSubject);
    }
}
