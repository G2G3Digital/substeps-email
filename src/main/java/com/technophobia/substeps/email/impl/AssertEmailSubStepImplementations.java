package com.technophobia.substeps.email.impl;

import com.technophobia.substeps.email.impl.matchers.MatcherPredicateBuilder;
import com.technophobia.substeps.email.runner.EmailServerContext;
import com.technophobia.substeps.model.SubSteps.Step;
import com.technophobia.substeps.model.SubSteps.StepImplementations;
import junit.framework.Assert;
import org.hamcrest.Matcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.internet.MimeMessage;

import static com.technophobia.substeps.email.runner.EmailSetupTearDown.getEmailExecutionContext;
import static com.technophobia.substeps.email.runner.EmailSetupTearDown.getEmailServerContext;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.junit.Assert.assertThat;

/**
 * Email assertions
 */
@StepImplementations
public class AssertEmailSubStepImplementations {

    private static final Logger LOG = LoggerFactory.getLogger(AssertEmailSubStepImplementations.class);

    /**
     * Check that an email was received to ... with a subject line of ...
     *
     * @param recipient the recipient
     * @param subject   the subject
     * @example AssertEmailReceived to "mickey@disney.com" with subject
     * "You've won!"
     * @section Email
     */
    @Step("AssertEmailReceived to \"([^\"]*)\" with subject \"([^\"]*)\"")
    public void assertEmailReceived(final String recipient, final String subject) {
        LOG.debug("Asserting " + recipient + " received an email with subject " + subject);

        final EmailServerContext emailServerContext = getEmailServerContext();

        final Matcher<MimeMessage> messageWithExpectedAttributes = new MatcherPredicateBuilder().withSubject(subject).withRecipient(recipient).buildMatcher();

        assertThat("expected some emails matching criteria", emailServerContext.getReceivedMessages(), contains(messageWithExpectedAttributes));
    }

    /**
     * Check that an email was received that matches stored conditions.
     *
     * Conditions must be built using CreateCondition, for example
     * CreateCondition
     * With subject "test-subject"
     * With recipient "test-recipient@example.com"
     * @example AssertEmailReceivedByCondition
     *
     * @section Email
     */
    @Step("AssertEmailReceivedByCondition")
    public void executeFinderWithCondition() {
        MatcherPredicateBuilder builder = getEmailExecutionContext().getMatcherPredicateBuilder();
        Assert.assertNotNull("'CreateCondition' must be called before using 'FindByCondition'", builder);

        assertThat("expected some emails matching criteria", getEmailServerContext().getReceivedMessages(), contains(builder.buildMatcher()));
    }

}
