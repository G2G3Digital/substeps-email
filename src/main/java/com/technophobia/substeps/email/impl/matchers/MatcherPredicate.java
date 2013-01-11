package com.technophobia.substeps.email.impl.matchers;

import com.google.common.base.Predicate;
import org.hamcrest.Matcher;

public interface MatcherPredicate<T> extends Matcher<T>, Predicate<T> {
}
