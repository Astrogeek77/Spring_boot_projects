package com.gautam.legion.controller;

import com.gautam.legion.service.GameService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/game")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/spawn")
    public String spawnArmy() {
        System.out.println("--- Starting Simulation ---");
        gameService.createArmy();

        System.out.println("--- Rendering Frame ---");
        gameService.renderArmy();

        return "Army Spawned! Check Console Logs for Memory Optimization.";
    }
}
