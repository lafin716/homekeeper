package com.lafin.homekeeper.usecases.building;

import com.lafin.homekeeper.domain.building.Building;
import com.lafin.homekeeper.usecases.UseCase;
import lombok.Value;

import java.util.List;

public class GetBuildingListUseCase extends UseCase<GetBuildingListUseCase.Input, GetBuildingListUseCase.Output> {

    private final BuildingRepository buildingRepository;

    public GetBuildingListUseCase(BuildingRepository buildingRepository) {
        this.buildingRepository = buildingRepository;
    }

    @Override
    public Output execute(Input input) {
        final Long userId = input.userId;

        List<Building> buildings = buildingRepository.findAll(userId);

        return new Output(buildings);
    }

    @Value
    public static class Input implements UseCase.Input {
        Long userId;
    }

    @Value
    public static class Output implements UseCase.Output {
        List<Building> buildings;
    }
}
