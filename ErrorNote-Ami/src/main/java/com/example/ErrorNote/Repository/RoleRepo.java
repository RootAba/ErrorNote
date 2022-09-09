package com.example.ErrorNote.Repository;

import com.example.ErrorNote.Modele.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role,Long> {
    Role findByIdstatut(Long idstatut);
}
