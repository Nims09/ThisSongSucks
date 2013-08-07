import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class CSVReader 
{
	public static void main (String[] args)
	{
		String username = System.getProperty("user.name");
		String filepath = "/Users/" + username + "/Music/_Serato_/History Export/13-02-24.csv";
		BufferedReader br = null;
		String line = "";
		String separator = ",";
		
		try
		{
			br = new BufferedReader(new FileReader(filepath));
			while ((line = br.readLine()) != null) {
	 
			        // use comma as separator
				String[] track = line.split(separator);
	 
				System.out.println("Track: " + track[0] + " " + track[6]);
	 
			}
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}
