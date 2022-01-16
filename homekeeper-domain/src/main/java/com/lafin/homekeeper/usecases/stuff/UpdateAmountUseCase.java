package com.lafin.homekeeper.usecases.stuff;

import com.lafin.homekeeper.domain.stuff.Stuff;
import com.lafin.homekeeper.global.exception.StuffException;
import com.lafin.homekeeper.usecases.UseCase;
import lombok.Value;

public class UpdateAmountUseCase extends UseCase<UpdateAmountUseCase.Input, UpdateAmountUseCase.Output> {

    private final StuffRepository repository;

    public UpdateAmountUseCase(StuffRepository repository) {
        this.repository = repository;
    }

    @Override
    public Output execute(Input input) {

        Stuff stuff = repository.findById(input.id)
                .orElseThrow(() -> StuffException.NOT_FOUND_STUFF);

        stuff.updateAmount(input.amount);

        return new Output(repository.save(stuff));
    }

    @Value
    public static class Input implements UseCase.Input {
        Long id;
        Float amount;
    }

    @Value
    public static class Output implements UseCase.Output {
        Stuff stuff;
    }
}
