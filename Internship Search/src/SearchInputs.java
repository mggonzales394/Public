import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class SearchInputs {
	
	private ArrayList<Search> list;  
	
	public SearchInputs()
	{
		list = new ArrayList<Search>();
	}
	
	// Finder by Job Type and Year
	
	public ArrayList<String> titlesIdeal(String jobType, String year)
	{
		ArrayList<String> titles = new ArrayList<String>();
		
		for(int i = 0; i < list.size(); ++i)
		{
			Search job = list.get(i);
			
			if(job.getJobType().equals(jobType) && job.getYear().contains(year) && !job.getSalary().equals("Opted out"))
			{
				titles.add(job.getTitle());
			}
		}
		return titles;
	}
	
	public ArrayList<String> employersIdeal(String jobType, String year)
	{
		ArrayList<String> employers = new ArrayList<String>();
		
		for(int i = 0; i < list.size(); ++i)
		{
			Search job = list.get(i);
			
			if(job.getJobType().equals(jobType) && job.getYear().contains(year) && !job.getSalary().equals("Opted out"))
			{
				employers.add(job.getEmployer());
			}
		}
		return employers;
	}
	
	public ArrayList<String> expirationIdeal(String jobType, String year)
	{
		ArrayList<String> expirations = new ArrayList<String>();
		
		for(int i = 0; i < list.size(); ++i)
		{
			Search job = list.get(i);
			
			if(job.getJobType().equals(jobType) && job.getYear().contains(year) && !job.getSalary().equals("Opted out"))
			{
				expirations.add(job.getExpiration());
			}
		}
		return expirations;
	}
	
	public ArrayList<String> salariesIdeal(String jobType, String year)
	{
		ArrayList<String> salaries = new ArrayList<String>();
		
		for(int i = 0; i < list.size(); ++i)
		{
			Search job = list.get(i);
			
			if(job.getJobType().equals(jobType) && job.getYear().contains(year) && !job.getSalary().equals("Opted out"))
			{
				salaries.add(job.getSalary());
			}
		}
		return salaries;
	}
	
	public ArrayList<String> locationsIdeal(String jobType, String year)
	{
		ArrayList<String> locations = new ArrayList<String>();
		
		for(int i = 0; i < list.size(); ++i)
		{
			Search job = list.get(i);
			
			if(job.getJobType().equals(jobType) && job.getYear().contains(year) && !job.getSalary().equals("Opted out"))
			{
				locations.add(job.getLocation());
			}
		}
		return locations;
	}
	
	//Finders by Major
	
	public ArrayList<String> locationsByMajor(String jobType)
	{
		ArrayList<String> locations = new ArrayList<String>();
		
		for(int i = 0; i < list.size(); ++i)
		{
			Search job = list.get(i);
			
			if(job.getRoles().contains(jobType))
			{
				locations.add(job.getLocation());
			}
		}
		return locations;
	}
	
	
	
	//Finders by Job Type
	
	public ArrayList<String> findTitlesByJobType(String input)
	{
		ArrayList<String> titles = new ArrayList<String>();
		
		for(int i = 0; i < list.size(); ++i)
		{
			Search job = list.get(i);
			
			if(job.getJobType().equals(input))
			{
				titles.add(job.getTitle());
			}
		}
		return titles;
	}
	
	public ArrayList<String> findEmployersByJobType(String input)
	{
		ArrayList<String> employers = new ArrayList<String>();
		
		for(int i = 0; i < list.size(); ++i)
		{
			Search job = list.get(i);
			
			if(job.getJobType().equals(input))
			{
				employers.add(job.getEmployer());
			}
		}
		return employers;
	}
	
	public ArrayList<String> findExpirationByJobType(String input)
	{
		ArrayList<String> expirations = new ArrayList<String>();
		
		for(int i = 0; i < list.size(); ++i)
		{
			Search job = list.get(i);
			
			if(job.getJobType().equals(input))
			{
				expirations.add(job.getExpiration());
			}
		}
		return expirations;
	}
	
	
	// Finders by Year
	
	public ArrayList<String> findTitlesByYear(String input)
	{
		ArrayList<String> titles = new ArrayList<String>();
		
		for(int i = 0; i < list.size(); ++i)
		{
			Search job = list.get(i);
			
			if(job.getYear().contains(input))
			{
				titles.add(job.getTitle());
			}
		}
		return titles;
	}
	
	public ArrayList<String> findEmployersByYear(String input)
	{
		ArrayList<String> employers = new ArrayList<String>();
		
		for(int i = 0; i < list.size(); ++i)
		{
			Search job = list.get(i);
			
			if(job.getYear().contains(input))
			{
				employers.add(job.getEmployer());
			}
		}
		return employers;
	}
	
	public ArrayList<String> findExpirationsByYear(String input)
	{
		ArrayList<String> expirations = new ArrayList<String>();
		
		for(int i = 0; i < list.size(); ++i)
		{
			Search job = list.get(i);
			
			if(job.getYear().contains(input))
			{
				expirations.add(job.getExpiration());
			}
		}
		return expirations;
	}
	
	
	// Retrieves all of the titles in a given data file
	public ArrayList<String> retrieveTitles()
	{
		ArrayList<String> titles = new ArrayList<String>();
		
		for(int i = 0; i < list.size(); ++i)
		{
			Search item = list.get(i);
			
			titles.add(item.getTitle());
		}
		
		return titles;
	}

	public void readFile(String fileName)
			throws FileNotFoundException, IOException  {
				
		Scanner file = new Scanner(new File(fileName));
				
		while (file.hasNextLine()) {
			
			String line = file.nextLine();
			
			Search selection = new Search(line);
			
			list.add(selection);
		}
		
		file.close();
	}
	
	public static void prettyPrint(String jobType, ArrayList<String> titleList, ArrayList<String> employerList, ArrayList<String> expirationList, 
									ArrayList<String> salariesList, ArrayList<String> locationslist)
	{
		if (titleList.size() == 0)
		{
			System.out.println("");
			System.out.println("There are no job listings with those parameters :(");
			System.out.println("");
		}
		
		for (int i = 0; i < titleList.size(); ++i)
		{
			System.out.println(jobType+ " " + (i+1) + ".");
			System.out.println("Title: " + titleList.get(i));
			System.out.println("Employer: " + employerList.get(i));
			System.out.println("Expiration: " + expirationList.get(i));
			System.out.println("Salary: " + salariesList.get(i));
			System.out.println("Location: " + locationslist.get(i));

			System.out.println("");
		}
	}
}
