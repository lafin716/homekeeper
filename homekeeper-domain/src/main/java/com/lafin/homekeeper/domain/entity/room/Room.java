package com.lafin.homekeeper.domain.entity.room;

import lombok.*;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Room {

    private Long id;

    private String name;

    private List<Stuff> stuffs;
}
