package com.liulei.back.sao.controller.tools;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.liulei.back.sao.common.ResponseResult;
import com.liulei.back.sao.entity.tools.ToolsEntry;
import com.liulei.back.sao.service.tools.ToolsEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tools")
public class ToolsCRUDController {
    @Autowired
    private ToolsEntryService toolsEntryService;

    @GetMapping("/entrys")
    public ResponseResult getToolsEntry(@RequestParam("kind")int kind) {
        return ResponseResult.success(
                toolsEntryService.getBaseMapper().selectList(
                        new QueryWrapper<ToolsEntry>()
                                .eq("kind",kind)));
    }

    @PostMapping("/entry")
    public ResponseResult addToolsEntry(@RequestBody ToolsEntry toolsEntry) {
        toolsEntryService.save(toolsEntry);
        return ResponseResult.success(toolsEntry.getId());
    }

    @PostMapping("/entry/batchInsert")
    public ResponseResult batchInsert(@RequestBody List<ToolsEntry> toolsEntryList) {
        return ResponseResult.success(toolsEntryService.saveBatch(toolsEntryList));
    }

    @PutMapping("/entry/{id}")
    public ResponseResult updateTollsEntry(@RequestBody ToolsEntry toolsEntry,@PathVariable("id") int id){
        toolsEntry.setId(id);
        toolsEntryService.updateById(toolsEntry);
        return ResponseResult.success();
    }

    @DeleteMapping("/entry/{id}")
    public ResponseResult deleteToolsEntry(@PathVariable("id") int id) {
        toolsEntryService.removeById(id);
        return ResponseResult.success();
    }
}
