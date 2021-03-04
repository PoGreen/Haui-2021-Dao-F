package com.haui.realestatebusiness.repositories;

import com.haui.realestatebusiness.models.entities.Building;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BuildingRepository extends JpaRepository<Building,String> {

}
