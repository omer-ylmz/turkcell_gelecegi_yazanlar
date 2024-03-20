package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.FuelService;
import com.turkcell.rentacar.dataAccess.abstracts.FuelRepository;
import com.turkcell.rentacar.entities.concretes.Brand;
import com.turkcell.rentacar.entities.concretes.Fuel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class FuelManager implements FuelService {
    FuelRepository fuelRepository; // IoC
    private static final String fuelNotFoundMessage = "Fuel not found";
    private static final String fuelAlreadyExistsMessage = "Fuel already exists";


    @Override
    public Fuel add(Fuel fuel) {
        Fuel createdFuel=  fuelRepository.save(fuel);
        return createdFuel;
    }

    @Override
    public Fuel update(Fuel fuel) {
        Optional<Fuel> foundOptionalFuel = fuelRepository.findById(fuel.getId());
        fuelShouldBeExist(foundOptionalFuel);
        fuelNameCanNotBeDuplicatedWhenUpdated(fuel);

        Fuel fuelToUpdate = foundOptionalFuel.get();
        fuelToUpdate.setName(fuel.getName());

        return fuelRepository.save(fuelToUpdate);
    }

    @Override
    public void delete(int id) {
        Optional<Fuel> foundOptionalFuel = fuelRepository.findById(id);
        fuelShouldBeExist(foundOptionalFuel);
        fuelRepository.delete(foundOptionalFuel.get());
    }

    @Override
    public List<Fuel> getAll() {
        return fuelRepository.findAll();
    }

    @Override
    public Fuel get(int id) {
        Optional<Fuel> foundOptionalFuel = fuelRepository.findById(id);
        fuelShouldBeExist(foundOptionalFuel);
        return foundOptionalFuel.get();
    }


    private void fuelShouldBeExist(Optional<Fuel> fuel) {
        if (fuel.isEmpty()) {
            throw new RuntimeException(fuelNotFoundMessage);
        }
    }

    private void fuelNameCanNotBeDuplicatedWhenUpdated(Fuel fuel) {
        boolean exists = fuelRepository.existsByNameIgnoreCaseAndIdIsNot(fuel.getName().trim(), fuel.getId());
        if (exists) {
            throw new RuntimeException(fuelAlreadyExistsMessage);
        }
    }
}
