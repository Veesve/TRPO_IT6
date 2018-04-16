package lab3;


import lab3.DAL.DAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/lab3/DeleteFilmServlet")
public class DeleteFilmServlet extends HttpServlet {
    private DAO dao = DAO.getInstance();
    private final static String REDIRECT_FORMAT =
            "http://localhost:8080/%s";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        try{
             //Set response content type
            response.setContentType("text/html");
            String filmTitle = request.getParameter("title");
            dao.delete(filmTitle);
            response.setStatus(response.SC_MOVED_TEMPORARILY);
            response.setHeader("Location", String.format(REDIRECT_FORMAT, "/lab3/DeleteFilmPages/DeleteFilmSuccess.html"));
        }catch (Exception e) {
            response.setStatus(response.SC_MOVED_TEMPORARILY);
            response.setHeader("Location", String.format(REDIRECT_FORMAT, "/lab3/DeleteFilmPages/DeleteFilmFail.html"));
            e.printStackTrace();
        }
    }
}