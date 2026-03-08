package net.layla.tp2springmvcjpa.repository;

import net.layla.tp2springmvcjpa.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
