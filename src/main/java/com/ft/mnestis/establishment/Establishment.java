package com.ft.mnestis.establishment;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
public class Establishment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 150)
    private String name;

    @NotBlank
    @Size(max = 14)
    private String cnpj;

    @NotBlank
    @Size(max = 250)
    private String address;

    @NotBlank
    @Size(max = 11)
    private String phone;

    @Positive
    private int motorcycleVacancy;

    @Positive
    private int carVacancy;

    @NotBlank
    private LocalDate createdAt;

    public Establishment(String name, String cnpj, String address, String phone, int motorcycleVacancy, int carVacancy) {
        this.name = name;
        this.cnpj = cnpj;
        this.address = address;
        this.phone = phone;
        this.motorcycleVacancy = motorcycleVacancy;
        this.carVacancy = carVacancy;
        this.createdAt = LocalDate.now();
    }

    @Deprecated
    protected Establishment() {}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public int getMotorcycleVacancy() {
        return motorcycleVacancy;
    }

    public int getCarVacancy() {
        return carVacancy;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }
}
