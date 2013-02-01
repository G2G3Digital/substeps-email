package com.technophobia.substeps.email.impl.matchers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.mail.Address;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class HasRecipientTest {

    @Mock
    private MimeMessage message;

    @Mock
    private Address address1;

    @Mock
    private Address address2;


    @Test
    public void shouldMatchMessageWithRecipient() throws MessagingException {
        when(address1.toString()).thenReturn("expected@example.com");
        when(address2.toString()).thenReturn("other@example.com");

        when(message.getAllRecipients()).thenReturn(new Address[]{address1, address2});

        assertThat(message, HasRecipient.hasRecipient("expected@example.com"));
    }

    @Test
    public void shouldNotMatchMessageWithoutRecipient() throws MessagingException {
        when(address1.toString()).thenReturn("other1@example.com");
        when(address2.toString()).thenReturn("other2@example.com");

        when(message.getAllRecipients()).thenReturn(new Address[]{address1, address2});

        assertThat(message, not(HasRecipient.hasRecipient("expected@example.com")));
    }

}
