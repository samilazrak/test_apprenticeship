package fr.unice.polytech.apprenticeship.test.services;

import fr.unice.polytech.apprenticeship.test.models.User;
import fr.unice.polytech.apprenticeship.test.repositories.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisplayService {

    @Autowired
    private UserRepository repository;

    public User getUserById(ObjectId id) {
        return repository.findBy_id(id);
    }

    public List<User> getUsers() {
        return repository.findAll();
    }
}
