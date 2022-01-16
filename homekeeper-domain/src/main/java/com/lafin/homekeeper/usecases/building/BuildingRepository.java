package com.lafin.homekeeper.usecases.building;

import com.lafin.homekeeper.domain.building.Building;

import java.util.List;
import java.util.Optional;

public interface BuildingRepository {

    Building save(Building building);

    List<Building> findAll(Long userId);

    Optional<Building> findById(Long id);

    boolean existsByUserIdAndName(Long userId, String name);
}
