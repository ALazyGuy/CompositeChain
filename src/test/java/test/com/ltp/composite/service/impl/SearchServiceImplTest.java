package test.com.ltp.composite.service.impl;

import com.ltp.composite.model.ContainerPart;
import com.ltp.composite.model.Part;
import com.ltp.composite.parser.TextParser;
import com.ltp.composite.service.SearchService;
import com.ltp.composite.service.impl.SearchServiceImpl;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SearchServiceImplTest {

    private Part parsed1, parsed2;
    private SearchService searchService;

    @BeforeClass
    public void init(){
        parsed1 = TextParser.parse("\tHello!\n\tIt is just a test! Dont worry. So simple?");
        parsed2 = TextParser.parse("Hey, hey, heY, hEy, heey");

        searchService = new SearchServiceImpl();
    }

    @Test
    public void withLongestWordTest(){
        String expected = "So simple?";
        Part found = searchService.withLongestWord((ContainerPart)parsed1);
        String actual = found.toString();
        AssertJUnit.assertEquals(expected, actual);
    }

    @Test
    public void countTest(){
        long expected = 4;
        long actual = searchService.count("HEY", (ContainerPart)parsed2);
        AssertJUnit.assertEquals(expected, actual);
    }

    @AfterClass
    public void terminate(){
        parsed1 = parsed2 = null;
        searchService = null;
    }
}
