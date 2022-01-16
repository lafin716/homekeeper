package com.lafin.homekeeper.usecases.user;

import com.lafin.homekeeper.domain.user.User;
import com.lafin.homekeeper.global.exception.UserException;
import com.lafin.homekeeper.global.type.UserType;
import com.lafin.homekeeper.usecases.UseCase;
import lombok.Value;

public class CreateUserUseCase extends UseCase<CreateUserUseCase.Input, CreateUserUseCase.Output>{

    private final UserRepository repository;

    public CreateUserUseCase(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public Output execute(Input input) {

        if (repository.existsByEmail(input.email)) {
            throw UserException.DUPLICATED_EMAIL;
        }

        User user = User.createUser(input.email, input.name, input.password);

        return new Output(repository.save(user));
    }

    @Value
    public static class Input implements UseCase.Input {
        String email;
        String name;
        String password;
        UserType type;
    }

    @Value
    public static class Output implements UseCase.Output {
        User user;
    }
}
