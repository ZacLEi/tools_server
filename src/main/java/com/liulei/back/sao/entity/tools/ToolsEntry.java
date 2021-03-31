package com.liulei.back.sao.entity.tools;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ToolsEntry {
    @TableId
    private Integer id;

    private String name;
    private String url;
    private String description;

    private String iconUrl;

    private Integer kind;
}
