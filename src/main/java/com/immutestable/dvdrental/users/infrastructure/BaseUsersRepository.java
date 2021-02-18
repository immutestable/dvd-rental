package com.immutestable.dvdrental.users.infrastructure;

import com.immutestable.dvdrental.users.domain.User;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@NoRepositoryBean
interface BaseUsersRepository<T, ID extends Serializable> extends Repository<T, ID> {
    T insert(T entity);

    Optional<T> findById(ID id);

    List<User> findByLastName(@Param("name") String name);
}
