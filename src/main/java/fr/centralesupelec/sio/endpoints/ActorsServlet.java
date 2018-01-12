package fr.centralesupelec.sio.endpoints;

import fr.centralesupelec.sio.data.MoviesRepository;
import fr.centralesupelec.sio.endpoints.utils.ResponseHelper;
import fr.centralesupelec.sio.model.Actor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

/**
 * A servlet to access the list of {@link Actor}s.
 */
// The following pattern will exactly match /actors only.
@WebServlet(urlPatterns = "/actors")
public class ActorsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Get movies from the repository.
        Set<Actor> actors = MoviesRepository.getInstance().getActors();

        // Write to the response.
        ResponseHelper.writeJsonResponse(resp, actors);

    }

}
