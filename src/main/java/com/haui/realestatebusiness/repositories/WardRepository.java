package com.haui.realestatebusiness.repositories;


import com.haui.realestatebusiness.models.entities.Ward;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WardRepository extends JpaRepository<Ward,Integer> {
    List<Ward> findByDistrict_Id(int districtId);
}
