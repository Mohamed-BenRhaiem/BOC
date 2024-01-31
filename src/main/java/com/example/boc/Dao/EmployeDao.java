package com.example.boc.Dao;

import com.example.boc.model.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeDao extends JpaRepository<Employe,Integer> {
    @Query(value = "select codserv,0 as clazz_ from service_model where nomserv=:nomserv",nativeQuery = true)
    Integer getCodServByEmployee(String nomserv);

    Employe findEmloyeeByCodemp(Integer codemp) ;


    Employe findByEmail(String email);

    Optional<Employe> findByNomemp(String nomemp);

    boolean existsByCodemp(Integer codemp);
}
