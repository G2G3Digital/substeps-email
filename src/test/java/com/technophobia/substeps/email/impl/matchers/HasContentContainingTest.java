package com.technophobia.substeps.email.impl.matchers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;

import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class HasContentContainingTest {

    @MockitoAnnotations.Mock
    private MimeMessage message;

    @Test
    public void shouldMatchMessageWithContentContaining() throws MessagingException, IOException {
        when(message.getContent()).thenReturn("some test plain-text content");

        assertThat(message, HasContentContaining.hasContentContaining("plain-text content"));
    }

    @Test
    public void shouldNotMatchMessageWithoutContent() throws MessagingException, IOException {
        when(message.getContent()).thenReturn(null);

        assertThat(message, not(HasContentContaining.hasContentContaining("plain-text content")));
    }

    @Test
    public void shouldNotMatchMessageWithContentNotContaing() throws MessagingException, IOException {
        when(message.getContent()).thenReturn("some completely different content");

        assertThat(message, not(HasContentContaining.hasContentContaining("plain-text content")));
    }

}
