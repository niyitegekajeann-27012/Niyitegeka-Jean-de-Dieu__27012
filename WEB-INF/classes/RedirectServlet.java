import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class RedirectServlet extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String query = request.getParameter("query");
        String googleUrl = "https://www.google.com/search?q=" + query;
        
        response.sendRedirect(googleUrl);
    }
}