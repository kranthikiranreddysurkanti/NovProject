package com.kranthi.novprojectmodule.repository;

import com.kranthi.novprojectmodule.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findCategoryByTitle(String title);

    Category save(Category category);
}
