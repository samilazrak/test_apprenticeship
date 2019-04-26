package fr.unice.polytech.apprenticeship.test.repositories;

import fr.unice.polytech.apprenticeship.test.models.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    User findBy_id(ObjectId _id);

}
