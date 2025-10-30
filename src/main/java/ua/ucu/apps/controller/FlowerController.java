package ua.ucu.apps.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ua.ucu.apps.flower.Flower;
import ua.ucu.apps.flower.FlowerColor;
import ua.ucu.apps.flower.FlowerType;



@RestController
public class FlowerController {
    
    @GetMapping("/flowers")
    public List<Flower> getFlowers(){
        return List.of(new Flower(FlowerType.TULIP, 100, 10, FlowerColor.PINK));
    }
}
