package com.lafin.homekeeper.domain.stuff;

import com.lafin.homekeeper.global.type.Status;
import com.lafin.homekeeper.global.type.StuffUnit;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder(access = AccessLevel.PRIVATE)
@ToString
public class Stuff {

    private Long id;

    private Long roomId;

    private Status status;

    private String name;

    private StuffUnit unit;

    private Float amount;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;

    public void updateAmount(Float amount) {
        this.amount = amount;
    }

    public static Stuff create(Long roomId, String name, StuffUnit unit, Float amount) {
        return Stuff.builder()
                .roomId(roomId)
                .status(Status.ACTIVE)
                .name(name)
                .unit(unit)
                .amount(amount)
                .createdAt(LocalDateTime.now())
                .build();
    }
}
