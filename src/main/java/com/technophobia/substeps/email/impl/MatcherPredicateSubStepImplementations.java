package com.technophobia.substeps.email.impl;


import com.technophobia.substeps.email.impl.matchers.MatcherPredicateBuilder;
import com.technophobia.substeps.model.Scope;
import com.technophobia.substeps.model.SubSteps.Step;
import com.technophobia.substeps.model.SubSteps.StepImplementations;
import com.technophobia.substeps.runner.ExecutionContext;
import junit.framework.Assert;

@StepImplementations
public class MatcherPredicateSubStepImplementations {

    public static final String EMAIL_MATCHER = "email-matcher";

    @Step("CreateCondition")
    public void createMatcherPredicateBuilder() {
        ExecutionContext.put(Scope.SCENARIO, EMAIL_MATCHER, new MatcherPredicateBuilder());
    }

    @Step("With recipient \"([^\"]*)\"")
    public void addRecipientCondition(String recipient) {
        MatcherPredicateBuilder builder = (MatcherPredicateBuilder) ExecutionContext.get(Scope.SCENARIO, EMAIL_MATCHER);
        Assert.assertNotNull("'CreateCondition' must be called before using 'With recipient'", builder);

        builder.withRecipient(recipient);
    }

    @Step("With subject \"([^\"]*)\"")
    public void addSubjectCondition(String subject) {
        MatcherPredicateBuilder builder = (MatcherPredicateBuilder) ExecutionContext.get(Scope.SCENARIO, EMAIL_MATCHER);
        Assert.assertNotNull("'CreateCondition' must be called before using 'With subject'", builder);

        builder.withSubject(subject);
    }

    @Step("With subject containing \"([^\"]*)\"")
    public void addSubjectContainingCondition(String partialSubject) {
        MatcherPredicateBuilder builder = (MatcherPredicateBuilder) ExecutionContext.get(Scope.SCENARIO, EMAIL_MATCHER);
        Assert.assertNotNull("'CreateCondition' must be called before using 'With subject containing'", builder);

        builder.withSubjectContaining(partialSubject);
    }

}
