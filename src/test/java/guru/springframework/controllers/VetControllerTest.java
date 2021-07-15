package guru.springframework.controllers;

import guru.springframework.ControllerTests;
import guru.springframework.fauxspring.Model;
import guru.springframework.model.Vet;
import guru.springframework.services.SpecialtyService;
import guru.springframework.services.VetService;
import guru.springframework.services.map.SpecialityMapService;
import guru.springframework.services.map.VetMapService;
import guru.springframework.spring.ModelMapImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


class VetControllerTest implements ControllerTests {

    VetService vetService;
    SpecialtyService specialtyService;

    VetController vetController;

    @BeforeEach
    void setUp() {
        specialtyService = new SpecialityMapService();
        vetService = new VetMapService(specialtyService);

        vetController = new VetController(vetService);
        Vet vet1 = new Vet(1l, "Sohail", "Ahamed", null);
        Vet vet2 = new Vet(2l, "Shaik", "Ahamed", null);

        vetService.save(vet1);
        vetService.save(vet2);

    }

    @Test
    void listVets() {
        Model model = new ModelMapImpl();
        String view = vetController.listVets(model);

        assertThat("vets/index").isEqualTo(view);

        Set modelAttribute = (Set) ((ModelMapImpl) model).getMap().get("vets");

        assertThat(modelAttribute.size()).isEqualTo(2);
    }
}