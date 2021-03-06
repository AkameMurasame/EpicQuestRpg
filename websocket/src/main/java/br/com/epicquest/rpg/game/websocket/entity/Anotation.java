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
@Table(name = "Anotation")
public class Anotation implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    
    @Basic(optional = false)
    @Column(name = "title")
    private String title;
    
    @Basic(optional = false)
    @Lob
    @Column(name = "content")
    private String content;
    
	@JoinTable(name = "AnotationsUsers", joinColumns = {
			@JoinColumn(name = "anotationId", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "userId", referencedColumnName = "id") })
	@ManyToMany
	private List<User> users;
	
	@JoinColumn(name = "adventureId", referencedColumnName = "id")
	@ManyToOne(optional = false)
	private Adventure adventureId;

}
