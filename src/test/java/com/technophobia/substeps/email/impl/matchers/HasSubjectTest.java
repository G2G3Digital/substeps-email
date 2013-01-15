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
public class HasSubjectTest {


    @Mock
    private MimeMessage message;

    @Mock
    private Address address1;

    @Mock
    private Address address2;


    @Test
    public void shouldMatchMessageWithSubject() throws MessagingException {
        when(message.getSubject()).thenReturn("test-subject");

        assertThat(message, HasSubject.hasSubject("test-subject"));
    }

    @Test
    public void shouldNotMatchMessageWithoutSubject() throws MessagingException {
        when(message.getSubject()).thenReturn("different-subject");

        assertThat(message, not(HasSubject.hasSubject("test-subject")));
    }

}
