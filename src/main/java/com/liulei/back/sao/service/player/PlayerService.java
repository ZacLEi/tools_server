package com.liulei.back.sao.service.player;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.liulei.back.sao.entity.player.Player;
import com.liulei.back.sao.mapper.player.PlayerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PlayerService {
    @Autowired
    private PlayerMapper playerMapper;

//    @SentinelResource(value = "list",blockHandler ="listBlockHandler", fallback = "listFallBack")
    public List<Player> list(){
        return playerMapper.selectList(new QueryWrapper<>());
    }

    public List<Player> listBlockHandler(BlockException exception) {
        exception.printStackTrace();
        System.out.println("player list 熔断！！");
        return null;
    }

    public List<Player> listFallBack() {
        System.out.println("player list 熔断解除！！");
        return playerMapper.selectList(new QueryWrapper<>());
    }

    public Integer add(Player player) {
        playerMapper.insert(player);
        return player.getId();
    }

    public Object delete(Integer id) {
        return playerMapper.deleteById(id);
    }

    public Player getById(Integer id) {
        return playerMapper.selectById(id);
    }

    public Object update(Player player) {
        return playerMapper.updateById(player);
    }
}
