package primenumbers.utils;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static java.util.Map.entry;

import org.junit.Before;
import org.junit.Test;

public class ExcelReaderTest {
	
	private ExcelReader reader;
	
	private final Map<Integer, List<String>> data = Map.ofEntries(
		    entry(2, new ArrayList<>( Arrays.asList(null,"5645641", null))), 
		    entry(3, new ArrayList<>( Arrays.asList(null,"5645657", null))),
		    entry(4, new ArrayList<>( Arrays.asList(null,"5799555", null))), 
		    entry(5, new ArrayList<>( Arrays.asList(null,"15619", null))),
		    entry(6, new ArrayList<>( Arrays.asList(null,"5221652", null))), 
		    entry(7, new ArrayList<>( Arrays.asList(null,"1234187", null))),
		    entry(8, new ArrayList<>( Arrays.asList(null,"9584", null))), 
		    entry(9, new ArrayList<>( Arrays.asList(null," 211", null))),
		    entry(10, new ArrayList<>( Arrays.asList(null,"7", null))), 
		    entry(11, new ArrayList<>( Arrays.asList(null,"9785", null))),
		    entry(12, new ArrayList<>( Arrays.asList(null,"65132114", null))), 
		    entry(13, new ArrayList<>( Arrays.asList(null,"9788677", null))),
		    entry(14, new ArrayList<>( Arrays.asList(null,"23311", null))), 
		    entry(15, new ArrayList<>( Arrays.asList(null,"54881", null))),
		    entry(16, new ArrayList<>( Arrays.asList(null,"21448", null))), 
		    entry(17, new ArrayList<>( Arrays.asList(null,"28", null))),
		    entry(18, new ArrayList<>( Arrays.asList(null,"2147483647", null))), 
		    entry(19, new ArrayList<>( Arrays.asList(null,"x"))),
		    entry(1, new ArrayList<>( Arrays.asList(null,"Data", null)))
		);
	
	@Before
	public void setUp() throws Exception {
		this.reader = new ExcelReader();
	}

	@Test
	public void loadExcel() {
		try {
			Path path = Paths.get(getClass().getClassLoader().getResource("vzorek_dat.xlsx").toURI());
			assertEquals(data,reader.readExcel(path.toString()));
		} catch (URISyntaxException | IOException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
