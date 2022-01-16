package com.lafin.homekeeper.domain.room;

import com.lafin.homekeeper.global.type.Status;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Room {

    private Long id;

    private Status status;

    private String name;

    private List<Stuff> stuffs;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;

    public static Room create(String name) {
        return Room.builder()
                .status(Status.ACTIVE)
                .name(name)
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Room createWithStuffs(String name, List<Stuff> stuffs) {
        return Room.builder()
                .status(Status.ACTIVE)
                .name(name)
                .stuffs(stuffs)
                .createdAt(LocalDateTime.now())
                .build();
    }
}
