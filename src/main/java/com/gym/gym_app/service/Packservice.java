package com.gym.gym_app.service;

import com.gym.gym_app.entity.Pack;
import com.gym.gym_app.repository.PackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Packservice {
    @Autowired
    private PackRepository packRepository;
    public List<Pack> getAllPacks() {
        return packRepository.findAll();
    }
    public Pack addPack(Pack pack) {
        return packRepository.save(pack);
    }
    public Pack updatePack(Pack pack) {
        return null;
    }
    public void deletePack(Pack pack) {
        packRepository.delete(pack);
    }

}
