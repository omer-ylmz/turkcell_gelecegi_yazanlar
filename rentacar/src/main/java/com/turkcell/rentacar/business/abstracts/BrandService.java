package com.turkcell.rentacar.business.abstracts;

import com.turkcell.rentacar.business.dtos.requests.CreatedBrandRequest;
import com.turkcell.rentacar.business.dtos.responses.CreatedBrandResponse;
import com.turkcell.rentacar.entities.concretes.Brand;

import java.util.List;

public interface BrandService {
    CreatedBrandResponse add(CreatedBrandRequest createdBrandRequest);

    Brand update(Brand brand);

    void delete(int id);

    List<Brand> getAll();

    Brand get(int id);
}
