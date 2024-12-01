package com.gestiontaches.todo_app.repository;

import com.gestiontaches.todo_app.model.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {
}
