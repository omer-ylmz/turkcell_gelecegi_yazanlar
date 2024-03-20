package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.FuelService;
import com.turkcell.rentacar.business.abstracts.ModelService;
import com.turkcell.rentacar.dataAccess.abstracts.FuelRepository;
import com.turkcell.rentacar.dataAccess.abstracts.ModelRepository;
import com.turkcell.rentacar.entities.concretes.Brand;
import com.turkcell.rentacar.entities.concretes.Fuel;
import com.turkcell.rentacar.entities.concretes.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ModelManager implements ModelService {
  ModelRepository modelRepository;
    private static final String modelNotFoundMessage = "Model not found";



    @Override
    public Model add(Model model) {
        Model createdmodel =  modelRepository.save(model);
        return createdmodel;
    }

    @Override
    public Model update(Model model) {
        Optional<Model> foundOptionalModel = modelRepository.findById(model.getId());
        modelShouldBeExist(foundOptionalModel);

        Model modelToUpdate = foundOptionalModel.get();
        modelToUpdate.setName(model.getName());

        return modelRepository.save(modelToUpdate);
    }

    @Override
    public void delete(int id) {
        Optional<Model> foundOptionalModel = modelRepository.findById(id);
        modelShouldBeExist(foundOptionalModel);
        modelRepository.delete(foundOptionalModel.get());
    }

    @Override
    public List<Model> getAll() {
        return modelRepository.findAll();
    }

    @Override
    public Model get(int id) {
        Optional<Model> foundOptionalModel = modelRepository.findById(id);
        modelShouldBeExist(foundOptionalModel);
        return foundOptionalModel.get();
    }


    private void modelShouldBeExist(Optional<Model> model) {
        if (model.isEmpty()) {
            throw new RuntimeException(modelNotFoundMessage);
        }
    }


}
