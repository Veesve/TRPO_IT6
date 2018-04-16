package lab3;




import lab3.DAL.DAO;
import lab3.Data.Film;
import lab3.Data.FilmTypes;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

// Extend HttpServlet class
@WebServlet("/lab3/AddingFilmServlet")
public class AddingFilmServlet extends HttpServlet {

    private final static String REDIRECT_FORMAT =
            "http://localhost:8080/%s";
    private DAO dao = DAO.getInstance();
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        try {
            // Set response content type
            response.setContentType("text/html");
            String filmTitle = request.getParameter("title");
            int filmCost = Integer.parseInt(request.getParameter("cost"));
            FilmTypes filmType = FilmTypes.valueOf(request.getParameter("genre"));
            Film addedFilm = new Film(filmTitle, filmCost, filmType);
            dao.insert(addedFilm);
            response.setStatus(response.SC_MOVED_TEMPORARILY);
            response.setHeader("Location", String.format(REDIRECT_FORMAT, "/lab3/AddFilmPages/AddFilmSuccess.html"));
        } catch (Exception e){
            response.setStatus(response.SC_MOVED_TEMPORARILY);
            response.setHeader("Location",String.format(REDIRECT_FORMAT,"/lab3/AddFilmPages/AddFilmFail.html"));
            e.printStackTrace();
        }

    }
}