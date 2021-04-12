import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {

    @Test
    public void testSplitByPound() {
        //Given
        Parser parse = new Parser();

        //When
        String split = parse.splitByPound();

        //Then
        System.out.println(split);
    }

}