package primenumbers.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import java.util.HashMap;
import java.util.ArrayList;
import java.io.FileInputStream;

import org.dhatim.fastexcel.reader.Row;
import org.dhatim.fastexcel.reader.Sheet;
import org.dhatim.fastexcel.reader.Cell;
import org.dhatim.fastexcel.reader.ReadableWorkbook;

public class ExcelReader {
	
	public Map<Integer, List<String>> readExcel(String fileLocation) throws IOException {
		Map<Integer, List<String>> data = new HashMap<>();
		try (FileInputStream file = new FileInputStream(fileLocation); ReadableWorkbook wb = new ReadableWorkbook(file)) {
			Sheet sheet = wb.getFirstSheet();
			try (Stream<Row> rows = sheet.openStream()) {
				rows.forEach(r -> {
					data.put(r.getRowNum(), new ArrayList<>());
					
					for (Cell cell : r) {
						if (cell != null){
							data.get(r.getRowNum()).add(cell.getRawValue());
						}
						else {
							data.get(r.getRowNum()).add(null);
						}
					}
				});
			}
		}
		return data;
	}
}
