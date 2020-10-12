package loadAutomation;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class WriteData {
	
	public static void WriteToFile(String str) throws FileNotFoundException {
		PrintWriter fos = new PrintWriter("C:\\Users\\iliyash\\OfficeTools\\LoadTestFramework\\OutputFile\\Loadtest.txt");
		fos.println(str+",live,en-US");
		fos.close();
	}
}