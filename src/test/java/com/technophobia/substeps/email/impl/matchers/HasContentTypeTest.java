package com.technophobia.substeps.email.impl.matchers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class HasContentTypeTest {

    @MockitoAnnotations.Mock
    private MimeMessage message;

    @Test
    public void shouldMatchMessageWithContentType() throws MessagingException {
        when(message.getContentType()).thenReturn("text/plain");

        assertThat(message, HasContentType.hasContentType(ContentType.TEXT));
    }

    @Test
    public void shouldNotMatchMessageWithoutContentType() throws MessagingException {
        when(message.getContentType()).thenReturn(null);

        assertThat(message, not(HasContentType.hasContentType(ContentType.TEXT)));
    }

    @Test
    public void shouldNotMatchMessageWithDifferentContentType() throws MessagingException {
        when(message.getContentType()).thenReturn("multipart/mixed");

        assertThat(message, not(HasContentType.hasContentType(ContentType.TEXT)));
    }
}
