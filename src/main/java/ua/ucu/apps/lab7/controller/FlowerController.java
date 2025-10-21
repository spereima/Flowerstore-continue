package ua.ucu.apps.lab7.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ua.ucu.apps.lab7.flower.Flower;
import ua.ucu.apps.lab7.flower.FlowerColor;
import ua.ucu.apps.lab7.flower.FlowerType;

@RestController
public class FlowerController {
    
    @GetMapping("/flowers")
    public List<Flower> getFlowers(){
        return List.of(new Flower(FlowerType.TULIP, 100, 10, FlowerColor.PINK));
    }
}
