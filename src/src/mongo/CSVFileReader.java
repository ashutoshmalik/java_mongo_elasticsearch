package src.mongo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * 
 * @author ashu
 *
 */
public class CSVFileReader {
	
	private static final String delimiter = ",";

	protected void read(String csvFile) {
		
		try {
			File file = new File(csvFile);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);

			String line = "";
			String[] tempArr;
			
			boolean flag = false;
			while ((line = br.readLine()) != null) {
				tempArr = line.split(delimiter);
				for (String tempStr : tempArr) {
					System.out.print(tempStr + " ");
				}
				System.out.println();				
				flag = true;
				if (flag) break;
			}
			br.close();

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
