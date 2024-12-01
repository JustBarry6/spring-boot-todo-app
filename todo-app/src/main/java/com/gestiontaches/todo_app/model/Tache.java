package com.gestiontaches.todo_app.model;

import jakarta.persistence.*;

@Entity
public class Tache {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;
    private String description;
    private boolean terminee;

    // Getters et setters

    // Constructeurs
}