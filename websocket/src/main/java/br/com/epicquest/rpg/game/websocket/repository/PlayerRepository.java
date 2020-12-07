package br.com.epicquest.rpg.game.websocket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.epicquest.rpg.game.websocket.entity.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {

}
