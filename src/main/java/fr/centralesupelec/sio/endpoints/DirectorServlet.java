package fr.centralesupelec.sio.endpoints;

import fr.centralesupelec.sio.data.MoviesRepository;
import fr.centralesupelec.sio.endpoints.utils.ResponseHelper;
import fr.centralesupelec.sio.model.Director;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * A data servlet to access a single {@link Director} entity.
 */
// The following pattern will match for instance /movies/123.
@WebServlet(urlPatterns = "/directors/*")
public class DirectorServlet extends HttpServlet {

    // This method will be called in case of a GET request.
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // We need to extract the id of the movie from the URL.
        // We can obtain it from req.getPathInfo() by removing the leading "/" with substring().
        // And we parse this String as a number.
        long id;
        try {
            id = Long.parseLong(req.getPathInfo().substring(1));
        } catch (NumberFormatException ex) {
            ResponseHelper.writeError(resp, "Invalid id", HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        // Find movie from the repository.
        Director director = MoviesRepository.getInstance().getDirector(id);
        if (director != null) {
            ResponseHelper.writeJsonResponse(resp, director);
        } else {
            ResponseHelper.writeError(resp, "Director not found", HttpServletResponse.SC_NOT_FOUND);
        }
    }

}
