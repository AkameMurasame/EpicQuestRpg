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
@Table(name = "Pericia")
@NamedQueries({
    @NamedQuery(name = "Pericia.findAll", query = "SELECT p FROM Pericia p"),
    @NamedQuery(name = "Pericia.findById", query = "SELECT p FROM Pericia p WHERE p.id = :id"),
    @NamedQuery(name = "Pericia.findByName", query = "SELECT p FROM Pericia p WHERE p.name = :name"),
    @NamedQuery(name = "Pericia.findByAttribute", query = "SELECT p FROM Pericia p WHERE p.attribute = :attribute"),
    @NamedQuery(name = "Pericia.findByOnlyTrained", query = "SELECT p FROM Pericia p WHERE p.onlyTrained = :onlyTrained"),
    @NamedQuery(name = "Pericia.findByArmorPenalty", query = "SELECT p FROM Pericia p WHERE p.armorPenalty = :armorPenalty")})
public class Pericia implements Serializable {

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
    @Column(name = "attribute")
    private String attribute;
    
    @Basic(optional = false)
    @Column(name = "onlyTrained")
    private boolean onlyTrained;
    
    @Basic(optional = false)
    @Column(name = "armorPenalty")
    private boolean armorPenalty;
    
    @JoinTable(name = "PericiasRace", joinColumns = {
        @JoinColumn(name = "periciaId", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "raceId", referencedColumnName = "id")})
    @ManyToMany
    private List<Race> raceCollection;
    
    @ManyToMany(mappedBy = "periciaCollection")
    private List<Classe> classeCollection;
    
    @JoinTable(name = "PericiasPlayer", joinColumns = {
        @JoinColumn(name = "periciaId", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "playerId", referencedColumnName = "id")})
    @ManyToMany
    private List<Player> playerCollection;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "periciaTrained")
    private List<SorcererLineageBuff> sorcererLineageBuffCollection;
}
