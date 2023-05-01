package nl.utwente.di.bookQuote;

import java.io.*;
import java.util.HashMap;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

/** Example of a Servlet that gets an ISBN number and returns the book price
 */

public class BookQuote extends HttpServlet {
 	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Quoter quoter;
    private HashMap<String,Double> bookPrices = new HashMap<>();
	
    public void init() throws ServletException {
        bookPrices.put("1",10.0);
        bookPrices.put("2",45.0);
        bookPrices.put("3",20.0);
        bookPrices.put("4",35.0);
        bookPrices.put("5",50.0);
    	quoter = new Quoter(bookPrices);
    }	
	
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    String title = "Book Quote";
    
    // Done with string concatenation only for the demo
    // Not expected to be done like this in the project
    out.println("<!DOCTYPE HTML>\n" +
                "<HTML>\n" +
                "<HEAD><TITLE>" + title + "</TITLE>" +
                "<LINK REL=STYLESHEET HREF=\"styles.css\">" +
                		"</HEAD>\n" +
                "<BODY BGCOLOR=\"#FDF5E6\">\n" +
                "<H1>" + title + "</H1>\n" +              
                "  <P>ISBN number: " +
                   request.getParameter("isbn") + "\n" +
                "  <P>Price: " +
                   quoter.getBookPrice(request.getParameter("isbn")) +
                "</BODY></HTML>");
  }
}
