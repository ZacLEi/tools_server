package com.liulei.back.sao.controller.player;

import com.liulei.back.sao.entity.player.Player;
import com.liulei.back.sao.service.player.PlayerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @GetMapping("/player")
    public Object list(){
        return playerService.list();
    }

    @GetMapping("/player/id")
    public Player getById(@RequestParam("id")Integer id) {
        return playerService.getById(id);
    }

    @PostMapping("/player")
    public Integer add(@RequestBody Player player) {
        return playerService.add(player);
    }

    @DeleteMapping("/player/{id}")
    public Object delete(@PathVariable("id") Integer id){
        return playerService.delete(id);
    }

    @PutMapping("/player")
    public Object update(@RequestBody Player player){
        if (player.getId() == null) {
            log.error("update player error! id is null!");
            return null;
        }
        return playerService.update(player);
    }
}
