package com.technophobia.substeps.email.impl;

import com.google.common.collect.Collections2;
import com.technophobia.substeps.email.impl.matchers.MatcherPredicateBuilder;
import com.technophobia.substeps.email.runner.EmailSetupTearDown;
import com.technophobia.substeps.model.SubSteps.Step;
import com.technophobia.substeps.model.SubSteps.StepImplementations;
import junit.framework.Assert;
import org.hamcrest.Matcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.internet.MimeMessage;
import java.util.Collection;

import static com.technophobia.substeps.email.runner.EmailSetupTearDown.getEmailExecutionContext;
import static com.technophobia.substeps.email.runner.EmailSetupTearDown.getEmailServerContext;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.junit.Assert.assertThat;

@StepImplementations(requiredInitialisationClasses = EmailSetupTearDown.class)
public class FinderEmailSubStepImplementations {

    private static Logger LOG = LoggerFactory.getLogger(FinderEmailSubStepImplementations.class);

    /**
     * Find received emails that matches stored conditions.
     * <p/>
     * Conditions must be built using CreateCondition, for example
     * CreateCondition
     * With subject "test-subject"
     * With recipient "test-recipient@example.com"
     *
     * @example AssertEmailReceivedByCondition
     * @section Email
     */
    @Step("FindByCondition")
    public Collection<MimeMessage> executeFinderWithCondition() {
        LOG.debug("Finding emails matching pre-built condition.");
        MatcherPredicateBuilder builder = getEmailExecutionContext().getMatcherPredicateBuilder();
        Assert.assertNotNull("'CreateCondition' must be called before using 'FindByCondition'", builder);

        final Collection<MimeMessage> receivedMessages = getEmailServerContext().getReceivedMessages();
        final Collection<MimeMessage> matchingMessages = Collections2.filter(receivedMessages, builder.buildPredicate());

        Matcher<Collection<MimeMessage>> empty = empty(); //TODO: old hamcrest
        assertThat("expected some emails matching criteria", matchingMessages, is(not(empty)));

        getEmailExecutionContext().setCurrentMessages(matchingMessages);

        return matchingMessages;
    }

}
