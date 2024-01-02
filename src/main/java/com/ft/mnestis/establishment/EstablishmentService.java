package com.ft.mnestis.establishment;

import org.springframework.stereotype.Service;

@Service
public class EstablishmentService {
    private final EstablishmentRepository establishmentRepository;

    public EstablishmentService(EstablishmentRepository establishmentRepository) {
        this.establishmentRepository = establishmentRepository;
    }

    public Establishment save(EstablishmentForm form) {
        var establishment = new Establishment(form);
        this.establishmentRepository.save(establishment);
        return establishment;
    }
}
