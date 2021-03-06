package br.com.epicquest.rpg.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.epicquest.rpg.entity.Adventure;

@Repository
public interface AdventureRepository extends JpaRepository<Adventure, Long> {
	// Optional<User> findByUserName(String userName);

}
