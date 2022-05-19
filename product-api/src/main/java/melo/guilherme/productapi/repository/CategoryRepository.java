package melo.guilherme.productapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import melo.guilherme.productapi.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
