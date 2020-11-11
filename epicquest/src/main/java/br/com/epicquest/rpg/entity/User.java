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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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

	@JoinTable(name = "AdventureUsers", joinColumns = {
			@JoinColumn(name = "userId", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "adventureId", referencedColumnName = "id") })
	@ManyToMany
	private List<Adventure> adventures;

	@JoinTable(name = "user_friends", joinColumns = {
			@JoinColumn(name = "user_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "friend_id", referencedColumnName = "id") })
	@ManyToMany
	private List<User> userCollection;
	@ManyToMany(mappedBy = "userCollection")
	private List<User> userCollection1;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
	private List<Friendlist> friendlistCollection;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "friendId")
	private List<Friendlist> friendlistCollection1;

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