import filetransactions.FileDescriptor;
import filetransactions.FileRead;
import filetransactions.OurFileWriter;

public class Test {
	public static void main(String[] args) {

		String simpleInput1FilePath = "/home/cengiz/eclipse-workspace/SaviorProjectCengizYılmaz/FileInputOutput/sampleInput1.txt";
		String simpleInput2FilePath = "/home/cengiz/eclipse-workspace/SaviorProjectCengizYılmaz/FileInputOutput/sampleInput2.txt";
		String simpleOutput1FilePath = "/home/cengiz/eclipse-workspace/SaviorProjectCengizYılmaz/FileInputOutput/sampleOutput1.txt";
		String simpleOutput2FilePath = "/home/cengiz/eclipse-workspace/SaviorProjectCengizYılmaz/FileInputOutput/sampleOutput2.txt";

		FileRead fileRead = new FileRead();
		fileRead.read(simpleInput1FilePath);

		FileDescriptor fileDescriptor = new FileDescriptor();
			
		OurFileWriter fileWriter = new OurFileWriter();

		fileDescriptor.makeEntity(fileRead.splittedRowsAddList);
		fileDescriptor.assignAllValues(fileRead.rowsAddHashMap);
		fileWriter.writeFile(simpleOutput1FilePath, fileDescriptor);

		}
	

}
