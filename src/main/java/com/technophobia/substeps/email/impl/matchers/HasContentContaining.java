package com.technophobia.substeps.email.impl.matchers;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;

public final class HasContentContaining extends TypeSafeMatcherPredicate<MimeMessage> {

    private static final Logger LOG = LoggerFactory.getLogger(HasContentContaining.class);

    private final String partialContent;

    public HasContentContaining(String partialContent) {
        this.partialContent = partialContent;
    }

    @Override
    protected boolean matchesSafely(final MimeMessage item) {
        LOG.debug("Checking if email content contains {}", partialContent);
        try {
            final String content = (String) item.getContent();
            return content != null && content.contains(partialContent);
        } catch (IOException ex) {
            LOG.warn("Error encountered while retrieving subject from email.", ex);
        } catch (MessagingException ex) {
            LOG.warn("Error encountered while retrieving subject from email.", ex);
        }
        LOG.debug("No content match found.");
        return false;
    }

    public void describeTo(final Description description) {
        description.appendText("does not contain");
    }

    @Factory
    public static MatcherPredicate<MimeMessage> hasContentContaining(String expectedContent) {
        return new HasContentContaining(expectedContent);
    }
}
