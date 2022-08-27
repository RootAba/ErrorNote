package com.example.ErrorNote.Repository;

import com.example.ErrorNote.Modele.Utilisateurs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;

public interface UtilisateurRepo extends JpaRepository<Utilisateurs,Long> {
    @Transactional
    @Modifying
    @Query(value = "select status.idstatut from status ,utilisateurs where status.idstatut=utilisateurs.idstatut and utilisateurs.idstatut=:idstatut ",nativeQuery = true)
    int rechercherStatut(@PathVariable("idstatut") long idstatut);
}
