package com.haui.realestatebusiness.repositories;


import com.haui.realestatebusiness.models.entities.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image,String> {
    List<Image> findByBuilding_Id(String id);
}
