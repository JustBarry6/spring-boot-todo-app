package com.gestiontaches.todo_app.service;

import com.gestiontaches.todo_app.model.Tache;
import com.gestiontaches.todo_app.repository.TacheRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TacheService {
    private final TacheRepository tacheRepository;

    public TacheService(TacheRepository tacheRepository) {
        this.tacheRepository = tacheRepository;
    }

    public List<Tache> obtenirToutesLesTaches() {
        return tacheRepository.findAll();
    }

    public Optional<Tache> obtenirTacheParId(Long id) {
        return tacheRepository.findById(id);
    }

    public Tache creerTache(Tache tache) {
        return tacheRepository.save(tache);
    }

    public void supprimerTache(Long id) {
        tacheRepository.deleteById(id);
    }
}