package com.turkcell.rentacar.core.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor

@Data //getter setteri yapar

@MappedSuperclass
public class BaseEntity {

    @Id //primary key kolondur demek
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "createdDate")
    private LocalDateTime createdDate;
    @Column(name = "updateDate")
    private LocalDateTime updatedDate;
    @Column(name = "deletedDate")
    private LocalDateTime deletedDate;


}
