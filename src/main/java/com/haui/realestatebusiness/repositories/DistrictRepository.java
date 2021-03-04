package com.haui.realestatebusiness.repositories;


import com.haui.realestatebusiness.models.entities.District;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DistrictRepository extends JpaRepository<District,Integer> {
    List<District> findByProvince_Id(int provinceId);
}
