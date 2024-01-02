package com.ft.mnestis.api;

import com.ft.mnestis.establishment.Establishment;
import com.ft.mnestis.establishment.EstablishmentForm;
import com.ft.mnestis.establishment.EstablishmentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;

@RestController()
@RequestMapping("/api")
public class EstablishmentApi {
    private final EstablishmentService establishmentService;

    public EstablishmentApi(EstablishmentService establishmentService) {
        this.establishmentService = establishmentService;
    }

    @PostMapping("/filial")
    @Transactional
    public ResponseEntity create(@RequestBody @Valid EstablishmentForm form, UriComponentsBuilder builder) {
        URI uri;
        Establishment establishment;
        try{
            establishment = establishmentService.save(form);
            uri = this.getUriFor(builder, establishment);
        } catch(Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.created(uri).body(establishment);
    }

    private URI getUriFor(UriComponentsBuilder builder, Establishment establishment) {
        return builder.path("/filial/").buildAndExpand(establishment.getId()).toUri();
    }
}
