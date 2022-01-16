package com.lafin.homekeeper.domain.entity.building;

import com.lafin.homekeeper.global.type.BuildingType;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Building {

    private Long id;

    private Long userId;

    private String name;

    private BuildingType type;
}
