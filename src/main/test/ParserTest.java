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

}