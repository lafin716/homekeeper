package com.lafin.homekeeper.domain.building;

import com.lafin.homekeeper.global.type.BuildingType;
import lombok.*;

@Getter
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@ToString
public class Building {

    private Long id;

    private Long userId;

    private String name;

    private BuildingType type;

    public static Building newInstance(Long userId, String name, BuildingType type) {
        return Building.builder()
                .userId(userId)
                .name(name)
                .type(type)
                .build();
    }
}
