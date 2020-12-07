package br.com.epicquest.rpg.game.websocket.model;

import java.util.List;

public class AdventureRoom {

	private Long adventureId;

	private List<PlayerRegister> players;

	public List<PlayerRegister> getPlayers() {
		return players;
	}

	public void setPlayers(List<PlayerRegister> players) {
		this.players = players;
	}

	public Long getAdventureId() {
		return adventureId;
	}

	public void setAdventureId(Long adventureId) {
		this.adventureId = adventureId;
	}
}
