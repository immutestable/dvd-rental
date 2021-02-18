package com.immutestable.dvdrental.users.domain;

import java.util.List;
import java.util.Optional;

public interface UsersFacade {

    User save(User entity);

    Optional<User> findById(String id);

    List<User> findByLastName( String name);
}
