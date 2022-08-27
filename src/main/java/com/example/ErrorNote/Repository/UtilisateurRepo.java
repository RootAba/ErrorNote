package com.example.ErrorNote.Repository;

import com.example.ErrorNote.Modele.Utilisateurs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepo extends JpaRepository<Utilisateurs,Long> {
}
