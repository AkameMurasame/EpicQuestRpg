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
import javax.persistence.Lob;
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
@Table(name = "Poder")
@NamedQueries({
    @NamedQuery(name = "Poder.findAll", query = "SELECT p FROM Poder p"),
    @NamedQuery(name = "Poder.findById", query = "SELECT p FROM Poder p WHERE p.id = :id"),
    @NamedQuery(name = "Poder.findByName", query = "SELECT p FROM Poder p WHERE p.name = :name"),
    @NamedQuery(name = "Poder.findByCategory", query = "SELECT p FROM Poder p WHERE p.category = :category")})
public class Poder implements Serializable {

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
    @Column(name = "category")
    private String category;
    @ManyToMany(mappedBy = "poderCollection")
    private List<BardWay> bardWayCollection;
    @ManyToMany(mappedBy = "poderCollection")
    private List<ArcanistWay> arcanistWayCollection;
    @JoinTable(name = "PoderesPlayer", joinColumns = {
        @JoinColumn(name = "poderId", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "playerId", referencedColumnName = "id")})
    @ManyToMany
    private List<Player> playerCollection;
    @ManyToMany(mappedBy = "poderCollection")
    private List<BarbarianWay> barbarianWayCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "newTormentPower")
    private List<SorcererLineageBuff> sorcererLineageBuffCollection;
    @JoinColumn(name = "requirementId", referencedColumnName = "id")
    @ManyToOne(optional = true)
    private Requirement requirementId;
}
