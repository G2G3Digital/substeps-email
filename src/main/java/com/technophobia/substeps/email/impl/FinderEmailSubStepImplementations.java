package com.technophobia.substeps.email.impl;

import com.google.common.base.Supplier;
import com.technophobia.substeps.email.impl.matchers.MatcherPredicateBuilder;
import com.technophobia.substeps.email.runner.EmailServerContext;
import com.technophobia.substeps.email.runner.EmailSetupTearDown;
import com.technophobia.substeps.model.Scope;
import com.technophobia.substeps.model.SubSteps.Step;
import com.technophobia.substeps.model.SubSteps.StepImplementations;
import com.technophobia.substeps.runner.ExecutionContext;
import junit.framework.Assert;
import org.hamcrest.Matcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.internet.MimeMessage;

import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.junit.Assert.assertThat;

@StepImplementations(requiredInitialisationClasses = EmailSetupTearDown.class)
public class FinderEmailSubStepImplementations {

    private static Logger logger = LoggerFactory.getLogger(FinderEmailSubStepImplementations.class);

    /**
     * Check that an email was received to ... with a subject line of ...
     *
     * @param recipient the recipient
     * @param subject   the subject
     * @example AssertEmailReceived to "mickey@disney.com" with subject
     * "You've won!"
     * @section Email related
     */
    @Step("AssertEmailReceived to \"([^\"]*)\" with subject \"([^\"]*)\"")
    public void assertEmailReceived(final String recipient, final String subject) {
        logger.debug("Asserting " + recipient + " received an email with subject " + subject);

        final EmailServerContext emailServerContext = EmailSetupTearDown.getEmailServerContext();

        final Matcher<MimeMessage> messageWithExpectedAttributes = new MatcherPredicateBuilder().withSubject(subject).withRecipient(recipient).buildMatcher();

        assertThat("expected some emails matching criteria", emailServerContext.getReceivedMessages(), contains(messageWithExpectedAttributes));
    }

    @Step("FindByCondition")
    public void executeFinderWithCondition() {
        MatcherPredicateBuilder builder = (MatcherPredicateBuilder) ExecutionContext.get(Scope.SCENARIO, MatcherPredicateSubStepImplementations.EMAIL_MATCHER);
        Assert.assertNotNull("'CreateCondition' must be called before using 'FindByCondition'", builder);

        final EmailServerContext emailServerContext = EmailSetupTearDown.getEmailServerContext();

        assertThat("expected some emails matching criteria", emailServerContext.getReceivedMessages(), contains(builder.buildMatcher()));
    }
}
