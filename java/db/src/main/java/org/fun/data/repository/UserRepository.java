package org.fun.data.repository;

import org.fun.data.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by tim on 4/22/17.
 */
public interface UserRepository extends CrudRepository<User, String> {
}
