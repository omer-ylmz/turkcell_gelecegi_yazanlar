package entities;

import Abstract.IEntity;

import java.time.LocalDate;
import java.util.Date;

public class Customer implements IEntity {
    public int id;
    public String FirstName;
    public String LastName;
    public LocalDate DateOfBirth;
    public String NationlyId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public String getNationlyId() {
        return NationlyId;
    }

    public void setNationlyId(String nationlyId) {
        NationlyId = nationlyId;
    }
}
