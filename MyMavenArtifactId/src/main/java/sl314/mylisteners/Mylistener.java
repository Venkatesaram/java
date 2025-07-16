package sl314.mylisteners;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import java.io.*;
import java.util.*;
import jakarta.servlet.*;

/**
 * Application Lifecycle Listener implementation class MyListener
 *
 */
@WebListener
public class Mylistener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public Mylistener() {
        // TODO Auto-generated constructor stub
    }
    public void contextInitialized(ServletContextEvent sce) 
    {
    	
    	ArrayList<String> myLeagues=new ArrayList<String>();
    	ServletContext sc=sce.getServletContext();
    	String leaguesFilePath=sc.getInitParameter("leaguesFile");
    	
    	InputStream is=null;
    	BufferedReader br=null;
    	try
    	{
    		is=sc.getResourceAsStream(leaguesFilePath);
    		br=new BufferedReader(new InputStreamReader(is));
    		String str;
    		while((str=br.readLine())!=null)
    		{
    			if(!str.equals(""))
    			{
    				myLeagues.add(str);
    			}
    		}
    	}
    	catch(IOException ioe)
    	{
    		ioe.printStackTrace();
    	}
    	finally
    	{
    		try
    		{
    			is.close();
    			br.close();
    		}
    		catch(IOException ioe)
    		{
    			ioe.printStackTrace();
    		}
    	}
    	
    	sc.setAttribute("myLeagues", myLeagues);
    	
    }
	
}
