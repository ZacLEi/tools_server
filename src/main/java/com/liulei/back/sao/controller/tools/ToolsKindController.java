package com.liulei.back.sao.controller.tools;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.liulei.back.sao.common.ResponseResult;
import com.liulei.back.sao.entity.tools.ToolsKind;
import com.liulei.back.sao.service.tools.ToolsKindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/tools/kind")
public class ToolsKindController {
    @Autowired
    private ToolsKindService toolsKindService;

    @GetMapping("/list")
    public ResponseResult getList() {
        return ResponseResult.success(toolsKindService.list());
    }

    @GetMapping("/")
    public ResponseResult getOne(@RequestParam(required = false,value = "id")Integer id,
                                 @RequestParam(required = false,value = "toolsKind") Integer toolsKind,
                                 @RequestParam(required = false,value = "toolsName") String toolsName) {
        QueryWrapper<ToolsKind> wrapper = new QueryWrapper<>();
        if (id != null) {
            wrapper.eq("id",id);
        }else if (toolsKind != null) {
            wrapper.eq("tools_kind",toolsKind);
        }else if (toolsName != null) {
            wrapper.like("tools_name","%"+toolsName+"%");
        }

        return ResponseResult.success(toolsKindService.getOne(wrapper));
    }

    @PutMapping("/{id}")
    public ResponseResult update(@RequestBody ToolsKind toolsKind,
                                 @PathVariable("id") Integer id){
        toolsKind.setId(toolsKind.getId());
        return ResponseResult.success(toolsKindService.updateById(toolsKind));
    }

    @PostMapping("/")
    public ResponseResult add(@RequestBody ToolsKind toolsKind) {
        return ResponseResult.success(toolsKindService.save(toolsKind));
    }

    @DeleteMapping("/{id}")
    public ResponseResult delete(@PathVariable("id")Integer id){
        return ResponseResult.success(toolsKindService.removeById(id));
    }

}
