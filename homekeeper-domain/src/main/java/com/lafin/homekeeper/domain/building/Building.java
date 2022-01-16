package com.lafin.homekeeper.domain.building;

import com.lafin.homekeeper.global.type.BuildingStatus;
import com.lafin.homekeeper.global.type.BuildingType;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@ToString
public class Building {

    private Long id;

    private Long userId;

    private BuildingStatus status;

    private String name;

    private BuildingType type;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;

    public void delete() {
        status = BuildingStatus.REMOVED;
        deletedAt = LocalDateTime.now();
    }

    public boolean isOwner(Long userId) {
        return this.userId.equals(userId);
    }

    public void updateName(String name) {
        this.name = name;
    }

    public static Building create(Long userId, String name, BuildingType type) {
        return Building.builder()
                .userId(userId)
                .status(BuildingStatus.ACTIVE)
                .name(name)
                .type(type)
                .createdAt(LocalDateTime.now())
                .build();
    }
}
