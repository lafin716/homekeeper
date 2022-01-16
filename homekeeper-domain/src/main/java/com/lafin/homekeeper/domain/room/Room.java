package com.lafin.homekeeper.domain.room;

import com.lafin.homekeeper.global.type.Status;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder(access = AccessLevel.PRIVATE )
@ToString
public class Room {

    private Long id;

    private Long buildingId;

    private Status status;

    private String name;

    private List<Stuff> stuffs;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;

    public static Room create(Long buildingId, String name) {
        return Room.builder()
                .status(Status.ACTIVE)
                .buildingId(buildingId)
                .name(name)
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Room createWithStuffs(Long buildingId, String name, List<Stuff> stuffs) {
        return Room.builder()
                .status(Status.ACTIVE)
                .buildingId(buildingId)
                .name(name)
                .stuffs(stuffs)
                .createdAt(LocalDateTime.now())
                .build();
    }
}
