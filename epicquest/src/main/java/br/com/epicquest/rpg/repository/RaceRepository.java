package br.com.epicquest.rpg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.epicquest.rpg.entity.Race;

@Repository
public interface RaceRepository extends JpaRepository<Race, Integer>{

}
