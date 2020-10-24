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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author victo
 */
@Entity
@Table(name = "Classe")
@NamedQueries({
    @NamedQuery(name = "Classe.findAll", query = "SELECT c FROM Classe c"),
    @NamedQuery(name = "Classe.findById", query = "SELECT c FROM Classe c WHERE c.id = :id"),
    @NamedQuery(name = "Classe.findByName", query = "SELECT c FROM Classe c WHERE c.name = :name"),
    @NamedQuery(name = "Classe.findByInitialLifePoints", query = "SELECT c FROM Classe c WHERE c.initialLifePoints = :initialLifePoints"),
    @NamedQuery(name = "Classe.findByLevelUpLifePoints", query = "SELECT c FROM Classe c WHERE c.levelUpLifePoints = :levelUpLifePoints"),
    @NamedQuery(name = "Classe.findByInitialManaPoints", query = "SELECT c FROM Classe c WHERE c.initialManaPoints = :initialManaPoints"),
    @NamedQuery(name = "Classe.findByLevelUpEffectId", query = "SELECT c FROM Classe c WHERE c.levelUpEffectId = :levelUpEffectId")})
public class Classe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Column(name = "initialLifePoints")
    private Integer initialLifePoints;
    @Column(name = "levelUpLifePoints")
    private Integer levelUpLifePoints;
    @Column(name = "initialManaPoints")
    private Integer initialManaPoints;
    @Basic(optional = false)
    @Column(name = "levelUpEffectId")
    private int levelUpEffectId;
    @JoinTable(name = "PericiasClasse", joinColumns = {
        @JoinColumn(name = "classeId", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "periciaId", referencedColumnName = "id")})
    @ManyToMany
    private Collection<Pericia> periciaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "classeId")
    private Collection<Player> playerCollection;
    @JoinColumn(name = "arcanistWayId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ArcanistWay arcanistWayId;
    @JoinColumn(name = "barbarianWayId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private BarbarianWay barbarianWayId;
    @JoinColumn(name = "bardWayId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private BardWay bardWayId;
}
