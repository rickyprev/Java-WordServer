package csc312.servlet;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

public class WordFinder extends HttpServlet {
	
	//
	// HttpServletRequest : information about the request
	//
	// HttpServletResponse : what will be the response
	//
	// workflow: https://jorosjavajams.wordpress.com/servlet-workflow/
	//
	
	
public char[][] randomizeBoard(char[][] gameBoard){
	
	//populating the gameBoard
	Random rand =new Random();	//to give random letters in each position of the board
	
	String alphabet="abcdefghijklmnopqrstuvwxyz";
	
	for(int i=0;i<5;i++)
	{
		for(int k=0;k<5;k++)
		{
			
			gameBoard[i][k]=alphabet.charAt(rand.nextInt(alphabet.length()));	//generates a random letter from the alphabet above
			
		}
		
		
	}
	
	
	return null;	

}


			
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

    	//http status: https://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html 2xx (ok), 3xx(moved, ...), 4xx(client error), 5xx(server error)
    	//
    	//the browser will react based on the status code such as: to display the content, redirect to the alternate url, display an error page
    	resp.setStatus( HttpServletResponse.SC_OK);

    	//parameter on the URL  http://localhost:8080//wordfinder?contest=<contest id>&game=<1 to 3>&pos=<column><row>
    	//returns the value of a parameter on the url
    	
    	try
    	{
    		
    	
    	
    	String contestId = req.getParameter("contest");
    	String gameNum=req.getParameter("game");
    	String position=req.getParameter("pos");	//example: a1 or b4
    	
    	int rowInt=Integer.parseInt(position.substring(1))-1;
    	
    	String column=position.substring(0, 1);
    	column=column.toLowerCase();
    	int columnInt=0;
    	char[][] gameBoard = new char[5][5];
    	
    	this.randomizeBoard(gameBoard);
    	
    	
        ServletOutputStream out = resp.getOutputStream();

    	
    	//show gameBoard
    	
    	//MAKE SURE TO SUBTRACT 1 FOR VALUE OF INCOMING ROW TO WORK ON GAMEBOARD	

    	switch(column){
    	
    	case "a":columnInt=0;break;
    	case "b":columnInt=1;break;
    	case "c":columnInt=2;break;
    	case "d":columnInt=3;break;
    	case "e":columnInt=4;break;

    	default: 
           //out.write("SC_BAD_REQUEST".getBytes());
        	resp.setStatus( HttpServletResponse.SC_BAD_REQUEST);
    
    	};	//end switch
    	
    	switch(rowInt){
    	
    	case 1:break;
    	case 2:break;
    	case 3:break;
    	case 4:break;
    	case 5:break;

    	default: 
    		
           // out.write("SC_BAD_REQUEST".getBytes());
        	resp.setStatus( HttpServletResponse.SC_BAD_REQUEST);


    	};	//end switch
    	
    	
    	
    	
    	
    	if(Integer.parseInt(gameNum)==1)
    	{
    		//solutions for game 1 letters
    		
    		gameBoard[0][0]='z';		//a1:a3 equivalent
    		gameBoard[0][1]='a';
    		gameBoard[0][2]='p';

    		
    	
    		
    		
    	}
    	else if(Integer.parseInt(gameNum)==2)
    	{
    		//solutions for game 2 letters

    		gameBoard[4][2]='z';
    		gameBoard[4][3]='i';		//e3:e5  equivalent
    		gameBoard[4][4]='g';

    		
    		
    		
    	}
    	else if(Integer.parseInt(gameNum)==3)
    	{
    		//solutions for game 3 letters
    
    		gameBoard[1][1]='z';
    		gameBoard[1][1]='a';	//c2:c4	 equivalent
    		gameBoard[1][1]='g';
    		
    		
    	}//end else if
    	
    	
    	
    	
    	
    	
    	
    	
    	//
    	//using the outputstream, you can write your output
    	//based on the mimetype, different encoding may be required
    	//

        out.write(gameBoard[columnInt][rowInt]);
        
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
    	catch(Exception e)
    	{
    		
            ServletOutputStream out = resp.getOutputStream();
            
            //out.write("SC_BAD_REQUEST".getBytes());
        	resp.setStatus( HttpServletResponse.SC_BAD_REQUEST);

    		
    	}



    }
}//end class
