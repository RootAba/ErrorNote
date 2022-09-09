package com.example.ErrorNote.Service;

import com.example.ErrorNote.Modele.Solutions;
import com.example.ErrorNote.Repository.SolutionsRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class SolutionService implements SolutionInterface {
    private SolutionsRepo sr;

    @Override
    public Solutions CreerSolution(Solutions solutions) {

        return sr.save(solutions);
    }

    @Override
    public Solutions RecupererIdSoL(Long idsolution) {
        return sr.findById(idsolution).get();
    }

    @Override
    public Solutions modifierSolution(Solutions solutions, long idsolution) {
        return sr.findById(idsolution).map(
                p->{
                    p.setDesccriptionsolution(solutions.getDesccriptionsolution());
                    p.setRessource(solutions.getRessource());
                    return sr.save(p);
                }
        ).orElseThrow(() -> new RuntimeException("Solution non trouvé"));

    }

    @Override
    public List<Solutions> verifiSi(Solutions solutions, long idprobleme) {
        return sr.recup(idprobleme);
    }
}
