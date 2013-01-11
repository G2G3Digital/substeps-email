package com.technophobia.substeps.email.runner;

import com.technophobia.substeps.email.impl.matchers.MatcherPredicateBuilder;

import javax.mail.internet.MimeMessage;
import java.util.Collection;

/**
 * Holder for runtime data
 */
public class EmailExecutionContext {

    private MatcherPredicateBuilder matcherPredicateBuilder;
    private Collection<MimeMessage> currentMessages;

    public MatcherPredicateBuilder getMatcherPredicateBuilder() {
        return matcherPredicateBuilder;
    }

    public void setMatcherPredicateBuilder(final MatcherPredicateBuilder matcherPredicateBuilder) {
        this.matcherPredicateBuilder = matcherPredicateBuilder;
    }

    public Collection<MimeMessage> getCurrentMessages() {
        return currentMessages;
    }

    public void setCurrentMessages(final Collection<MimeMessage> currentMessages) {
        this.currentMessages = currentMessages;
    }
}
