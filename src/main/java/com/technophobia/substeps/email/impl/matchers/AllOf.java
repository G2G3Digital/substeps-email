package com.technophobia.substeps.email.impl.matchers;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;

import java.util.Arrays;

/**
 * Calculates the logical conjunction of multiple matchers. Evaluation is shortcut, so
 * subsequent matchers are not called if an earlier matcher returns <code>false</code>.
 * <p/>
 * Copied and tweaked from Hamcrest core to support sub-types of Matcher in allOf(Iterable...)
 */
public class AllOf<T> extends BaseMatcher<T> {
    private final Iterable<? extends Matcher<? extends T>> matchers;

    public AllOf(Iterable<? extends Matcher<? extends T>> matchers) {
        this.matchers = matchers;
    }

    public boolean matches(Object o) {
        for (Matcher<? extends T> matcher : matchers) {
            if (!matcher.matches(o)) {
                return false;
            }
        }
        return true;
    }

    public void describeTo(Description description) {
        description.appendList("(", " and ", ")", matchers);
    }

    /**
     * Evaluates to true only if ALL of the passed in matchers evaluate to true.
     */
    @Factory
    public static <T> Matcher<T> allOf(Matcher<? extends T>... matchers) {
        return allOf(Arrays.asList(matchers));
    }

    /**
     * Evaluates to true only if ALL of the passed in matchers evaluate to true.
     */
    @Factory
    public static <T> Matcher<T> allOf(Iterable<? extends Matcher<? extends T>> matchers) {
        return new AllOf<T>(matchers);
    }

}
