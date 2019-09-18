package filetransactions;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import journey.Journey;

public class OurFileWriter {
	public Journey journey;
	public void writeFile(String path,FileDescriptor fileDescriptor) {
		journey = new Journey();
		journey.startJourney(fileDescriptor);
		try {
			FileWriter fileWriter = new FileWriter(path);
			BufferedWriter bufferredWriter = new BufferedWriter(fileWriter);
			
			for(int i = 0; i <journey.writeToFileStringList.size(); i++) {
				bufferredWriter.write(journey.writeToFileStringList.get(i)+"\n");
	
			}
			
			bufferredWriter.flush();
			bufferredWriter.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
