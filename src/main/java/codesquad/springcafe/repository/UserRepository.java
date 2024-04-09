package codesquad.springcafe.repository;

import codesquad.springcafe.domain.User;

import java.util.List;

public interface UserRepository {

    void addUser(User user) throws IllegalArgumentException;
    User findUserById(String id);
    List<User> findAll();
}
