package com.lafin.homekeeper.usecases.user;

import com.lafin.homekeeper.domain.user.User;
import com.lafin.homekeeper.usecases.Repository;

public interface UserRepository extends Repository<User> {

    boolean existsByEmail(String email);

}
