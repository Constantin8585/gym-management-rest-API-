package com.gym.gym_app.controller;

import com.gym.gym_app.entity.Pack;
import com.gym.gym_app.service.Packservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/packs")
public class PackController {
    @Autowired
    private Packservice packservice;
    @GetMapping
    public List<Pack> getAllPacks() {
        return packservice.getAllPacks();
    }

    @PostMapping
    public Pack addPack(@RequestBody Pack pack) {
        return packservice.addPack(pack);
    }



}
