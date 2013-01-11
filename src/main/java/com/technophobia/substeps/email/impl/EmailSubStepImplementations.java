package com.technophobia.substeps.email.impl;

import com.technophobia.substeps.email.runner.EmailSetupTearDown;
import com.technophobia.substeps.model.SubSteps;
import com.technophobia.substeps.model.SubSteps.StepImplementations;

/**
 * Aggregator for all email SubStep implementations
 */
@StepImplementations(requiredInitialisationClasses = EmailSetupTearDown.class)
@SubSteps.AdditionalStepImplementations({FinderEmailSubStepImplementations.class, MatcherPredicateSubStepImplementations.class})
public class EmailSubStepImplementations {
}
