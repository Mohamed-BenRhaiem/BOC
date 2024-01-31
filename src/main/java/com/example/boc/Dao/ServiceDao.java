package com.example.boc.Dao;

import com.example.boc.model.ServiceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceDao extends JpaRepository<ServiceModel,Integer> {
    public ServiceModel findByCodserv(Integer codserv);

}
