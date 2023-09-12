
public class Search {
	
	private String title;
	private String jobType;
	private String employer;
	private String expires;
	private String year;
	private String salary;
	private String location;
	private String roles;
	
	public Search(String title, String jobType, String employer, String expires, String year, String salary, String location, String roles)
	{
		this.title = title;
		this.jobType = jobType;
		this.employer = employer;
		this.expires = expires;
		this.year = year;
		this.salary = salary;
		this.location = location;
		this.roles = roles;
	}
	
	public Search(String line)
	{
		String[] array = line.split("	");;
		
		this.title = array[0];
		this.jobType = array[1];
		this.employer = array[2];
		this.expires = array[3];
		this.year = array[4];
		this.salary = array[8];
		this.location = array[10];
		this.roles = array[11];
	}
	
	// Getters
	
	public String getTitle()
	{
		return title;
	}
	
	public String getJobType()
	{
		return jobType;
	}
	
	public String getEmployer()
	{
		return employer;
	}
	
	public String getExpiration()
	{
		return expires;
	}
	
	public String getYear()
	{
		return year;
	}
	
	public String getSalary()
	{
		return salary;
	}
	
	public String getLocation()
	{
		return location;
	}
	
	public String getRoles()
	{
		return roles;
	}
	
	public String toString() // Needs to be updated
	{
		return("Title: " + title + "\n" + "Job Type: " + jobType + "\n" + "Employer: " + employer + 
				"\n"  + "Expires: " + expires + "\n" + "Year: " + year);
	}
}
