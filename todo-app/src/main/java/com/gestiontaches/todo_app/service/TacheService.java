package com.gestiontaches.todo_app.service;

import com.gestiontaches.todo_app.model.Categorie;
import com.gestiontaches.todo_app.model.Tache;
import com.gestiontaches.todo_app.model.Priorite;
import com.gestiontaches.todo_app.repository.CategorieRepository;
import com.gestiontaches.todo_app.repository.TacheRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TacheService {
    private final TacheRepository tacheRepository;
    private final CategorieRepository categorieRepository;

    public TacheService(TacheRepository tacheRepository, CategorieRepository categorieRepository) {
        this.tacheRepository = tacheRepository;
        this.categorieRepository = categorieRepository;
    }

    public List<Tache> obtenirToutesLesTaches() {
        return tacheRepository.findAll();
    }

    public Optional<Tache> obtenirTacheParId(Long id) {
        return tacheRepository.findById(id);
    }

    public Tache creerTache(Tache tache) {
        if (tache.getCategorie() != null) {
            Optional<Categorie> categorie = categorieRepository.findById(tache.getCategorie().getId());
            if (categorie.isEmpty()) {
                throw new RuntimeException("La catégorie spécifiée n'existe pas");
            }
        }
        return tacheRepository.save(tache);
    }

    public Tache updateTache(Long id, Tache tache) {
        return tacheRepository.findById(id)
                .map(tacheExistante -> {
                    tacheExistante.setTitre(tache.getTitre());
                    tacheExistante.setDescription(tache.getDescription());
                    tacheExistante.setTerminee(tache.isTerminee());
                    tacheExistante.setPriorite(tache.getPriorite());

                    if (tache.getCategorie() != null && tache.getCategorie().getId() != null) {
                        Optional<Categorie> categorieOpt = categorieRepository.findById(tache.getCategorie().getId());
                        if (categorieOpt.isPresent()) {
                            tacheExistante.setCategorie(categorieOpt.get());
                        } else {
                            throw new RuntimeException("La catégorie spécifiée n'existe pas.");
                        }
                    }
                    return tacheRepository.save(tacheExistante);
                })
                .orElseThrow(() -> new RuntimeException("Tâche non trouvée avec l'id : " + id));
    }



    public void supprimerTache(Long id) {
        tacheRepository.deleteById(id);
    }

    public List<Tache> obtenirTachesParCategorie(Long categorieId) {
        return tacheRepository.findByCategorieId(categorieId);
    }

    public List<Tache> obtenirTachesParPriorite(Priorite priorite) {
        return tacheRepository.findByPriorite(priorite);
    }
}