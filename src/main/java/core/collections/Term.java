package core.collections;

/**
 * Created by Kyle on 7/8/15.
 */
public class Term {
    private String text;
    private int termId;

    public Term(int termId, String text) {
        this.termId = termId;
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public int getTermId() {
        return termId;
    }
}
