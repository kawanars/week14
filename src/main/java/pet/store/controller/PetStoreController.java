package pet.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import pet.store.controller.model.PetStoreData;
import pet.store.service.PetStoreService;


@RestController
@Slf4j
@RequestMapping("/pet_store")
public class PetStoreController {
	@Autowired
	private PetStoreService petStoreService;
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public PetStoreData createPetStore(@RequestBody PetStoreData petStoreData) {
		log.info("create a pet store: {}", petStoreData);
		PetStoreData savedPetStoreData = petStoreService.savePetStore(petStoreData);
		log.info("Pet store was created: {}", savedPetStoreData);
		return savedPetStoreData;
	}

	@PutMapping("/{petStoreId}")
	public PetStoreData updatePetStore(@PathVariable Long petStoreId, @RequestBody PetStoreData petStoreData) {
		log.info("Updated pet store {}", petStoreId);
		petStoreData.setPetStoreId(petStoreId); 
		PetStoreData updatedPetStoreData = petStoreService.savePetStore(petStoreData);
		log.info("Pet store ID was created {}", petStoreId);
		return updatedPetStoreData;
	}

}