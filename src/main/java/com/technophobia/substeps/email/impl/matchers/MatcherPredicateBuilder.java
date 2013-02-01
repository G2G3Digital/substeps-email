package com.technophobia.substeps.email.impl.matchers;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import org.hamcrest.Matcher;

import javax.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.List;

import static com.technophobia.substeps.email.impl.matchers.HasContentContaining.hasContentContaining;
import static com.technophobia.substeps.email.impl.matchers.HasContentType.hasContentType;
import static com.technophobia.substeps.email.impl.matchers.HasRecipient.hasRecipient;
import static com.technophobia.substeps.email.impl.matchers.HasSubject.hasSubject;
import static com.technophobia.substeps.email.impl.matchers.HasSubjectContaining.hasSubjectContaining;

/**
 * For building {@link com.google.common.base.Predicate}s for finding or asserting against {@link javax.mail.internet.MimeMessage}s
 * <p/>
 * All Predicates are applied with logical AND in order they are created
 */
public class MatcherPredicateBuilder {

    private List<MatcherPredicate<MimeMessage>> matcherPredicates;

    public MatcherPredicateBuilder() {
        this.matcherPredicates = new ArrayList<MatcherPredicate<MimeMessage>>();
    }

    public MatcherPredicateBuilder withRecipient(String recipient) {
        this.matcherPredicates.add(hasRecipient(recipient));
        return this;
    }

    public MatcherPredicateBuilder withSubject(String subject) {
        this.matcherPredicates.add(hasSubject(subject));
        return this;
    }

    public MatcherPredicateBuilder withSubjectContaining(String partialSubject) {
        this.matcherPredicates.add(hasSubjectContaining(partialSubject));
        return this;
    }

    public MatcherPredicateBuilder withContentType(ContentType contentType) {
        this.matcherPredicates.add(hasContentType(contentType));
        return this;
    }

    public MatcherPredicateBuilder withContentContaining(String expectedContent) {
        this.matcherPredicates.add(hasContentContaining(expectedContent));
        return this;
    }

    public Predicate<MimeMessage> buildPredicate() {
        return Predicates.and(matcherPredicates);
    }

    public Matcher<MimeMessage> buildMatcher() {
        return AllOf.allOf(matcherPredicates);
    }
}
