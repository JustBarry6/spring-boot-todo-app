package com.gestiontaches.todo_app.repository;

import com.gestiontaches.todo_app.model.Tache;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TacheRepository extends JpaRepository<Tache, Long> {
}