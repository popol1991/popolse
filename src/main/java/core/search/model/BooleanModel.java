package core.search.model;

/**
 * Created by Kyle on 10/9/15.
 */
public class BooleanModel extends Model {
    @Override
    public double score(Long doc) {
        return 1;
    }
}
