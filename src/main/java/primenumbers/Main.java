package primenumbers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import primenumbers.facades.PrimesReader;

public class Main {
	
	private static final Logger logger = LogManager.getLogger();

	public static void main(String args[]) {
		PrimesReader primesReader = new PrimesReader();
		String path = args[0];
		logger.info("Imported excel file is: " + path);

		for(String line : primesReader.getPrimesFromFileByColumn(path, 1)) {
			logger.info(line);
		}
	}
}
