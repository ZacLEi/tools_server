package com.liulei.back.sao.entity.player;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Player {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String playerName;

    private Integer playerLevel;

    private Integer playerSex;

    private String playerPassword;
}
