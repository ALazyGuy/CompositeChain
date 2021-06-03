package test.com.ltp.composite.parser;

import com.ltp.composite.model.Token;
import com.ltp.composite.parser.TextParser;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TextParserTest {

    private String expected;

    @BeforeClass
    public void init(){
        expected = "\tHello man, it is just a test. Don't worry about anything.\n\tDo you think that it gonna work? Yes, I think so!";
    }

    @Test
    public void parse(){
        Token text = TextParser.parse(expected);
        String actual = text.toString();
        AssertJUnit.assertEquals(expected, actual);
    }

    @AfterClass
    public void terminate(){
        expected = null;
    }

}
