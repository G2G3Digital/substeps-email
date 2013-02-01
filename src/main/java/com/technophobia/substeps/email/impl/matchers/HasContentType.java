package com.technophobia.substeps.email.impl.matchers;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;


public class HasContentType extends TypeSafeMatcherPredicate<MimeMessage> {

    private static final Logger LOG = LoggerFactory.getLogger(HasContentType.class);

    final String expectedContentType;

    public HasContentType(ContentType expectedContentType) {
        this.expectedContentType = expectedContentType.name().toLowerCase();
    }


    @Override
    protected boolean matchesSafely(MimeMessage item) {
        LOG.debug("Checking if content type matches {}", expectedContentType);
        try {
            final String contentType = item.getContentType();
            return contentTypesMatch(contentType);
        } catch (MessagingException ex) {
            LOG.error("Error encountered while retrieving content type from email.");
        }
        LOG.debug("Content type does not match");
        return false;
    }

    private boolean contentTypesMatch(String contentType) {
        return contentType != null && contentType.startsWith(expectedContentType);
    }

    public void describeTo(Description description) {
        description.appendText("does not have content type");
        description.appendText(expectedContentType);
    }

    @Factory
    public static MatcherPredicate<MimeMessage> hasContentType(ContentType contentType) {
        return new HasContentType(contentType);
    }
}
