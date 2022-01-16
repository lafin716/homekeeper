package com.lafin.homekeeper.usecases.stuff;

import com.lafin.homekeeper.domain.stuff.Stuff;
import com.lafin.homekeeper.global.type.StuffUnit;
import com.lafin.homekeeper.usecases.UseCase;
import lombok.Value;

public class CreateStuffUseCase extends UseCase<CreateStuffUseCase.Input, CreateStuffUseCase.Output> {

    private final StuffRepository repository;

    public CreateStuffUseCase(StuffRepository repository) {
        this.repository = repository;
    }

    @Override
    public Output execute(Input input) {

        Stuff stuff = Stuff.create(input.roomId, input.name, input.unit, input.amount);

        return new Output(repository.save(stuff));
    }

    @Value
    public static class Input implements UseCase.Input {
        Long roomId;
        String name;
        StuffUnit unit;
        Float amount;
    }

    @Value
    public static class Output implements UseCase.Output {
        Stuff stuff;
    }
}
