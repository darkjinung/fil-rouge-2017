package fr.centralesupelec.sio.endpoints;

import fr.centralesupelec.sio.data.MoviesRepository;
import fr.centralesupelec.sio.endpoints.utils.ResponseHelper;
import fr.centralesupelec.sio.model.Genre;
import fr.centralesupelec.sio.model.MovieGenre;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

/**
 * A servlet to access the list of {@link MovieGenre}.
 */
// The following pattern will exactly match /movies only.
@WebServlet(urlPatterns = "/genres")
public class GenresServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Get genre from the repository.
        Set<Genre> genres = MoviesRepository.getInstance().getMoviesGenre();

        // Write to the response.
        ResponseHelper.writeJsonResponse(resp, genres);

    }

}
