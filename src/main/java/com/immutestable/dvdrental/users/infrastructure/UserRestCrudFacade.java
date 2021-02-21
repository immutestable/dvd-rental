package com.immutestable.dvdrental.users.infrastructure;

import com.immutestable.dvdrental.users.domain.User;
import com.immutestable.dvdrental.users.domain.UsersFacade;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRestCrudFacade extends MongoRepository<User, String>, UsersFacade {

    @Override
    @RestResource(exported = false)
    <S extends User> List<S> findAll(Example<S> example);

    @Override
    @RestResource(exported = false)
    <S extends User> List<S> findAll(Example<S> example, Sort sort);

    @Override
    default User save(User entity) {
        return this.insert(entity);
    }

    @Override
    List<User> findByLastName(String name);

    @Override
    @RestResource(exported = false)
    public void delete(User t);


}
