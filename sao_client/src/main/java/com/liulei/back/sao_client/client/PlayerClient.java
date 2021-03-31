package com.liulei.back.sao_client.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

//@FeignClient(name = "sword-art-online")
public interface PlayerClient {
    @GetMapping("/player")
    public String getPlayerInfo();
}
