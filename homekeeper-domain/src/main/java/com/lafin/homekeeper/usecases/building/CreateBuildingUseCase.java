package com.lafin.homekeeper.usecases.building;

import com.lafin.homekeeper.domain.building.Building;
import com.lafin.homekeeper.global.exception.BuildingException;
import com.lafin.homekeeper.global.type.BuildingType;
import com.lafin.homekeeper.usecases.UseCase;
import lombok.Value;

public class CreateBuildingUseCase extends UseCase<CreateBuildingUseCase.Input, CreateBuildingUseCase.Output> {

    private BuildingRepository buildingRepository;

    public CreateBuildingUseCase(BuildingRepository buildingRepository) {
        this.buildingRepository = buildingRepository;
    }

    @Override
    public Output execute(Input input) {

        if (buildingRepository.existsByUserIdAndName(input.userId, input.name)) {
            throw BuildingException.DUPLICATED_NAME;
        }

        Building building = Building.newInstance(
                input.userId,
                input.name,
                input.type
        );

        return new Output(buildingRepository.save(building));
    }

    @Value
    public static class Input implements UseCase.Input {
        Long userId;
        String name;
        BuildingType type;
    }

    @Value
    public static class Output implements UseCase.Output {
        Building building;
    }
}
