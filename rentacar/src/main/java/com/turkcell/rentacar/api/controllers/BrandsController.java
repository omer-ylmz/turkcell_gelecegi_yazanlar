package com.turkcell.rentacar.api.controllers;


import com.turkcell.rentacar.business.abstracts.BrandService;
import com.turkcell.rentacar.business.dtos.requests.CreatedBrandRequest;
import com.turkcell.rentacar.business.dtos.responses.CreatedBrandResponse;
import com.turkcell.rentacar.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/brands")
public class BrandsController {

    private BrandService brandService;  //IoC

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedBrandResponse add(@RequestBody CreatedBrandRequest createBrandRequest){
        return brandService.add(createBrandRequest);
    }

    @PutMapping
    public Brand update(@RequestBody Brand brand){
        return  brandService.update(brand);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        brandService.delete(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Brand get(@PathVariable int id) {
        return brandService.get(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Brand> getAll() {
        return brandService.getAll();
    }

}
