package com.lafin.homekeeper.usecases.building;

import com.lafin.homekeeper.domain.building.Building;
import com.lafin.homekeeper.global.exception.BuildingException;
import com.lafin.homekeeper.global.exception.HomeKeeperException;
import com.lafin.homekeeper.usecases.UseCase;
import lombok.Value;

public class UpdateBuildingUseCase extends UseCase<UpdateBuildingUseCase.Input, UpdateBuildingUseCase.Output> {

    private final BuildingRepository buildingRepository;

    public UpdateBuildingUseCase(BuildingRepository buildingRepository) {
        this.buildingRepository = buildingRepository;
    }

    @Override
    public Output execute(Input input) {
        final Long id = input.id;

        Building building = buildingRepository.findById(id)
                .orElseThrow(() -> BuildingException.NOT_FOUND_BUILDING);

        if (!building.isOwner(input.userId)) {
            throw HomeKeeperException.NOT_ALLOWED_UPDATE;
        }

        building.updateName(input.name);
        buildingRepository.save(building);

        return new Output(true);
    }

    @Value
    public static class Input implements UseCase.Input {
        Long id;
        Long userId;
        String name;
    }

    @Value
    public static class Output implements UseCase.Output {
        boolean result;
    }
}
