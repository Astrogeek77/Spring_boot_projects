package com.gautam.smarthome.controller;

import com.gautam.smarthome.facade.SmartHomeFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/home")
public class HomeController {

    private final SmartHomeFacade homeFacade;

    public HomeController(SmartHomeFacade homeFacade) {
        this.homeFacade = homeFacade;
    }

    @GetMapping("/movie/start") // testing
//    @PostMapping("/movie/start")
    public String startMovie() {
        return homeFacade.watchMovieMode();
    }

    @GetMapping("/movie/stop") // testing
//    @PostMapping("/movie/stop")
    public String stopMovie() {
        return homeFacade.stopMovieMode();
    }

    @GetMapping("/morning") // testing
    @PostMapping("/morning")
    public String startMorning() {
        return homeFacade.goodMorningMode();
    }
}