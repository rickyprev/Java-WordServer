package csc312.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Solution extends HttpServlet {

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

    	//parameter on the URL http://localhost:8000//solution?contest=41&game=1&solution=zap
    	//returns the value of a parameter on the url
    	String contestId = req.getParameter("contest");
    	String gameNum=req.getParameter("game");
    	String solution=req.getParameter("solution");
    	boolean solved=false;
    	String wordFound="";
    	
    	
    	//using the outputstream, you can write your output

        ServletOutputStream out = resp.getOutputStream();
        
        if(Integer.parseInt(gameNum)==1)
        {
           	if(solution.equals("zap"))
        	{
        		solved=true;
        		wordFound="zap";
        	}
        }
        else if(Integer.parseInt(gameNum)==2)
        {
        	if(solution.equals("zig"))
        	{
        		solved=true;
        		wordFound="zig";

        	}
        	
        }
        else if(Integer.parseInt(gameNum)==3)
        {
        	if(solution.equals("zag"))
        	{
        		solved=true;
        		wordFound="zag";

        	}
        	
        }
        else
        {
        	out.write("SC_BAD_REQUEST".getBytes());
        	
        }

        out.write("this is the solution page\n\n".getBytes());
        
        if(solved==true)
        {
        	//game was solved
        	out.write("You solved puzzle for game ".getBytes());
        	out.write(gameNum.getBytes());
        	out.write("\nThe word found was \n".getBytes());
        	out.write(wordFound.getBytes());




        	
        }
        else
        {
        	//incorrect solution attempt
        	out.write("Incorrect solution attempt.".getBytes());

        	
        	
        }
        
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
