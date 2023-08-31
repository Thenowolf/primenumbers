package primenumbers.facades;

import java.io.IOException;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import primenumbers.utils.ExcelReader;
import primenumbers.utils.PrimesValidator;

public class PrimesReader{
	protected static final Logger logger = LogManager.getLogger();
	
	public List<String> getPrimesFromFileByColumn(String file, Integer column) {
		List<String> primesList = new ArrayList<String>();
		
		if(column == null || file == null ){
			logger.error("Null arguments..");
			return primesList;
		}
		
		PrimesValidator primesValidator = new PrimesValidator();

		if(file.contains(".xlsx")) {
			ExcelReader reader = createExcelReader();
			Map<Integer, List<String>> data = new HashMap<>();

			try {
				data = reader.readExcel(file);
			} catch (IOException e) {
				logger.error("Excel file " + file + " couldn't be read");
				return primesList;
			}

			for (Map.Entry<Integer,List<String>> entry : data.entrySet()) {
				if(entry.getValue().get(column).matches("[0-9]+") && BigInteger.valueOf(Long.MAX_VALUE).compareTo(new BigInteger(entry.getValue().get(column))) > 0)
					if(primesValidator.isPrime(Long.parseLong(entry.getValue().get(column)))) {
						primesList.add(entry.getValue().get(column));
					}
			}	
		}
		return primesList;
	}
	
	protected ExcelReader createExcelReader() {
		return new ExcelReader();
	}
}
