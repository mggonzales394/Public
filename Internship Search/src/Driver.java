import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args)throws FileNotFoundException, IOException
	{
		Scanner keyboard = new Scanner(System.in);
		
		// TESTING
		
		System.out.println("Welcome to the Job Search Program!");
		System.out.println("");
		
		
		System.out.println("Enter your desired job type (Job or Internship) or enter 'quit' to exit:");
				
		String jobType = keyboard.next();
		
		while (!jobType.equals("quit"))
		{
			while (!jobType.equals("Internship") && !(jobType.equals("Job")))
			{
				System.out.println("Please enter a valid input (Job or Internship)");
				
				jobType = keyboard.next();
			}
			
			System.out.println("Please enter 1-13 for your specified major:");
			System.out.println("");
			
			System.out.println(
					"1 - Aerospace \r\n"
					+ "2 - Architectural\r\n"
					+ "3 - Biomedical\r\n"
					+ "4 - Chemical\r\n"
					+ "5 - Civil\r\n"
					+ "6 - Computer Engineering\r\n"
					+ "7 - Computer Science\r\n"
					+ "8 - Electrical\r\n"
					+ "9 - Environmental Engineering\r\n"
					+ "10 - Environmental Science\r\n"
					+ "11 - Industrial \r\n"
					+ "12 - Mechanical\r\n"
					+ "13 - Engineering Physics\r\n"
					+ "-----------------");
			
			int major = keyboard.nextInt();
			
			while (major < 0 || major > 13)
			{
				System.out.println("Please enter a valid input (1-13)");
				
				major = keyboard.nextInt();
			}
		
			System.out.println("Enter current year (Freshman, Sophomore, Junior, Senior, Masters, Doctrate)");
			
			String year = keyboard.next();
						
			findIdealPositions(jobType, year, major);
			
			System.out.println(" ------------------------------------ ");
			
			System.out.println("Enter desired job type (Job or Internship)");
			
			jobType = keyboard.next();
		}
		keyboard.close();
		
		System.out.println("Goodbye!");

	}
	
	public static void findIdealPositions(String jobType, String year, int major) throws FileNotFoundException, IOException
	{
		SearchInputs list = new SearchInputs();
		
		ArrayList<String> majors = new ArrayList<String>();
		
		majors.add("0");
		majors.add("Aerospace.txt");
		majors.add("Architectural.txt");
		majors.add("Biomedical.txt");
		majors.add("Chemical.txt");
		majors.add("Civil.txt");
		majors.add("Computer Engineering.txt");
		majors.add("Computer Science.txt");
		majors.add("Electrical.txt");
		majors.add("Environmental Engineering.txt");
		majors.add("Environmental Science.txt");
		majors.add("Industrial.txt");
		majors.add("Mechanical.txt");
		majors.add("Engineering Physics.txt");
		
		String majorType = majors.get(major);

		list.readFile(majorType);
				
		ArrayList<String> titles = list.titlesIdeal(jobType, year);
		ArrayList<String> employers = list.employersIdeal(jobType, year);
		ArrayList<String> expirations = list.expirationIdeal(jobType, year);
		ArrayList<String> salaries = list.salariesIdeal(jobType, year);
		ArrayList<String> locations = list.locationsIdeal(jobType, year);
		
		SearchInputs.prettyPrint(jobType, titles, employers, expirations, salaries, locations); 
	}
	
}
