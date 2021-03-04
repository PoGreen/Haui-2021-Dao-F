package com.haui.realestatebusiness.repositories;


import com.haui.realestatebusiness.models.entities.BuildingCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BuildingCategoryRepository extends JpaRepository<BuildingCategory, String> {
    boolean existsByName(String name);
    List<BuildingCategory> findByStatus(int status);

}
