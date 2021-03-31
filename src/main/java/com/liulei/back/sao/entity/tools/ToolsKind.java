package com.liulei.back.sao.entity.tools;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ToolsKind {
    @TableId
    private Integer id;

    private String toolsKind;

    private String toolsName;
}
