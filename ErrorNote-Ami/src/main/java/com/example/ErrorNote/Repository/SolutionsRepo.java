package com.example.ErrorNote.Repository;

import com.example.ErrorNote.Modele.Solutions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface SolutionsRepo extends JpaRepository<Solutions,Long> {
    @Modifying
    @Query(value = "select solutions.idprobleme from solutions, problemes where solutions.idprobleme = problemes.idprobleme and problemes.idprobleme=:idprobleme", nativeQuery = true)
    List<Solutions> recup(@PathVariable("idprobleme") long idprobleme);
}
