package br.com.epicquest.rpg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.epicquest.rpg.entity.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

}
