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
public class HasSubjectContainingTest {


    @Mock
    private MimeMessage message;

    @Mock
    private Address address1;

    @Mock
    private Address address2;


    @Test
    public void shouldMatchMessageContainingSubject() throws MessagingException {
        when(message.getSubject()).thenReturn("this subject has 'test-subject' in the middle of it");

        assertThat(message, HasSubjectContaining.hasSubjectContaining("test-subject"));
    }

    @Test
    public void shouldNotMatchMessageWithoutSubject() throws MessagingException {
        when(message.getSubject()).thenReturn("different-subject");

        assertThat(message, not(HasSubjectContaining.hasSubjectContaining("test-subject")));
    }

}
