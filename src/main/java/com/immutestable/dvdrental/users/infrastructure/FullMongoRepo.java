package com.immutestable.dvdrental.users.infrastructure;

import com.immutestable.dvdrental.users.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;

import java.util.List;


@NoRepositoryBean
interface FullMongoRepo extends MongoRepository<User, String> {
    List<User> findByLastName(@Param("name") String name);
}
