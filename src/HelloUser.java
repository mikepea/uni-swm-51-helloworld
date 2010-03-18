/**
* 
* This Sample demonstrates Parameter processing using Servlets and a simple HTML
* form.
*
* After invoking the application, the servlet sample displays a HTML form.
* User can enter his/her name in the User Name text field. Upon pressing the Button
* "Submit Form", the form gets submitted.
*
* The Servlet uses getParameter("USERNAME") method to read the input parameter,
* "USERNAME" submitted by the previous form. Then the "USERNAME" is displayed
* on the HTML page.
*
*
*/

import java.io.*;

// Packages for Servlets
import javax.servlet.*;
import javax.servlet.http.*;

public class HelloUser extends HttpServlet {

  // Holds the path of the Servlet. By default it is null
  public static String m_servletPath = null;

  /**
  * Initializes the servlet. The method is called once, automatically, by the
  * Java Web Server when it loads the servlet. The init() method should save the
  * ServletConfig object so that it can be returned by the getServletConfig()
  * method.
  */
  public void init(ServletConfig config) throws ServletException {
    super.init(config);
  }

  /**
  * Method to process HTTP GET requests. In this method a Simple HTML form is
  * displayed. User can enter his/her name in User Name text field and press
  * "Submit Form" button. Upon pressing the button, the form gets submitted.
  * The Servlet uses getParameter() method to get the user name entered by the
  * user and displays it in the HTML page. The parameters to doGet() method is
  * 1) HttpServletRequest object, which encapsulates the data from the client
  * 2) HttpServletResponse object, which encapsulates the response to the client
  */
  public void doGet(HttpServletRequest p_req, HttpServletResponse p_res)
                                        throws ServletException, IOException {

    // Sets the content type of the response
    p_res.setContentType("text/html");

    // Gets the Path of the Servlet
    if(this.m_servletPath == null)
       m_servletPath = p_req.getRequestURI();

    // Create a ServletOutputStream to write the output
    ServletOutputStream l_out = p_res.getOutputStream();

    // Gets the HTML page to enter the Name of the User
    l_out.print(this.getUserName());

    // Gets the user name entered in the text field, using getparameter() method
    String l_userName = p_req.getParameter("USERNAME");

    if(l_userName != null && l_userName != "")
       // Calls the method to print the Hello User Name in the HTML page
       l_out.print(this.printUserName(l_userName));
  }

  /**
  * This method is implemented to return the HTML page where the user can enter
  * the name and press "Submit Form" button.
  */
  public static String getUserName() {
    StringBuffer l_stringBuffer = new StringBuffer(1500);
    l_stringBuffer.append("<HTML>\n");
    l_stringBuffer.append("<TITLE>Illustrating Parameter Processing using");
    l_stringBuffer.append(" Servlets </TITLE>\n");
    l_stringBuffer.append("<BODY bgcolor=\"lightgrey\"><Center>\n");
    l_stringBuffer.append("<FORM METHOD=\"GET\" ACTION=\""+m_servletPath+"\">");
    l_stringBuffer.append("<BR>&nbsp;&nbsp&nbsp;&nbsp;&nbsp;Enter your name");
    // Setting the parameter "USERNAME" and submit it
    l_stringBuffer.append("&nbsp;<INPUT TYPE=\"text\" NAME=\"USERNAME\">");
    l_stringBuffer.append("&nbsp;&nbsp;<INPUT TYPE=submit VALUE=\"Submit Form\">");
    l_stringBuffer.append("</FORM>");
    l_stringBuffer.append("</center>");
    String l_returnString = new String(l_stringBuffer);
    return l_returnString;
  }

  /**
  * This method is implemented to display the HTML page which will display the
  * name entered by the user. The name entered is passed as the parameter to
  * this method
  */
  public static String printUserName(String l_userName) {

    StringBuffer l_stringBuffer = new StringBuffer(1500);
    l_stringBuffer.append("<BODY><CENTER><BR>");
    l_stringBuffer.append("<TABLE BORDER=4 BGCOLOR =\"blue\">");
    l_stringBuffer.append("<TR><TD align =\"center\" valign=\"center\" >");
    l_stringBuffer.append("<FONT face=\"Arial,helvetica\" color =red size=5>");
    l_stringBuffer.append("<BLINK>&nbsp;Hello " +l_userName+"&nbsp;</BLINK>");
    l_stringBuffer.append("</FONT></TABLE></BODY></HTML>");
    String l_returnString = new String(l_stringBuffer);
    return l_returnString;
  }

  /**
  * Override the getServletInfo() method which is supposed to return information
  * about the Servlet, e.g. the Servlet name, version, author and copyright
  * notice. This is not required for the function of the HelloUser servlet but
  * can provide valuable information to the user of a servlet who sees the
  * returned text in the administration tool of the Web Server.
  */
  public String getServletInfo() {
    return "Hello User Servlet";
  }

  /**
  * Destroy the servlet. This method is called once when the servlet is unloaded
  **/
  public void destroy() {
     super.destroy();
  }

}

