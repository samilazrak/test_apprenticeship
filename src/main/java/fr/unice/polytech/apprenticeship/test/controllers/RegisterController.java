package fr.unice.polytech.apprenticeship.test.controllers;

import fr.unice.polytech.apprenticeship.test.models.User;
import fr.unice.polytech.apprenticeship.test.repositories.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class RegisterController {

    @Autowired
    private UserRepository repository;

    /***
     * REST Service that allow a user to register himself if some conditions are satisfied
     * @param user
     * @return the new instance of User with it's ID.
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public User createUser(@Valid @RequestBody User user) {
        user.set_id(ObjectId.get());
        repository.save(user);
        return user;
    }

    /***
     * REST Service that allows to display a specific user thanks to it's ID
     * @param id
     * @return the user who's ID equals to the path variable 'id'
     */
    @RequestMapping(value = "/display/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable("id") ObjectId id) {
        return repository.findBy_id(id);
    }

    /***
     * REST Service that allows to display all users registered in the DB
     * @return the list of users registered
     */
    @RequestMapping(value = "/display", method = RequestMethod.GET)
    public List<User> getUsers() {
        return repository.findAll();
    }
}
