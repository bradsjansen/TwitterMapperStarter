package filters;

import twitter4j.Status;

import java.util.List;

/**
 * A filter that represents the logical or of its child filter
 */

public class OrFilter implements Filter {
    private final Filter child;

    public OrFilter(Filter child) {
        this.child = child;
    }

    /**
     * Returns true if the filter matches the given tweet
     *
     * @param s the tweet to check
     * @return whether or not the tweet matches this filter
     */
    @Override
    public boolean matches(Status s) {
        return !child.matches(s);
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
        return "or " + child.toString();
    }
}
