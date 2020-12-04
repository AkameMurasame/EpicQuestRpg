package br.com.epicquest.rpg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.epicquest.rpg.entity.Deus;

@Repository
public interface DeusRepository extends JpaRepository<Deus, Integer>{

}
