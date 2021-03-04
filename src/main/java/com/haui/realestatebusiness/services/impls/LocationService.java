package com.haui.realestatebusiness.services.impls;


import com.haui.realestatebusiness.models.bos.Response;
import com.haui.realestatebusiness.models.bos.SystemResponse;
import com.haui.realestatebusiness.models.entities.District;
import com.haui.realestatebusiness.models.entities.Province;
import com.haui.realestatebusiness.models.entities.Ward;
import com.haui.realestatebusiness.models.responses.DistrictRp;
import com.haui.realestatebusiness.models.responses.ProvinceRp;
import com.haui.realestatebusiness.models.responses.WardRp;
import com.haui.realestatebusiness.repositories.DistrictRepository;
import com.haui.realestatebusiness.repositories.ProvinceRepository;
import com.haui.realestatebusiness.repositories.WardRepository;
import com.haui.realestatebusiness.services.ILocationService;
import com.haui.realestatebusiness.services.mappers.LocationMapper;
import com.haui.realestatebusiness.utils.Global;
import com.haui.realestatebusiness.utils.StringRp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class LocationService implements ILocationService {

    @Autowired
    private ProvinceRepository provinceRepository;
    @Autowired
    private DistrictRepository districtRepository;
    @Autowired
    private WardRepository wardRepository;

    @Autowired
    private LocationMapper locationMapper;

    @Override
    public ResponseEntity<SystemResponse<Object>> getAllProvinces() {
        List<Province> provinces = provinceRepository.findAll();
        List<ProvinceRp> provinceRps = locationMapper.mapToProvinceRps(provinces);
        Map<String,Object> result = new HashMap<>();
        result.put(Global.PROVINCES,provinceRps);
        return Response.ok(result);
    }

    @Override
    public ResponseEntity<SystemResponse<Object>> getDistrictsByProvince(int provinceId) {
        Province province = provinceRepository.findById(provinceId).orElse(null);
        if(Objects.isNull(province)){
            return Response.badRequest(StringRp.PROVINCE_IS_FAKE);
        }
        List<District> districts = districtRepository.findByProvince_Id(provinceId);
        List<DistrictRp> districtRps = locationMapper.mapToDistrictRps(districts);
        Map<String,Object> result = new HashMap<>();
        result.put(Global.DISTRICTS,districtRps);
        return Response.ok(result);
    }

    @Override
    public ResponseEntity<SystemResponse<Object>> getWardsByDistrict(int districtId) {
        District district = districtRepository.findById(districtId).orElse(null);
        if(Objects.isNull(district)){
            return Response.badRequest(StringRp.DISTRICT_IS_FAKE);
        }
        List<Ward> wards = wardRepository.findByDistrict_Id(districtId);
        List<WardRp> wardRps = locationMapper.mapToWardRps(wards);
        Map<String,Object> result = new HashMap<>();
        result.put(Global.WARDS,wardRps);
        return Response.ok(result);
    }

    @Override
    public String getLocationByWard(int wardId) {
        Ward ward = wardRepository.findById(wardId).orElse(null);
        if (!Objects.isNull(ward)) {
            District district = ward.getDistrict();
            Province province = district.getProvince();
            return province.getName() + " - " + district.getName() + " - " + ward.getName();
        }
        return "";
    }
}
