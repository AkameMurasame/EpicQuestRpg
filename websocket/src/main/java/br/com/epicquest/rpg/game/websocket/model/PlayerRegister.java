package br.com.epicquest.rpg.game.websocket.model;

public class PlayerRegister {
	private Long id;
	
	private String nickname;
	
	private Long adventureId;

	public Long getAdventureId() {
		return adventureId;
	}

	public void setAdventureId(Long adventureId) {
		this.adventureId = adventureId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
}
