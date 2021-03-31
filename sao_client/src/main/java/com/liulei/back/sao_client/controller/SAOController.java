package com.liulei.back.sao_client.controller;

import com.alibaba.fastjson.JSON;
import com.liulei.back.sao_client.client.PlayerClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
public class SAOController {
//    @Autowired
//    private PlayerClient playerClient;
//
//    @GetMapping("/player")
//    public String getPlayer() {
//        return playerClient.getPlayerInfo();
//    }
}
