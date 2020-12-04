package br.com.epicquest.rpg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.epicquest.rpg.entity.Iten;

@Repository
public interface ItemRepository extends JpaRepository<Iten, Long> {

}
