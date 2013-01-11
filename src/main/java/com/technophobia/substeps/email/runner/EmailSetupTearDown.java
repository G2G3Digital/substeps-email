package com.technophobia.substeps.email.runner;

import com.technophobia.substeps.model.Scope;
import com.technophobia.substeps.runner.setupteardown.Annotations.AfterEveryScenario;
import com.technophobia.substeps.runner.setupteardown.Annotations.BeforeEveryScenario;

/**
 * Created with IntelliJ IDEA.
 * User: dmoss
 * Date: 08/01/13
 * Time: 12:27
 * To change this template use File | Settings | File Templates.
 */
public class EmailSetupTearDown {

    private static final String EMAIL_SERVER_CONTEXT_KEY = EmailServerContext.class.getName();
    private static final String EMAIL_EXECUTION_CONTEXT_KEY = EmailExecutionContext.class.getName();

    private static final MutableSupplier<EmailServerContext> emailServerContextSupplier = new ExecutionContextSupplier<EmailServerContext>(Scope.SCENARIO, EMAIL_SERVER_CONTEXT_KEY);
    private static final MutableSupplier<EmailExecutionContext> emailExecutionContextSupplier = new ExecutionContextSupplier<EmailExecutionContext>(Scope.SCENARIO, EMAIL_EXECUTION_CONTEXT_KEY);

    public static EmailServerContext getEmailServerContext() {
        return emailServerContextSupplier.get();
    }

    public static EmailExecutionContext getEmailExecutionContext() {
        return emailExecutionContextSupplier.get();
    }

    @BeforeEveryScenario
    public final void initialiseContext() {
        EmailServerContext emailServerContext = new EmailServerContext();
        emailServerContextSupplier.set(emailServerContext);
        emailServerContext.start();

        EmailExecutionContext emailExecutionContext = new EmailExecutionContext();
        emailExecutionContextSupplier.set(emailExecutionContext);
    }

    @AfterEveryScenario
    public final void shutdownContext() {
        final EmailServerContext emailServerContext = emailServerContextSupplier.get();
        if (emailServerContext != null) {
            emailServerContext.stop();
        }
    }


}