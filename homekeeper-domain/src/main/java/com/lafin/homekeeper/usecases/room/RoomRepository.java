package com.lafin.homekeeper.usecases.room;

import com.lafin.homekeeper.domain.room.Room;
import com.lafin.homekeeper.usecases.Repository;

import java.util.List;

public interface RoomRepository extends Repository<Room> {

    List<Room> findByBuildingId(Long buildingId);
}
