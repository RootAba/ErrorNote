package com.example.ErrorNote.Service;

import com.example.ErrorNote.Modele.Role;
import com.example.ErrorNote.Repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService implements RoleInterface {
@Autowired
private RoleRepo RoleRepo;


    @Override
    public Role RecupererIdStatut(Long idstatut) {
        return RoleRepo.findByIdstatut(idstatut);
    }
}
