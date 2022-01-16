package com.lafin.homekeeper.usecases.room;

import com.lafin.homekeeper.domain.room.Room;
import com.lafin.homekeeper.usecases.UseCase;
import lombok.Value;

import java.util.List;

public class GetRoomListUseCase extends UseCase<GetRoomListUseCase.Input, GetRoomListUseCase.Output> {

    private final RoomRepository repository;

    public GetRoomListUseCase(RoomRepository repository) {
        this.repository = repository;
    }

    @Override
    public Output execute(Input input) {

        List<Room> rooms = repository.findByBuildingId(input.buildingId);

        return new Output(rooms);
    }

    @Value
    public static class Input implements UseCase.Input {
        Long buildingId;
    }

    @Value
    public static class Output implements UseCase.Output {
        List<Room> rooms;
    }
}
