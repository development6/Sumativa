package com.sumativa.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sumativa.models.Producto;

@Repository
public interface ProductoRepository extends CrudRepository<Producto, Long> {
	ArrayList<Producto> findAll();
}
