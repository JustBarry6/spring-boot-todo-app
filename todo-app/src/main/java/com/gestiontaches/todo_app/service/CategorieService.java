package com.gestiontaches.todo_app.service;

import com.gestiontaches.todo_app.model.Categorie;
import com.gestiontaches.todo_app.repository.CategorieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategorieService {
    private final CategorieRepository categorieRepository;

    public CategorieService(CategorieRepository categorieRepository) {
        this.categorieRepository = categorieRepository;
    }

    public List<Categorie> obtenirToutesLesCategories() {
        return categorieRepository.findAll();
    }

    public Optional<Categorie> obtenirCategorieParId(Long id) {
        return categorieRepository.findById(id);
    }

    public Categorie creerCategorie(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    public void supprimerCategorie(Long id) {
        categorieRepository.deleteById(id);
    }
}