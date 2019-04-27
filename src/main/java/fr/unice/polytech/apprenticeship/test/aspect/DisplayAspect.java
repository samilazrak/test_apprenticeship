package fr.unice.polytech.apprenticeship.test.aspect;

import fr.unice.polytech.apprenticeship.test.exceptions.MissingMandatoryInformationsException;
import fr.unice.polytech.apprenticeship.test.exceptions.UserNotValidException;
import fr.unice.polytech.apprenticeship.test.models.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;

@Aspect
@Component("displayAspect")
public class DisplayAspect {

    private Logger logger = Logger.getLogger("Aspect");

    @Before(value = "execution(* fr.unice.polytech.apprenticeship.test.services.DisplayService.getUserById(..)) && args(id)")
    public void diplayingUser(JoinPoint joinPoint, ObjectId id){
        logger.log(Level.INFO, "Displaying user with id : " + id.toString() );
    }

    @Before(value = "execution(* fr.unice.polytech.apprenticeship.test.services.DisplayService.getUsers(..))")
    public void diplayingAllUsers(JoinPoint joinPoint){
        logger.log(Level.INFO, "Displaying all users " );
    }
}
