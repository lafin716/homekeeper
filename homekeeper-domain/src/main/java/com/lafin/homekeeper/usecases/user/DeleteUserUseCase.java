package com.lafin.homekeeper.usecases.user;

import com.lafin.homekeeper.domain.user.User;
import com.lafin.homekeeper.global.exception.UserException;
import com.lafin.homekeeper.global.type.UserType;
import com.lafin.homekeeper.usecases.UseCase;
import lombok.Value;

public class DeleteUserUseCase extends UseCase<DeleteUserUseCase.Input, DeleteUserUseCase.Output>{

    private final UserRepository repository;

    public DeleteUserUseCase(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public Output execute(Input input) {

        User user = repository.findById(input.id)
                .orElseThrow(() -> UserException.NOT_FOUND_USER);

        return new Output(repository.delete(input.id));
    }

    @Value
    public static class Input implements UseCase.Input {
        Long id;
    }

    @Value
    public static class Output implements UseCase.Output {
        boolean result;
    }
}
