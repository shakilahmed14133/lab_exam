import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {
	public static void main(String[] args) {
        if(args.length!=1)
		{
			System.err.println("Invalid number of arguments");
			System.err.println("Exiting program");
			System.exit(1);
		}
        
		if(args[0].equals("a")) {
			System.out.println("Loading data ...");			
			try {
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("students.txt"))); 
			String line = bufferedReader.readLine();
			String students[] = line.split(", ");			
			for(String student : students) {
				 System.out.println(student); 
				 }
			} catch (Exception e){} 
			System.out.println("Data Loaded.");
		}
		else if(args[0].equals("r")) {
			System.out.println("Loading data ...");			
			try {
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("students.txt"))); 
			String line = bufferedReader.readLine();
			
			String students[] = line.split(", ");	
			Random random = new Random();
				int randomLength = random.nextInt(students.length);
					System.out.println(students[randomLength]);
			} catch (Exception e){} 
			System.out.println("Data Loaded.");			
		}
		else if(args[0].contains("+")){
			System.out.println("Loading data ...");			
			try {
			BufferedWriter bufferedWriter = new BufferedWriter(
					new FileWriter("students.txt", true));
			String newString = args[0].substring(1);
	        Date date = new Date();
	        String date_format = "yyyy-mm-dd hh:mm:ss a";
	        DateFormat dateFormat = new SimpleDateFormat(date_format);
	        String format_date= dateFormat.format(date);
			bufferedWriter.write(", "+newString+"\nList last updated on "+format_date);
			bufferedWriter.close();
			} catch (Exception e){}
							
			System.out.println("Data Loaded.");	
		}
		else if(args[0].contains("?")) {
			System.out.println("Loading data ...");			
			try {
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("students.txt"))); 
			String line = bufferedReader.readLine();
			String students[] = line.split(", ");	
			boolean done = false;
			String character = args[0].substring(1);
			for(int index = 0; index<students.length && !done; index++) {
				if(students[index].equals(character)) {
					System.out.println("We found it!");
						done=true;
				}
			}
			} catch (Exception e){} 
			System.out.println("Data Loaded.");				
		}
		else if(args[0].contains("c")) {
			System.out.println("Loading data ...");			
			try {
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("students.txt"))); 
			String line = bufferedReader.readLine();
			char char_array[] = line.toCharArray();			
			boolean in_word = false;
			int counter=0;
			for(char character1:char_array) {
				if(character1 ==' ') 
				{
					if (!in_word) {	
						counter++; 
						in_word =true;
							}
					else {
						 in_word=false;
						 }			
				}
			}
			System.out.println(counter +" word(s) found ");
			} catch (Exception e){} 
			System.out.println("Data Loaded.");				
		}
		else{
			System.out.println("Invalid Arguments");
			System.out.println("Exiting program");
			System.exit(2);
		}
	}
}