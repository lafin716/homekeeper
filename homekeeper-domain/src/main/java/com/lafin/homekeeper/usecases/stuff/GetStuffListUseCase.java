package com.lafin.homekeeper.usecases.stuff;

import com.lafin.homekeeper.domain.stuff.Stuff;
import com.lafin.homekeeper.usecases.UseCase;
import lombok.Value;

import java.util.List;

public class GetStuffListUseCase extends UseCase<GetStuffListUseCase.Input, GetStuffListUseCase.Output> {

    private final StuffRepository repository;

    public GetStuffListUseCase(StuffRepository repository) {
        this.repository = repository;
    }

    @Override
    public Output execute(Input input) {

        List<Stuff> stuff = repository.findByRoomId(input.roomId);

        return new Output(stuff);
    }

    @Value
    public static class Input implements UseCase.Input {
        Long roomId;
    }

    @Value
    public static class Output implements UseCase.Output {
        List<Stuff> stuffs;
    }
}
