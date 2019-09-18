package filetransactions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;

public class FileRead {
	public HashMap<Integer, String[]> splittedRowsAddList = new HashMap<Integer, String[]>();
	public HashMap<Integer, String> rowsAddHashMap = new HashMap<Integer, String>();

	public void read(String filePath) {
		Charset charset = Charset.forName("US-ASCII");
		try {
			BufferedReader bufferReader = new BufferedReader(new FileReader(filePath, charset));
			String row = null;
			int counter = 0;
			while ((row = bufferReader.readLine()) != null) {
				String[] rowList = row.split("\\s+");
				splittedRowsAddList.put(counter, rowList);
				rowsAddHashMap.put(counter, row);
				
				counter++;
			}
			bufferReader.close();
		} catch (FileNotFoundException e) {
			System.err.format("FileNotException %s%n", e);
		} catch (IOException e) {
			System.err.format("IOException %s%n", e);
		}
	}

}
