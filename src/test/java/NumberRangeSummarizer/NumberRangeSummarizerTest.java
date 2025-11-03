package NumberRangeSummarizer;
import org.junit.jupiter.api.Test;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberRangeSummarizerTest {

    private final NumberRangeSummarizer numSummarizer = new NumberRangeSummarizer();

    protected String input ="";
    protected Collection<Integer> collect;


    //Testing the functionality of the try catch block in collect method
    @Test()
    public void testCollectionInputErrorCheck() {
        input = "1,3,@, m";

        collect = numSummarizer.collect(input);

    }

    //Checking for all sequential numbers
    @Test
    public void testCollectionOutput() {
        input = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
        collect = numSummarizer.collect(input);
        String output = "1, 3, 6-8, 12-15, 21-24, 31";

        assertEquals(output,numSummarizer.summarizeCollection(collect));
    }

    //Checking for none sequential
    @Test
    public void testCollectionNoSequential() {
        input = "1,3,5,7,9,11,13";
        collect = numSummarizer.collect(input);
        String output = "1, 3, 5, 7, 9, 11, 13";

        assertEquals(output,numSummarizer.summarizeCollection(collect));
    }

    // Checking for range and if numbers are sequential
    @Test
    public void testCollectionSequential() {
        input = "5,6,7,9,10,11";
        collect = numSummarizer.collect(input);
        String output = "5-7, 9-11";

        assertEquals(output,numSummarizer.summarizeCollection(collect));
    }

    // Checking for  sequential numbers in Unordered collection.
    @Test
    public void testCollectionCheckUnOrdersSequential() {
        String input = "5,1,6,3,2,4,7";
        Collection<Integer> collect = numSummarizer.collect(input);
        String output = "1-7";

        assertEquals(output,numSummarizer.summarizeCollection(collect));
    }


    // Checking for  sequential numbers in collection with duplicate numbers.
    @Test
    public void testCollectionCheckDuplicateSequential() {
        input = "1, 2, 2, 3, 4, 4, 5";
        collect = numSummarizer.collect(input);
        String output = "1-5";

        assertEquals(output,numSummarizer.summarizeCollection(collect));
    }

}