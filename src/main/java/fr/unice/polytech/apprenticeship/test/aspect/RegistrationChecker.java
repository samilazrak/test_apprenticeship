package fr.unice.polytech.apprenticeship.test.aspect;

import fr.unice.polytech.apprenticeship.test.exceptions.MissingMandatoryInformationsException;
import fr.unice.polytech.apprenticeship.test.exceptions.UserNotValidException;
import fr.unice.polytech.apprenticeship.test.models.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component("aspectChecker")
public class RegistrationChecker {

    private Logger logger = Logger.getLogger("Aspect");

    @Before(value = "execution(* fr.unice.polytech.apprenticeship.test.services.RegisterService.*(..)) && args(user)")
    public void beforeAdvice(JoinPoint joinPoint, User user) throws UserNotValidException, MissingMandatoryInformationsException {
        System.out.println("******************* Before method:");
        //throw new UserNotValidException();
    }

    @After(value = "execution(* fr.unice.polytech.apprenticeship.test.services.RegisterService.*(..)) && args(user)")
    public void afterAdvice(JoinPoint joinPoint, User user) throws UserNotValidException, MissingMandatoryInformationsException {
        System.out.println("******************* Before method:");
        //throw new UserNotValidException();
    }

}
