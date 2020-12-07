package br.com.epicquest.rpg.game.websocket.entity;

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

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "ArcanistWay")
@NamedQueries({
    @NamedQuery(name = "ArcanistWay.findAll", query = "SELECT a FROM ArcanistWay a"),
    @NamedQuery(name = "ArcanistWay.findById", query = "SELECT a FROM ArcanistWay a WHERE a.id = :id"),
    @NamedQuery(name = "ArcanistWay.findByName", query = "SELECT a FROM ArcanistWay a WHERE a.name = :name"),
    @NamedQuery(name = "ArcanistWay.findByMagicCirclesAllowed", query = "SELECT a FROM ArcanistWay a WHERE a.magicCirclesAllowed = :magicCirclesAllowed"),
    @NamedQuery(name = "ArcanistWay.findByHasObjectDependency", query = "SELECT a FROM ArcanistWay a WHERE a.hasObjectDependency = :hasObjectDependency"),
    @NamedQuery(name = "ArcanistWay.findByObjectDependencyDestructionPenalty", query = "SELECT a FROM ArcanistWay a WHERE a.objectDependencyDestructionPenalty = :objectDependencyDestructionPenalty"),
    @NamedQuery(name = "ArcanistWay.findByObjectDependencyReconstructionTibar", query = "SELECT a FROM ArcanistWay a WHERE a.objectDependencyReconstructionTibar = :objectDependencyReconstructionTibar"),
    @NamedQuery(name = "ArcanistWay.findByObjectDependencyReconstructionTime", query = "SELECT a FROM ArcanistWay a WHERE a.objectDependencyReconstructionTime = :objectDependencyReconstructionTime"),
    @NamedQuery(name = "ArcanistWay.findByMainAttribute", query = "SELECT a FROM ArcanistWay a WHERE a.mainAttribute = :mainAttribute"),
    @NamedQuery(name = "ArcanistWay.findByMagicEveryLevel", query = "SELECT a FROM ArcanistWay a WHERE a.magicEveryLevel = :magicEveryLevel"),
    @NamedQuery(name = "ArcanistWay.findByMagicEveryNewCircle", query = "SELECT a FROM ArcanistWay a WHERE a.magicEveryNewCircle = :magicEveryNewCircle")})
public class ArcanistWay implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Column(name = "magicCirclesAllowed")
    private Integer magicCirclesAllowed;
    @Column(name = "hasObjectDependency")
    private Boolean hasObjectDependency;
    @Column(name = "objectDependencyDestructionPenalty")
    private Integer objectDependencyDestructionPenalty;
    @Column(name = "objectDependencyReconstructionTibar")
    private Integer objectDependencyReconstructionTibar;
    @Column(name = "objectDependencyReconstructionTime")
    private Integer objectDependencyReconstructionTime;
    @Column(name = "mainAttribute")
    private String mainAttribute;
    @Column(name = "magicEveryLevel")
    private Boolean magicEveryLevel;
    @Column(name = "magicEveryNewCircle")
    private Boolean magicEveryNewCircle;
    @JoinTable(name = "ArcanistPower", joinColumns = {
        @JoinColumn(name = "arcanistWayId", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "poderId", referencedColumnName = "id")})
    @ManyToMany
    private Collection<Poder> poderCollection;
    @JoinColumn(name = "sorcererLineageId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SorcererLineage sorcererLineageId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "arcanistWayId")
    private Collection<Classe> classeCollection;
}
