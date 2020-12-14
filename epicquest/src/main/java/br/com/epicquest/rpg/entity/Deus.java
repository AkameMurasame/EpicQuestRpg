package br.com.epicquest.rpg.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Deus")
@NamedQueries({
    @NamedQuery(name = "Deus.findAll", query = "SELECT d FROM Deus d"),
    @NamedQuery(name = "Deus.findById", query = "SELECT d FROM Deus d WHERE d.id = :id"),
    @NamedQuery(name = "Deus.findByName", query = "SELECT d FROM Deus d WHERE d.name = :name"),
    @NamedQuery(name = "Deus.findByObjectve", query = "SELECT d FROM Deus d WHERE d.objectve = :objectve"),
    @NamedQuery(name = "Deus.findByEnergy", query = "SELECT d FROM Deus d WHERE d.energy = :energy"),
    @NamedQuery(name = "Deus.findByWeapon", query = "SELECT d FROM Deus d WHERE d.weapon = :weapon")})
public class Deus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Lob
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "objectve")
    private String objectve;
    @Basic(optional = false)
    @Lob
    @Column(name = "symbol")
    private String symbol;
    @Column(name = "energy")
    private String energy;
    @Column(name = "weapon")
    private String weapon;
    @Lob
    @Column(name = "obligations")
    private String obligations;
    @Lob
    @Column(name = "restrictions")
    private String restrictions;
    @JoinTable(name = "RacasDeus", joinColumns = {
        @JoinColumn(name = "deusId", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "raceId", referencedColumnName = "id")})
    @ManyToMany
    private Collection<Race> raceCollection;
}
