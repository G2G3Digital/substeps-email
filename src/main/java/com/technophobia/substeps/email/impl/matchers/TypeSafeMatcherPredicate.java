package com.technophobia.substeps.email.impl.matchers;

import org.hamcrest.TypeSafeMatcher;

/**
 * A Hamcrest matcher capable of being used as a Predicate
 */
public abstract class TypeSafeMatcherPredicate<T> extends TypeSafeMatcher<T> implements MatcherPredicate<T> {

    public boolean apply(final T input) {
        return matchesSafely(input);
    }

}
