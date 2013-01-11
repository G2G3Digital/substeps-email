package com.technophobia.substeps.email.impl;

import com.technophobia.substeps.email.runner.EmailSetupTearDown;
import com.technophobia.substeps.model.SubSteps.AdditionalStepImplementations;
import com.technophobia.substeps.model.SubSteps.StepImplementations;

/**
 * Aggregator for all email SubStep implementations
 */
@StepImplementations(requiredInitialisationClasses = EmailSetupTearDown.class)
@AdditionalStepImplementations({AssertEmailSubStepImplementations.class, FinderEmailSubStepImplementations.class, MatcherPredicateSubStepImplementations.class})
public class EmailSubStepImplementations {
}
