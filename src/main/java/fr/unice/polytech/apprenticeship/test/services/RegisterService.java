package fr.unice.polytech.apprenticeship.test.services;

import fr.unice.polytech.apprenticeship.test.exceptions.MissingMandatoryInformationsException;
import fr.unice.polytech.apprenticeship.test.exceptions.UserNotValidException;
import fr.unice.polytech.apprenticeship.test.models.User;
import fr.unice.polytech.apprenticeship.test.repositories.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    @Autowired
    private UserRepository repository;

    public User createUser(User user) throws UserNotValidException, MissingMandatoryInformationsException {

        if (new Integer(user.getAge()) < 18 || !user.getCountry().toLowerCase().equals("france"))
            throw new UserNotValidException();

        user.set_id(ObjectId.get());
        repository.save(user);
        return user;
    }
}
