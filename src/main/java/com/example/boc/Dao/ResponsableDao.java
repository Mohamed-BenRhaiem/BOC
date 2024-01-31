package com.example.boc.Dao;

import com.example.boc.model.Responsable;

import com.example.boc.model.ServiceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponsableDao extends JpaRepository<Responsable,Integer> {


    boolean findByEmail(String email);

    Responsable findByService(ServiceModel service);

    @Query(value = "DELETE FROM Responsable WHERE codemp = :codemp",nativeQuery = true)
    void delete(Integer codemp);
}
