package com.haui.realestatebusiness.services.mappers;


import com.haui.realestatebusiness.models.entities.District;
import com.haui.realestatebusiness.models.entities.Province;
import com.haui.realestatebusiness.models.entities.Ward;
import com.haui.realestatebusiness.models.responses.DistrictRp;
import com.haui.realestatebusiness.models.responses.ProvinceRp;
import com.haui.realestatebusiness.models.responses.WardRp;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.stream.Collectors;

@Component
public class LocationMapper {

    public List<ProvinceRp> mapToProvinceRps(List<Province> provinces){
       return provinces.stream().map(province -> {
           ProvinceRp  provinceRp = new ProvinceRp();
           provinceRp.setId(province.getId());
           provinceRp.setName(province.getName());
           return provinceRp;
       }).collect(Collectors.toList());
    }

    public List<DistrictRp> mapToDistrictRps(List<District> districts){
        return districts.stream().map(district -> {
            DistrictRp districtRp = new DistrictRp();
            districtRp.setId(district.getId());
            districtRp.setName(district.getName());
            return districtRp;
        }).collect(Collectors.toList());
    }

    public List<WardRp> mapToWardRps(List<Ward> wards){
        return wards.stream().map(ward -> {
            WardRp wardRp = new WardRp();
            wardRp.setId(ward.getId());
            wardRp.setName(ward.getName());
            return wardRp;
        }).collect(Collectors.toList());
    }
}
