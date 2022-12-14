package com.example.ErrorNote.Repository;

import com.example.ErrorNote.Modele.Commentaires;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface CommentairesRepo extends JpaRepository<Commentaires,Long> {
    @Transactional
    @Modifying
    @Query(value = "SELECT commentaires.idcom, commentaires.contenuecomm from commentaires ,solutions where commentaires.idsolution=solutions.idsolution and solutions.idsolution=:idsolution",nativeQuery = true)
    List<Commentaires> RepoafficherTousSurUser(@Param("idsolution") long idsolution);
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO `commentaires` (`contenuecomm`, `idsolution`, `idautreuser`) VALUES (:contenuecomm, :idsolution , :iduser)",nativeQuery = true)
    //List<Commentaires> ajoutCommAutreUser(@Param("idsolution") Long idsolution);
    //(SELECT idsolution FROM solutions where idsolution=:idsolution)
    int ajoutCommAutreUser(@Param("contenuecomm") String contenuecomm,@Param("idsolution") Long idsolution,@Param("iduser") Long iduser);
}
