package com.lafin.homekeeper.domain.room;

import com.lafin.homekeeper.global.type.StuffUnit;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Stuff {

    private Long roomId;

    private String name;

    private StuffUnit unit;

    private Float amount;
}
