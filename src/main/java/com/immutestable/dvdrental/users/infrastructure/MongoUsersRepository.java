package com.immutestable.dvdrental.users.infrastructure;

import com.immutestable.dvdrental.users.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface MongoUsersRepository extends MongoRepository<User, String> {

    List<User> findByLastName(@Param("name") String name);

}
