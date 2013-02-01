package com.technophobia.substeps.email.impl;


import com.technophobia.substeps.email.impl.matchers.ContentType;
import com.technophobia.substeps.email.impl.matchers.MatcherPredicateBuilder;
import com.technophobia.substeps.model.SubSteps.Step;
import com.technophobia.substeps.model.SubSteps.StepImplementations;
import junit.framework.Assert;

import static com.technophobia.substeps.email.runner.EmailSetupTearDown.getEmailExecutionContext;

@StepImplementations
public class MatcherPredicateSubStepImplementations {

    /**
     * Creates criteria builder for building find/assertion criteria
     * <p/>
     * Should be used in conjunction with criteria such as
     * With recipient "micky@disney.com"
     *
     * @example DefineCriteria
     * @section Email
     */
    @Step("DefineCriteria")
    public MatcherPredicateBuilder createMatcherPredicateBuilder() {
        final MatcherPredicateBuilder matcherPredicateBuilder = new MatcherPredicateBuilder();
        getEmailExecutionContext().setMatcherPredicateBuilder(matcherPredicateBuilder);

        return matcherPredicateBuilder;
    }

    /**
     * Creates criteria builder for building find/assertion criteria
     * <p/>
     * Should be used in conjunction with criteria such as
     * With recipient "micky@disney.com"
     *
     * @example DefineCriteria
     * @section Email
     * @deprecated
     */
    @Step("CreateCondition")
    @Deprecated
    public MatcherPredicateBuilder createCondition() {
        return createMatcherPredicateBuilder();
    }


    /**
     * Adds recipient criteria
     * <p/>
     * Matching email messages must have the specified recipient.  All recipient types are considered,
     * so this will match against recipients in to, cc, and bcc fields.
     *
     * @param recipient
     * @example With recipient "micky@disney.com"
     * @section Email
     */
    @Step("With recipient \"([^\"]*)\"")
    public void addRecipientCriteria(String recipient) {
        MatcherPredicateBuilder builder = getEmailExecutionContext().getMatcherPredicateBuilder();
        Assert.assertNotNull("'DefineCriteria' must be called before using 'With recipient'", builder);

        builder.withRecipient(recipient);
    }

    /**
     * Adds subject criteria
     * <p/>
     * Matching email messages must have the specified subject.  Subject line must match in its entirety.
     *
     * @param subject
     * @example With subject "You've won!"
     * @section Email
     */
    @Step("With subject \"([^\"]*)\"")
    public void addSubjectCriteria(String subject) {
        MatcherPredicateBuilder builder = getEmailExecutionContext().getMatcherPredicateBuilder();
        Assert.assertNotNull("'DefineCriteria' must be called before using 'With subject'", builder);

        builder.withSubject(subject);
    }

    /**
     * Adds subject criteria
     * <p/>
     * Matching email messages must have a subject containing the specified text.
     *
     * @param partialSubject
     * @example With subject containing "won!"
     * @section Email
     */
    @Step("With subject containing \"([^\"]*)\"")
    public void addSubjectContainingCriteria(String partialSubject) {
        MatcherPredicateBuilder builder = getEmailExecutionContext().getMatcherPredicateBuilder();
        Assert.assertNotNull("'DefineCriteria' must be called before using 'With subject containing'", builder);

        builder.withSubjectContaining(partialSubject);
    }

    /**
     * Adds plain-text content type criteria
     * <p/>
     * Matching email messages must have plain-text content.
     *
     * @example With plain-text content
     * @section Email
     */
    @Step("With plain-text content")
    public void addPlainTextContentCriteria() {
        MatcherPredicateBuilder builder = getEmailExecutionContext().getMatcherPredicateBuilder();
        Assert.assertNotNull("'DefineCriteria' must be called before using 'With plain-text content'", builder);

        builder.withContentType(ContentType.TEXT);
    }

    /**
     * Adds content criteria
     * <p/>
     * Matching email messages must have plain-text content that contains the specified text.
     *
     * @example With plain-text content
     * @section Email
     * <p/>
     * TODO: Work towards removing the requirement that message content must be plain-text.
     * TODO: Regex patterns?
     */
    @Step("With plain-text content containing \"([^\"]*)\"")
    public void addPlainTextContentCriteria(String expectedContent) {
        MatcherPredicateBuilder builder = getEmailExecutionContext().getMatcherPredicateBuilder();
        Assert.assertNotNull("'DefineCriteria' must be called before using 'With plain-text content containing'", builder);

        builder.withContentContaining(expectedContent);
    }

}
