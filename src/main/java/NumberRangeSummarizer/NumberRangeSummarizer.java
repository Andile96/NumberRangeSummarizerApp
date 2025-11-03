package NumberRangeSummarizer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class NumberRangeSummarizer implements INumberRangeSummarizer
{
    @Override
    public Collection<Integer> collect(String input) {
        if((input == null) || input.trim().isEmpty())
        {
            return new ArrayList<>();
        }

        try {
            String[] split = input.split(",");
            List<Integer> num = new ArrayList<>();


            for (String s : split)
            {
                num.add(Integer.parseInt(s.trim()));
            }

            Collections.sort(num);

            return num.stream().distinct().toList();

        } catch (NumberFormatException e) {

            System.out.println("Invalid input. Try again, Only numbers and commas are allowed!.");
            return Collections.emptyList();

        }
    }

    @Override
    public String summarizeCollection(Collection<Integer> input) {
        if(input == null || input.isEmpty()) return "";

        List<Integer> numbers = new ArrayList<>(input);


        StringBuilder output = new StringBuilder();

        int start = numbers.getFirst(), end = numbers.getFirst();

        for (int i = 1; i < input.size(); i++)
        {
            int curr = numbers.get(i);

            if(curr == end + 1 )
            {
                end = curr;
            }
            else {
                getRange(output, start, end);
                start = end = curr;
            }
        }

        getRange(output, start, end);
        return output.toString();
    }
}
