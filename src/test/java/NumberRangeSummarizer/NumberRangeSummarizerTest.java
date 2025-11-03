package NumberRangeSummarizer;
import org.junit.jupiter.api.Test;
import java.util.Collection;

class NumberRangeSummarizerTest {

    private final NumberRangeSummarizer numSummarizer = new NumberRangeSummarizer();

    protected String input ="";
    protected Collection<Integer> collect;

    @Test()
    public void testCollectionInputErrorCheck() {
        input = "1,3,@, m";

        collect = numSummarizer.collect(input);

    }

}