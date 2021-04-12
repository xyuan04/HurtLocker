import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ParserTest {

    @Test
    public void testSplitByPound() {
        //Given
        Parser parse = new Parser();

        //When
        ArrayList<String> split = parse.splitByPound();

        //Then
        Assert.assertTrue(split.size() == 28);
    }

    @Test
    public void testOutput() {
        //Given
        Parser parse = new Parser();

        //When
        ArrayList<String> split = parse.splitByPound();
        parse.stringOutput();
        System.out.println(parse.getOutput());

        //Then
        Assert.assertTrue(split.size() == 28);
    }

    @Test
    public void testCounter() {
        //Given
        Parser parse = new Parser();

        //When
        ArrayList<String> split = parse.splitByPound();
        parse.stringOutput();
        int counter = parse.counter("[cC][oO][oO][kK][iI][eE][sS]");
        System.out.println(counter);

        //Then
        Assert.assertTrue(counter == 7);
    }

}