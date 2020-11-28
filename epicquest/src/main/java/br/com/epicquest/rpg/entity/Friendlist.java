package br.com.epicquest.rpg.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@Table(name = "friendlist")
@NamedQueries({ @NamedQuery(name = "Friendlist.findAll", query = "SELECT f FROM Friendlist f"),
		@NamedQuery(name = "Friendlist.findByStatus", query = "SELECT f FROM Friendlist f WHERE f.status = :status"),
		@NamedQuery(name = "Friendlist.findByRegId", query = "SELECT f FROM Friendlist f WHERE f.id = :id") })
public class Friendlist implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Basic(optional = false)
	@Column(name = "status")
	private int status;
	@JoinColumn(name = "userId", referencedColumnName = "id")
	@ManyToOne(optional = false)
	private User userId;
	@JoinColumn(name = "friendId", referencedColumnName = "id")
	@ManyToOne(optional = false)
	private User friendId;
}