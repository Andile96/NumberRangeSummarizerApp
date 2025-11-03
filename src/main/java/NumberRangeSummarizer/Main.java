package NumberRangeSummarizer;
import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        NumberRangeSummarizer numSummarizer = new NumberRangeSummarizer();

        String input = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";

        Collection<Integer> collect = numSummarizer.collect(input);
        System.out.println(numSummarizer.summarizeCollection(collect));
    }
}
