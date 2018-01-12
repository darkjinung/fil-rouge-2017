package fr.centralesupelec.sio.endpoints;

import fr.centralesupelec.sio.data.MoviesRepository;
import fr.centralesupelec.sio.endpoints.utils.ResponseHelper;
import fr.centralesupelec.sio.model.Movie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * A servlet to access the list of {@link Movie}s.
 */
// The following pattern will exactly match /movies only.
@WebServlet(urlPatterns = "/movies")
public class MoviesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //
        List<String> pgenres, pdirectors, pactors;
        //List<Integer> pactors = new ArrayList<>();

        // Get movies from the repository.
        String ptitle = req.getParameter("title");
        try {pgenres = Arrays.asList(req.getParameter("genre").split(","));
            pgenres.stream().map(String::toLowerCase).collect(Collectors.toList());
        }
        catch(NullPointerException e){
            pgenres = new ArrayList<>();
        }
        try { pdirectors = Arrays.asList(req.getParameter("director").split(","));}
        catch(NullPointerException e){
            pdirectors = new ArrayList<>();
        }
        try{pactors = Arrays.asList(req.getParameter("actor").split(","));}
        catch(NullPointerException e){
            pactors = new ArrayList<>();
        }
        String poffset = req.getParameter("offset");
        String plimit = req.getParameter("limit");

        //If no parameters, return first 5 movies
        if(ptitle == null) ptitle="";
        if(poffset == null) poffset="0";
        if(plimit == null) plimit="20";
        ResponseHelper.writeJsonResponse(resp, MoviesRepository.getInstance().getMovies(ptitle, pgenres,
                pdirectors.stream().map(Long::parseLong).collect(Collectors.toList()),
                pactors.stream().map(Long::parseLong).collect(Collectors.toList()),
                Integer.parseInt(poffset), Integer.parseInt(plimit)));
    }

}
