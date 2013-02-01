package com.technophobia.substeps.email.impl.matchers;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

public final class HasSubject extends TypeSafeMatcherPredicate<MimeMessage> {

    private static final Logger LOG = LoggerFactory.getLogger(HasSubject.class);

    private final String expectedSubject;

    public HasSubject(String expectedSubject) {
        this.expectedSubject = expectedSubject;
    }

    @Override
    protected boolean matchesSafely(final MimeMessage item) {
        LOG.debug("Checking if email subject matches {}", expectedSubject);
        try {
            final String subject = item.getSubject();
            return subjectsMatch(subject);
        } catch (MessagingException ex) {
            LOG.warn("Error encountered while retrieving subject from email.", ex);
        }
        LOG.debug("No subject match found.");
        return false;
    }

    private boolean subjectsMatch(String subject) {
        return subject != null && subject.equals(expectedSubject);
    }

    public void describeTo(final Description description) {
        description.appendText("does not have subject");
    }

    @Factory
    public static MatcherPredicate<MimeMessage> hasSubject(String expectedSubject) {
        return new HasSubject(expectedSubject);
    }
}
