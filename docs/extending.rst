Extending Email Step implementations
========================================

If you are using the Email substeps library, you might need to create some custom step implementations to deal with the specifics of your application.
Implementing such methods is easy; the Email-substeps library exposes a number of methods to aid writing custom email implementations.

The substeps library is implemented with GreenMail.  The underlying GreenMail instance is tied to the current thread and can be accessed via the following static method:

.. code-block:: java

   import static com.technophobia.substeps.email.runner.EmailSetupTearDown.getEmailServerContextSupplier().get();

NB. Running in parallel threads is not recommended because the underlying GreenMail implementation might not be itself threadsafe.

If you wish to extend the email-substeps classes, your new StepImplementations class will also need to include the initialisation class ``EmailSetupTearDown`` to ensure that the GreenMail mail server is started and stopped appropriately.

New step implementations can make use of and aggregate existing functions, simply instantiate the implementation class and invoke the appropriate method accordingly. For example:

.. code-block:: java

   @StepImplementations (requiredInitialisationClasses=EmailSetupTearDown.class)
   public MyEmailStepImplementations {

      @Step("DoSomething with parameter \"([^\"]*)\"")
      public void exampleOne(final String param)  {
         final FinderEmailSubStepImplementations finder = new FinderEmailSubStepImplementations();
         finder.assertEmailReceived("test@example.com", "test-subject");
         ...
      
