package fr.unice.polytech.apprenticeship.test.controllers;

import fr.unice.polytech.apprenticeship.test.exceptions.MissingMandatoryInformationsException;
import fr.unice.polytech.apprenticeship.test.exceptions.UserNotValidException;
import fr.unice.polytech.apprenticeship.test.models.User;
import fr.unice.polytech.apprenticeship.test.services.DisplayService;
import fr.unice.polytech.apprenticeship.test.services.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    private Logger logger = Logger.getLogger("Register");

    /***
     * REST Service that allow a user to register himself
     * @param user : with mandatory attributes (name, age, country) and optional one (job)
     * @return the new instance of User with it's ID.
     */
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResponseEntity createUser(@Valid @RequestBody User user) {
        logger.log(Level.INFO, "Input user: " + user.toString());
        long begin = System.currentTimeMillis();

        try {
            registerService.createUser(user);
        } catch (UserNotValidException e) {
            logger.log(Level.INFO, "Processing Time : " + (System.currentTimeMillis() - begin) + " ms");
            return new ResponseEntity("You must live in France and be an adult (>18) to register", HttpStatus.NOT_ACCEPTABLE);
        } catch (MissingMandatoryInformationsException e) {
            logger.log(Level.INFO, "Processing Time : " + (System.currentTimeMillis() - begin) + " ms");
            return new ResponseEntity("Name, Age and Country are mandatory - Job is optional", HttpStatus.NOT_ACCEPTABLE);
        }

        logger.log(Level.INFO, "Processing Time : " + (System.currentTimeMillis() - begin) + " ms");
        return new ResponseEntity("You have been registered successfully", HttpStatus.OK);
    }
}
