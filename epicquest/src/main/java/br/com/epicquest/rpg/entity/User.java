package br.com.epicquest.rpg.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "User")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Long id;

	@Basic(optional = false)
	@Column(name = "userName")
	private String userName;

	@Basic(optional = false)
	@Column(name = "fullName")
	private String fullName;

	@Basic(optional = false)
	@Column(name = "description")
	private String description;

	@Basic(optional = false)
	@Column(name = "password")
	private String password;

	@Basic(optional = false)
	@Column(name = "email")
	private String email;

	@Column(name = "photoDirectory")
	private String photoUrl;

	@ManyToMany(mappedBy = "users")
	private List<Adventure> adventures;

	@ManyToMany(mappedBy = "users")
	private List<Anotation> anotations;

	@OneToMany(mappedBy = "userId")
	private List<Notification> notification;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
	private List<Friendlist> friendlistCollection;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "friendId")
	private List<Friendlist> friendlistCollection1;
	
	@ManyToMany(mappedBy = "users")
	private List<Notification> notificationCollection;

	/*
	 * @JoinTable(name = "PermissionList", joinColumns = {
	 * 
	 * @JoinColumn(name = "userId", referencedColumnName = "userId") },
	 * inverseJoinColumns = {
	 * 
	 * @JoinColumn(name = "permissionId", referencedColumnName = "permissionId") })
	 * 
	 * @ManyToMany private List<Permission> permissions;
	 */
}