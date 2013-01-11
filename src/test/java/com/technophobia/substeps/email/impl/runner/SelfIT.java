package com.technophobia.substeps.email.impl.runner;

import com.technophobia.substeps.email.impl.EmailSubStepImplementations;
import com.technophobia.substeps.email.runner.EmailSetupTearDown;
import com.technophobia.substeps.runner.JunitFeatureRunner;
import org.junit.runner.RunWith;

@JunitFeatureRunner.SubStepsConfiguration(featureFile = "./target/test-classes/features", subStepsFile = "./target/test-classes/substeps", stepImplementations = {SelfTestSteps.class, EmailSubStepImplementations.class}, beforeAndAfterImplementations = {EmailSetupTearDown.class})
@RunWith(JunitFeatureRunner.class)
public class SelfIT {
}
