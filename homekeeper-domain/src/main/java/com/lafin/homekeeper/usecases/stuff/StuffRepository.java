package com.lafin.homekeeper.usecases.stuff;

import com.lafin.homekeeper.domain.stuff.Stuff;
import com.lafin.homekeeper.usecases.Repository;

import java.util.List;

public interface StuffRepository extends Repository<Stuff> {

    List<Stuff> findByRoomId(Long roomId);
}
