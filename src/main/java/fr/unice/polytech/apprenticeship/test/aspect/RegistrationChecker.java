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
@Component("aspectChecker")
public class RegistrationChecker {

    private Logger logger = Logger.getLogger("Aspect");

    @Before(value = "execution(* fr.unice.polytech.apprenticeship.test.services.RegisterService.*(..)) && args(user)")
    public void beforeRegistration(JoinPoint joinPoint, User user) throws UserNotValidException, MissingMandatoryInformationsException {
        logger.log(Level.INFO, "Input user: " + user.toString());

        if (user.getAge() == 0 || user.getCountry() == null || user.getName() == null ||
                user.getCountry() == "" || user.getName() == "")
            throw new MissingMandatoryInformationsException();

        if (new Integer(user.getAge()) < 18 || !user.getCountry().toLowerCase().equals("france"))
            throw new UserNotValidException();
    }
}
