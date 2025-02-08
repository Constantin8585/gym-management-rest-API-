package com.gym.gym_app.service;

import com.gym.gym_app.entity.Pack;
import com.gym.gym_app.repository.PackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PackService {
    @Autowired
    private final PackRepository packRepository;

    public PackService(PackRepository packRepository) {
        this.packRepository = packRepository;
    }

    public List<Pack> getAllPacks() {
        return packRepository.findAll();
    }

    public Pack getPackById(Long id) {
        Optional<Pack> pack = packRepository.findById(id);
        return pack.orElse(null);
    }

    public Pack addPack(Pack pack) {
        return packRepository.save(pack);
    }

    public Pack updatePack(Pack pack) {
        return packRepository.save(pack);
    }

    public void deletePack(Long id) {
        packRepository.deleteById(id);
    }
}
