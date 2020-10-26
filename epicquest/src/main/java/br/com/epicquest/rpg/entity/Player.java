package br.com.epicquest.rpg.entity;

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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Player")
@NamedQueries({
    @NamedQuery(name = "Player.findAll", query = "SELECT p FROM Player p"),
    @NamedQuery(name = "Player.findById", query = "SELECT p FROM Player p WHERE p.id = :id"),
    @NamedQuery(name = "Player.findByName", query = "SELECT p FROM Player p WHERE p.name = :name"),
    @NamedQuery(name = "Player.findByNivel", query = "SELECT p FROM Player p WHERE p.nivel = :nivel"),
    @NamedQuery(name = "Player.findByAlignment", query = "SELECT p FROM Player p WHERE p.alignment = :alignment"),
    @NamedQuery(name = "Player.findByAge", query = "SELECT p FROM Player p WHERE p.age = :age"),
    @NamedQuery(name = "Player.findByLifePoints", query = "SELECT p FROM Player p WHERE p.lifePoints = :lifePoints"),
    @NamedQuery(name = "Player.findByManaPoints", query = "SELECT p FROM Player p WHERE p.manaPoints = :manaPoints"),
    @NamedQuery(name = "Player.findByTotalLifePoints", query = "SELECT p FROM Player p WHERE p.totalLifePoints = :totalLifePoints"),
    @NamedQuery(name = "Player.findByTotalManaPoints", query = "SELECT p FROM Player p WHERE p.totalManaPoints = :totalManaPoints"),
    @NamedQuery(name = "Player.findByCaPoints", query = "SELECT p FROM Player p WHERE p.caPoints = :caPoints"),
    @NamedQuery(name = "Player.findByDisplacement", query = "SELECT p FROM Player p WHERE p.displacement = :displacement"),
    @NamedQuery(name = "Player.findByStrength", query = "SELECT p FROM Player p WHERE p.strength = :strength"),
    @NamedQuery(name = "Player.findByWisdom", query = "SELECT p FROM Player p WHERE p.wisdom = :wisdom"),
    @NamedQuery(name = "Player.findByDexterity", query = "SELECT p FROM Player p WHERE p.dexterity = :dexterity"),
    @NamedQuery(name = "Player.findByConstitution", query = "SELECT p FROM Player p WHERE p.constitution = :constitution"),
    @NamedQuery(name = "Player.findByIntelligence", query = "SELECT p FROM Player p WHERE p.intelligence = :intelligence"),
    @NamedQuery(name = "Player.findByCharisma", query = "SELECT p FROM Player p WHERE p.charisma = :charisma"),
    @NamedQuery(name = "Player.findByTibar", query = "SELECT p FROM Player p WHERE p.tibar = :tibar")})
public class Player implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    
    @Basic(optional = false)
    @Lob
    @Column(name = "photoUrl")
    private String photoUrl;
    
    @Basic(optional = false)
    @Column(name = "nivel")
    private int nivel;
    
    @Basic(optional = false)
    @Column(name = "alignment")
    private String alignment;
    
    @Column(name = "age")
    private Integer age;
    
    @Column(name = "lifePoints")
    private Integer lifePoints;
    
    @Column(name = "manaPoints")
    private Integer manaPoints;
    
    @Column(name = "totalLifePoints")
    private Integer totalLifePoints;
    
    @Column(name = "totalManaPoints")
    private Integer totalManaPoints;
    
    @Column(name = "caPoints")
    private Integer caPoints;
    
    @Column(name = "displacement")
    private Integer displacement;
    
    @Column(name = "strength")
    private Integer strength;
    
    @Column(name = "wisdom")
    private Integer wisdom;
    
    @Column(name = "dexterity")
    private Integer dexterity;
    
    @Column(name = "constitution")
    private Integer constitution;
    
    @Column(name = "intelligence")
    private Integer intelligence;
    
    @Column(name = "charisma")
    private Integer charisma;
    
    @Column(name = "tibar")
    private Integer tibar;
    
    @ManyToMany(mappedBy = "playerCollection")
    private List<Iten> itenCollection;
    
    @ManyToMany(mappedBy = "playerCollection")
    private List<Pericia> periciaCollection;
    
    @ManyToMany(mappedBy = "playerCollection")
    private List<Poder> poderCollection;
    
    @JoinTable(name = "AdventurePlayers", joinColumns = {
        @JoinColumn(name = "playerId", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "adventureId", referencedColumnName = "id")})
    @ManyToMany
    private List<Adventure> adventureCollection;
    
    @JoinColumn(name = "userId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User userId;
    
    @JoinColumn(name = "classeId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Classe classeId;
    
    @JoinColumn(name = "raceId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Race raceId;
    
    @JoinColumn(name = "origemId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Origin origemId;
    
    @JoinColumn(name = "deusId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Deus deusId;
}
