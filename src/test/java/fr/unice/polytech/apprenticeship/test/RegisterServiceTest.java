package fr.unice.polytech.apprenticeship.test;

import fr.unice.polytech.apprenticeship.test.exceptions.MissingMandatoryInformationsException;
import fr.unice.polytech.apprenticeship.test.exceptions.UserNotValidException;
import fr.unice.polytech.apprenticeship.test.models.User;
import fr.unice.polytech.apprenticeship.test.services.RegisterService;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RegisterServiceTest {

    private static User userAccepted;
    private static User notFrenchUser;
    private static User notAdultUser;
    private static User withoutAgeUser;

    @Autowired
    private RegisterService service;

    @BeforeClass
    public static void setUpContext() {
        userAccepted = new User(null, "Sami", 18, "France", null);
        notFrenchUser = new User(null, "Adam", 55, "USA", null);
        notAdultUser = new User(null, "Louis", 12, "France", null);
        withoutAgeUser = new User(null, "Momo", 0, "France", "Engineer");
    }

    @Test
    public void createNotFrenchTest() throws UserNotValidException, MissingMandatoryInformationsException {
        User newUser = service.createUser(userAccepted);
        assertEquals("Sami", newUser.getName());
        assertNotEquals("", newUser.get_id());
        assertEquals("France", newUser.getCountry());
        assertEquals(18, newUser.getAge());
    }

    @Test(expected = UserNotValidException.class)
    public void createNotFrenchUserTest() throws UserNotValidException, MissingMandatoryInformationsException {
        service.createUser(notFrenchUser);
    }

    @Test(expected = UserNotValidException.class)
    public void createNotAdultUserTest() throws UserNotValidException, MissingMandatoryInformationsException {
        service.createUser(notAdultUser);
    }

    @Test(expected = MissingMandatoryInformationsException.class)
    public void createUserWithoutAge() throws UserNotValidException, MissingMandatoryInformationsException {
        service.createUser(withoutAgeUser);
    }
}
