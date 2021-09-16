package com.sumativa.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sumativa.models.Venta;

@Repository
public interface VentaRepository extends CrudRepository<Venta, Long>{

}
