package com.gestiontaches.todo_app.repository;

import com.gestiontaches.todo_app.model.Priorite;
import com.gestiontaches.todo_app.model.Tache;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TacheRepository extends JpaRepository<Tache, Long> {
    List<Tache> findByCategorieId(Long categorieId);
    List<Tache> findByPriorite(Priorite priorite);
}