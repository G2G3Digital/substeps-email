package com.technophobia.substeps.email.impl;


import com.technophobia.substeps.email.impl.matchers.MatcherPredicateBuilder;
import com.technophobia.substeps.model.SubSteps.Step;
import com.technophobia.substeps.model.SubSteps.StepImplementations;
import junit.framework.Assert;

import static com.technophobia.substeps.email.runner.EmailSetupTearDown.getEmailExecutionContext;

@StepImplementations
public class MatcherPredicateSubStepImplementations {

    /**
     * Creates condition builder for building find/assertion criteria
     *
     * Should be used in conjunction with criteria such as
     * With recipient "micky@disney.com"
     *
     * @example CreateCondition
     * @section Email
     *
     */
    @Step("CreateCondition")
    public void createMatcherPredicateBuilder() {
        getEmailExecutionContext().setMatcherPredicateBuilder(new MatcherPredicateBuilder());
    }

    /**
     * Adds recipient criteria
     *
     * Matching email messages must have the specified recipient.  All recipient types are considered,
     * so this will match against recipients in to, cc, and bcc fields.
     *
     * @param recipient
     * @example With recipient "micky@disney.com"
     * @section Email
     */
    @Step("With recipient \"([^\"]*)\"")
    public void addRecipientCondition(String recipient) {
        MatcherPredicateBuilder builder = getEmailExecutionContext().getMatcherPredicateBuilder();
        Assert.assertNotNull("'CreateCondition' must be called before using 'With recipient'", builder);

        builder.withRecipient(recipient);
    }

    /**
     * Adds subject criteria
     *
     * Matching email messages must have the specified subject.  Subject line must match in its entirety.
     *
     * @param subject
     * @example With subject "You've won!"
     * @section Email
     */
    @Step("With subject \"([^\"]*)\"")
    public void addSubjectCondition(String subject) {
        MatcherPredicateBuilder builder = getEmailExecutionContext().getMatcherPredicateBuilder();
        Assert.assertNotNull("'CreateCondition' must be called before using 'With subject'", builder);

        builder.withSubject(subject);
    }

    /**
     * Adds subject criteria
     *
     * Matching email messages must have a subject containing the specified text.
     *
     * @param partialSubject
     * @example With subject containing "won!"
     * @section Email
     */
    @Step("With subject containing \"([^\"]*)\"")
    public void addSubjectContainingCondition(String partialSubject) {
        MatcherPredicateBuilder builder = getEmailExecutionContext().getMatcherPredicateBuilder();
        Assert.assertNotNull("'CreateCondition' must be called before using 'With subject containing'", builder);

        builder.withSubjectContaining(partialSubject);
    }

}
