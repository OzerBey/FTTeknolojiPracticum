package com.ozer.ftspringpracticum.dataAccess;

import com.ozer.ftspringpracticum.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product, Integer> {
}
