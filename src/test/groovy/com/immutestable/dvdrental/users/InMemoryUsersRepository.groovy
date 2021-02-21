package com.immutestable.dvdrental.users


import com.immutestable.dvdrental.users.domain.User
import com.immutestable.dvdrental.users.domain.UsersFacade

class InMemoryUsersRepository implements UsersFacade {

    private Map<String, User> users = [:]

    @Override
    User save(User entity) {
        def nextID = getNextID()
        this.users[nextID] = entity
        entity.id = nextID
        return entity
    }

    @Override
    Optional<User> findById(String id) {
        return Optional.ofNullable(users[id])
    }

    @Override
    List<User> findByLastName(String name) {
        return users.values().findAll { it.lastName == name }
    }

    String getNextID() {
        def biggestIdSoFar = users.keySet().max() ?: 0
        return (biggestIdSoFar + 1).toString()
    }
}
