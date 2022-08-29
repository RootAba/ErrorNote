package com.example.ErrorNote.Service;

import com.example.ErrorNote.Modele.Commentaires;
import com.example.ErrorNote.Modele.Solutions;
import com.example.ErrorNote.Repository.SolutionsRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
@AllArgsConstructor
@Service
public class Solution_Implement implements Solution_Interface{

    private SolutionsRepo sr;
    /**
     * @param solutions
     * @return
     */
    @Override
    public Solutions CreerSolution(Solutions solutions) {

        return sr.save(solutions);
    }

    @Override
    public Solutions RecupererIdSoL(Long idsolution) {
        return sr.findById(idsolution).get();
    }
}
