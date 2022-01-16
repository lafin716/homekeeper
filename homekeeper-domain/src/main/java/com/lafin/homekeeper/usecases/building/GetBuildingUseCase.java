package com.lafin.homekeeper.usecases.building;

import com.lafin.homekeeper.domain.building.Building;
import com.lafin.homekeeper.global.exception.BuildingException;
import com.lafin.homekeeper.usecases.UseCase;
import lombok.Value;

import java.util.List;

public class GetBuildingUseCase extends UseCase<GetBuildingUseCase.Input, GetBuildingUseCase.Output> {

    private final BuildingRepository repository;

    public GetBuildingUseCase(BuildingRepository buildingRepository) {
        this.repository = buildingRepository;
    }

    @Override
    public Output execute(Input input) {
        final Long id = input.id;

        Building building = repository.findById(id)
                .orElseThrow(() -> BuildingException.NOT_FOUND_BUILDING);

        return new Output(building);
    }

    @Value
    public static class Input implements UseCase.Input {
        Long id;
    }

    @Value
    public static class Output implements UseCase.Output {
        Building building;
    }
}
