package test.com.ltp.composite.service.impl;

import com.ltp.composite.model.ContainerPart;
import com.ltp.composite.model.Part;
import com.ltp.composite.parser.TextParser;
import com.ltp.composite.service.FilteringService;
import com.ltp.composite.service.impl.FilteringServiceImpl;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FilteringServiceTest {

    private FilteringService filteringService;

    @BeforeClass
    public void init(){
        filteringService = new FilteringServiceImpl();
    }

    @Test
    public void filterByWordsTest(){
        Part text = TextParser.parse("\tHello.\n\tTest for. Now o. Hey. Dude. Just say hello!");
        filteringService.filterByWords((ContainerPart)text, 2);
        String expected = "\tTest for. Now o. Just say hello!";
        String actual = text.toString();
        AssertJUnit.assertEquals(expected, actual);
    }

    @AfterClass
    public void terminate(){
        filteringService = null;
    }

}
