package vn.edu.hcmut.botp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface UserRepository<Long, User> extends MongoRepository<Long, User> {

    @Query(value = "{ 'username' : ?0 }")
    User findByUsername(String username);

}
