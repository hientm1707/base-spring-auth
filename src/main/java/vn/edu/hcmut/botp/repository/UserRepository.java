package vn.edu.hcmut.botp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import vn.edu.hcmut.botp.model.BOTPUser;

@Repository(value = "tbl_user")
public interface UserRepository extends MongoRepository<BOTPUser, Long> {

    @Query(value = "{ 'username' : ?0 }")
    BOTPUser findByUsername(String username);

}
