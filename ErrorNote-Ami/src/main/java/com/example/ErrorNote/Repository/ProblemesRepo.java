package com.example.ErrorNote.Repository;

import com.example.ErrorNote.Modele.Problemes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProblemesRepo extends JpaRepository<Problemes,Long> {
    @Query(value = "select * from problemes where problemes.titre=:titre",nativeQuery = true)
    List<Problemes> Rechercher(@Param("titre") String titre);


    @Query(value = "select * from problemes where problemes.iduser=:iduser",nativeQuery = true)
    List<Problemes> selectUser(@Param("iduser") long iduser);
}
