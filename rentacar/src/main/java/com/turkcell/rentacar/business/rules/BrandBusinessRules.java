package com.turkcell.rentacar.business.rules;

import com.turkcell.rentacar.dataAccess.abstracts.BrandRepository;
import com.turkcell.rentacar.entities.concretes.Brand;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BrandBusinessRules {
    BrandRepository brandRepository;

    public void brandNameCanNotBeDuplicated(String brandName){
        Optional<Brand> brand = brandRepository.findByNameIgnoreCase(brandName);
        if(brand.isPresent()){
            throw new RuntimeException("Brand Exists");
        }
    }
}
