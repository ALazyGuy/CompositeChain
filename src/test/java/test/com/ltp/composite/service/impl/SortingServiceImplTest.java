package test.com.ltp.composite.service.impl;

import com.ltp.composite.model.ContainerPart;
import com.ltp.composite.model.Part;
import com.ltp.composite.parser.TextParser;
import com.ltp.composite.service.SortingService;
import com.ltp.composite.service.impl.SortingServiceImpl;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SortingServiceImplTest {

    private SortingService sortingService;

    @BeforeClass
    public void init(){
        sortingService = new SortingServiceImpl();
    }

    @Test
    public void sortBySentencesTest(){
        Part text = TextParser.parse("Test. Test test test.\n\tTest test.");
        sortingService.sortBySentences((ContainerPart)text);
        String expected = "\tTest test.\n\tTest. Test test test.";
        String actual = text.toString();
        AssertJUnit.assertEquals(expected, actual);
    }

    @AfterClass
    public void terminate(){
        sortingService = null;
    }
}
