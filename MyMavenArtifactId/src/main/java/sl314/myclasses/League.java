package sl314.myclasses;

import java.io.Serializable;

public class League implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int year;
	String season;
	String title;
	
	public League()
	{
		this.year=0;
		this.season="";
		this.title="";
	}
	
	public void setYear(int year)
	{
		this.year=year;
	}
	
	public int getYear()
	{
		return this.year;
	}
	
	public void setSeason(String season)
	{
		this.season=season;
	}
	
	public String getSeason()
	{
		return this.season;
	}
	
	public void setTitle(String title)
	{
		this.title=title;
	}
	
	public String getTitle()
	{
		return title;
	}

}
