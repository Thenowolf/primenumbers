package primenumbers.facades;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import primenumbers.utils.ExcelReader;

public class PrimesReaderTest {

	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
	private PrimesReader primesReader;
	
	@Before
	public void setUp() throws Exception {
		primesReader = new PrimesReader();
	}

	@Test
	public void testMocked() {
		final ExcelReader reader = mock(ExcelReader.class);
		Map<Integer, List<String>> data = new HashMap<>();
		
		for(int i = 0; i < 7; i++) {
			data.put(i, new ArrayList<>());
		}
		
		data.get(0).add("8663621");
		data.get(1).add("2434699");
		data.get(2).add("7581466577");
		data.get(3).add("string");
		data.get(4).add("-422");
		data.get(5).add(" 211");
		data.get(6).add("65132114");
		
		try {
			when(reader.readExcel("soubor.xlsx")).thenReturn(data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PrimesReader primesReader = new PrimesReader() {
			@Override
			protected ExcelReader createExcelReader() {
				return reader;
			}
		};
		
		List<String> primesList = new ArrayList<String>();
		primesList.add("8663621");
		primesList.add("2434699");
		primesList.add("7581466577");
		
		assertEquals(primesReader.getPrimesFromFileByColumn("soubor.xlsx", 0), primesList);
	}
	
	@Test
	public void testNullFile() {
		assertEquals(new ArrayList<String>(), this.primesReader.getPrimesFromFileByColumn(null, 0));
	}
	
	@Test
	public void testNoFile() {
		assertEquals(new ArrayList<String>(), primesReader.getPrimesFromFileByColumn("", 0));
	}
	
	@Test
	public void testNullColumn() {
		assertEquals(new ArrayList<String>(), primesReader.getPrimesFromFileByColumn("test", null));
	}
	
	@Test
	public void testInvalidFormat() {
		assertEquals(new ArrayList<String>(), primesReader.getPrimesFromFileByColumn("test", 0));
	}
	
	@Test
	public void testInvalidFile() {
		assertEquals(new ArrayList<String>(), primesReader.getPrimesFromFileByColumn("test.xlsx", 0));
	}
}
