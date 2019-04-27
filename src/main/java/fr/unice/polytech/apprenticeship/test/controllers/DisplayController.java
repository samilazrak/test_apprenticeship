package fr.unice.polytech.apprenticeship.test.controllers;

import fr.unice.polytech.apprenticeship.test.services.DisplayService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/display")
public class DisplayController {

    @Autowired
    private DisplayService displayService;

    private Logger logger = Logger.getLogger("Display");

    /***
     * REST Service that allows to display a specific user thanks to it's ID, and if there's no ID in the path, all
     * registered users will be displayed
     * @param id (optional)
     * @return the user who's ID equals to the path variable 'id' OR all registered users
     */
    @RequestMapping(value = {"/user", "/user/{id}"}, method = RequestMethod.GET)
    public ResponseEntity getUserById(@PathVariable("id") Optional<ObjectId> id) {
        logger.log(Level.INFO, "Input id : " + id);
        long begin = System.currentTimeMillis(), end;
        String result;

        if (id.isPresent())
            result = displayService.getUserById(id.get()).toString();
        else
            result = displayService.getUsers().toString();

        logger.log(Level.INFO, "Processing Time : " + (System.currentTimeMillis() - begin) + " ms");
        return new ResponseEntity(result, HttpStatus.OK);
    }
}
