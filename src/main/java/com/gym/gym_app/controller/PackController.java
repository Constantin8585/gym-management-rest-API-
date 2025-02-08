package com.gym.gym_app.controller;

import com.gym.gym_app.entity.Pack;
import com.gym.gym_app.service.PackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/packs")
public class PackController {
    @Autowired
    private PackService packService;

    @GetMapping
    public List<Pack> getAllPacks() {
        return packService.getAllPacks();
    }

    @GetMapping("/{id}")
    public Pack getPackById(@PathVariable Long id) {
        return packService.getPackById(id);
    }

    @PostMapping
    public Pack addPack(@RequestBody Pack pack) {
        return packService.addPack(pack);
    }

    @PutMapping("/{id}")
    public Pack updatePack(@PathVariable Long id, @RequestBody Pack pack) {
        pack.setId(id);
        return packService.updatePack(pack);
    }

    @DeleteMapping("/{id}")
    public void deletePack(@PathVariable Long id) {
        packService.deletePack(id);
    }
}
