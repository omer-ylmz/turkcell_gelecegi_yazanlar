package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.BrandService;
import com.turkcell.rentacar.business.dtos.requests.CreatedBrandRequest;
import com.turkcell.rentacar.business.dtos.responses.CreatedBrandResponse;
import com.turkcell.rentacar.business.rules.BrandBusinessRules;
import com.turkcell.rentacar.core.utilities.mapping.ModelMapperManager;
import com.turkcell.rentacar.core.utilities.mapping.ModelMapperService;
import com.turkcell.rentacar.dataAccess.abstracts.BrandRepository;
import com.turkcell.rentacar.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class BrandManager implements BrandService {

    private BrandRepository brandRepository;
    private ModelMapperService modelMapperService;
    private BrandBusinessRules brandBusinessRules;
    private static final String brandNotFound = "Brand not found";
    private static final String brandAlreadyExists = "Brand already exists";


    @Override
    public CreatedBrandResponse add(CreatedBrandRequest createBrandRequest) {
        Brand brand = this.modelMapperService.forRequest().map(createBrandRequest,Brand.class);

        brand.setCreatedDate(LocalDateTime.now());

        Brand createdBrand =  brandRepository.save(brand);

        CreatedBrandResponse createdBrandResponse = this.modelMapperService.forResponse().map(createdBrand, CreatedBrandResponse.class);

        return createdBrandResponse;
    }

    @Override
    public Brand update(Brand brand) {
        Optional<Brand> foundOptionalBrand = brandRepository.findById(brand.getId());
        brandShouldBeExist(foundOptionalBrand);
        brandNameCanNotBeDuplicatedWhenUpdated(brand);
        Brand brandToUpdate = foundOptionalBrand.get();
        brandToUpdate.setName(brand.getName()); // TODO: mapper
        return brandRepository.save(brandToUpdate);

    }

    @Override
    public void delete(int id) {
        Optional<Brand> foundOptionalBrand = brandRepository.findById(id);
        brandShouldBeExist(foundOptionalBrand);
        brandRepository.delete(foundOptionalBrand.get());
    }

    @Override
    public List<Brand> getAll() {
        return brandRepository.findAll();

    }

    @Override
    public Brand get(int id) {
        Optional<Brand> foundOptionalBrand = brandRepository.findById(id);
        brandShouldBeExist(foundOptionalBrand);
        return foundOptionalBrand.get();
    }

    private void brandShouldBeExist(Optional<Brand> brand) {
        if (brand.isEmpty()) {
            throw new RuntimeException(brandNotFound);
        }
    }

    private void brandNameCanNotBeDuplicatedWhenUpdated(Brand brand) {
        boolean exists = brandRepository.existsByNameIgnoreCaseAndIdIsNot(brand.getName().trim(), brand.getId());
        if (exists) {
            throw new RuntimeException(brandAlreadyExists);
        }


    }
}


//ioc nedir?
