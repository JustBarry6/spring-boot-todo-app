package com.gestiontaches.todo_app.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
public class Tache {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Le titre ne peut pas être vide")
    @Size(max = 255, message = "Le titre ne peut pas dépasser 100 caractères")
    private String titre;

    @Size(max = 500, message = "La description ne peut pas dépasser 500 caractères")
    private String description;

    private boolean terminee;

    @Enumerated(EnumType.STRING)
    private Priorite priorite;

    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;

    private LocalDateTime dateCreation;
    private LocalDateTime dateModification;

    // Constructeur par défaut
    public Tache() {
        this.dateCreation = LocalDateTime.now();
    }

    // Getters et setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isTerminee() {
        return terminee;
    }

    public void setTerminee(boolean terminee) {
        this.terminee = terminee;
    }

    public Priorite getPriorite() {
        return priorite;
    }

    public void setPriorite(Priorite priorite) {
        this.priorite = priorite;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public LocalDateTime getDateModification() {
        return dateModification;
    }

    @PreUpdate
    public void setDateModification() {
        this.dateModification = LocalDateTime.now();
    }
}
