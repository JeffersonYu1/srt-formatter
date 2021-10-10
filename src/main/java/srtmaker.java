import java.util.*;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class srtmaker {
	public static void main(String[] args) throws Exception
	{
		// setup
	    Scanner keyboard = new Scanner(System.in);
	    ArrayList<String> lines = new ArrayList<String>();
	    
	    System.out.println("Enter the name (including the file extension) of the input text file.");
	    String inputFileName = keyboard.nextLine();
	    
	    try (FileInputStream fis = new FileInputStream("src/test/resources/input/" + inputFileName);
	    	       InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
	    	       BufferedReader reader = new BufferedReader(isr)
	    	  ) {

	    	      String str;
	    	      while ((str = reader.readLine()) != null) {
	    	          String[] temp = str.split(" ");
	    	          for(String each : temp)
	    	          {
	    	        	  lines.add(each);
	    	          }
	    	      }

	    	  } catch (IOException e) {
	    	      e.printStackTrace();
	    	  }
	    
	    System.out.println();
	    System.out.println("Enter the desired name (including the file extension) of the output SRT file.");
	    String outputFileName = keyboard.nextLine();
	    
	    PrintWriter writer = new PrintWriter("src/test/resources/output/" + outputFileName, "UTF-8");   	    
	    
	    for(int i=0; i<lines.size(); i++)
	    {
	    	if(isNewSub(lines, i+1))
	    	{
	    		writer.println(lines.get(i));
	    		writer.println();
	    		continue;
	    	}
	    	
	    	if(isNewSub(lines, i))
	    	{
	    		writer.println(lines.get(i));
	    		writer.println("" + lines.get(i+1) + " " + lines.get(i+2) + " " + lines.get(i+3));
	    		i += 3;
	    		continue;
	    	}
	    	
	    	writer.print(lines.get(i) + " ");
	    }
	    
	    writer.println();
	    
	    System.out.println();
	    System.out.println("Writing complete.");
	    
	    writer.close();
	    keyboard.close();
	}
	
	public static boolean isNewSub(ArrayList<String> lines, int index)
	{
		if(index+3 >= lines.size())
		{
			return false;
		}
		
		String curr = lines.get(index);
		String oneUp = lines.get(index+1);
		String twoUp = lines.get(index+2);
		String threeUp = lines.get(index+3);
		
		if(isInteger(curr) && ("" + Integer.parseInt(curr)).equals(curr))
		{
			if(oneUp.matches("\\d\\d:\\d\\d:\\d\\d,\\d\\d\\d") && threeUp.matches("\\d\\d:\\d\\d:\\d\\d,\\d\\d\\d") && twoUp.equals("-->"))
			{
				return true;
			}
		}
		
		return false;
	}
	
	public static boolean isInteger(String s) {
	    try { 
	        Integer.parseInt(s); 
	    } catch(NumberFormatException e) { 
	        return false; 
	    } catch(NullPointerException e) {
	        return false;
	    }
	    return true;
	}
}