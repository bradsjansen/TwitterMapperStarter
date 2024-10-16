package filters;

import twitter4j.Status;

import java.util.List;

/**
 * A filter that represents the logical and of its child filter
 */

public class AndFilter implements Filter{
    private final Filter child0;
    private final Filter child1;

    public AndFilter(Filter child) {
        this.child0 = child;
        this.child1 = child;
    }


    public boolean matches(Status s0, Status s1) {
        return (child0.matches(s0) && child1.matches(s1)) || (child0.matches(s1) && child1.matches(s0));
    }

    /**
     * Returns true if the filter matches the given tweet
     *
     * @param s the tweet to check
     * @return whether or not the tweet matches this filter
     */
    @Override
    public boolean matches(Status s) {
        return false;
    }

    /**
     * Get all the terms (strings in basic filters) used in this filter.
     * When we query the Twitter API, we must indicate all the terms we are
     * interested in, and this allows us to collect them up for each active query.
     *
     * @return a list of terms mentioned in this filter
     */
    @Override
    public List<String> terms() {
        return child.terms();
    }

    public String toString() {
        return "and " + child.toString();
    }
}
