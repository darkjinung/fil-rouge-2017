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

/**
 * A data servlet to access a single {@link Actor} entity.
 */
// The following pattern will match for instance /movies/123.
@WebServlet(urlPatterns = "/actors/*")
public class ActorServlet extends HttpServlet {

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
        Actor actor = MoviesRepository.getInstance().getActor(id);
        if (actor != null) {
            ResponseHelper.writeJsonResponse(resp, actor);
        } else {
            ResponseHelper.writeError(resp, "Actor not found", HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
// Clients are expected to send credentials in query parameters, or using form-data.
        // Both are accessible by the getParameter() method.
        String id = req.getParameter("id");
        if (id == null || id.isEmpty()) {
            ResponseHelper.writeError(
                    resp,
                    "Missing id, obligatory parameter",
                    resp.SC_BAD_REQUEST // HTTP standard code 400 to indicate a client error
            );
            return;
        }
        // Check if the id looks like an email (using library Apache Commons).
        if (MoviesRepository.getInstance().getActor(Integer.parseInt(id)) != null) {
            ResponseHelper.writeError(resp,"Id already used", resp.SC_BAD_REQUEST);
            return;
        }

        //Get all possible parameters and create actor
        //What if the actor doesn't belong in a movie?
        //String password = req.getParameter("name");



    }
}
