package com.oasisaac.gapsytest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oasisaac.gapsytest.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
