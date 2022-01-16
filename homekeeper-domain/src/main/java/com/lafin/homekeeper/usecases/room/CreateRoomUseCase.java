package com.lafin.homekeeper.usecases.room;

import com.lafin.homekeeper.domain.room.Room;
import com.lafin.homekeeper.usecases.UseCase;
import lombok.Value;

public class CreateRoomUseCase extends UseCase<CreateRoomUseCase.Input, CreateRoomUseCase.Output> {

    private final RoomRepository repository;

    public CreateRoomUseCase(RoomRepository repository) {
        this.repository = repository;
    }

    @Override
    public Output execute(Input input) {

        Room room = Room.create(input.name);

        return new Output(repository.save(room));
    }

    @Value
    public static class Input implements UseCase.Input {
        String name;
    }

    @Value
    public static class Output implements UseCase.Output {
        Room room;
    }
}
