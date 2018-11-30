package csc312.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NewContest extends HttpServlet {

	//
	// HttpServletRequest : information about the request
	//
	// HttpServletResponse : what will be the response
	//
	// workflow: https://jorosjavajams.wordpress.com/servlet-workflow/
	//
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

    	//http status: https://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html 2xx (ok), 3xx(moved, ...), 4xx(client error), 5xx(server error)
    	//
    	//the browser will react based on the status code such as: to display the content, redirect to the alternate url, display an error page
    	resp.setStatus( HttpServletResponse.SC_OK);

    	
    	
    	
    	Random rand=new Random();
    	int contestId=0;
    	String strContestId="";
    	ArrayList<Integer> usedContestIds = new ArrayList<Integer>();
    	
    	usedContestIds.add(contestId);
    	
    	while(usedContestIds.contains(contestId))
    	{
    		
        	contestId=rand.nextInt(1000)+1;	//generate a new contest Id that hasn't been used yet
        	
        	
    		
    	}//end while
    	
    	
        	
    	
    	//using the outputstream, you can write your output
    	//based on the mimetype, different encoding may be required
    	//
        ServletOutputStream out = resp.getOutputStream();

        out.write("starting a new contest".getBytes());
        
        out.write("\ncontest Id ".getBytes());
        out.write(Integer.toString(contestId).getBytes());

        out.flush();
        out.close();

        //HttpSession : allows to store server side information based on a session cookie. As an example: is your session authenticated or not ?
        //
        //time : creationTime, lastAccessedTime (session expired for inactivity)
        //attribute: getAttribute, removeAttribute -> stored value specific for the session
        //invalidate: invalidates the session, removes from the http context

        //Cookie: HttpServletResponse, addCookie, getCookies
        //
        //Cookie: https://docs.oracle.com/javaee/6/api/javax/servlet/http/Cookie.html
        //


    }

}
