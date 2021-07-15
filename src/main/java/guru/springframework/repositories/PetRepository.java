package guru.springframework.repositories;

import guru.springframework.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
