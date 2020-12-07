package br.com.epicquest.rpg.game.websocket.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "notification")
public class Notification implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Long id;
	@Basic(optional = false)
	@Lob
	@Column(name = "description")
	private String description;
	
	@JoinColumn(name = "userId", referencedColumnName = "id")
	@ManyToOne(optional = false)
	private User userId;
	
	@JoinColumn(name = "adventureId", referencedColumnName = "id")
	@ManyToOne(optional = true)
	private Adventure adventureId;
	
	@JoinTable(name = "notificationusers", joinColumns = {
			@JoinColumn(name = "notificationId", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "userId", referencedColumnName = "id") })
	@ManyToMany
	private List<User> users;

}
