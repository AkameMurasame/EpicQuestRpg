package br.com.epicquest.rpg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.epicquest.rpg.entity.Classe;

@Repository
public interface ClasseRepository extends JpaRepository<Classe, Integer>{

}
