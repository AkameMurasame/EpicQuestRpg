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
@Table(name = "BarbarianWay")
@NamedQueries({
    @NamedQuery(name = "BarbarianWay.findAll", query = "SELECT b FROM BarbarianWay b"),
    @NamedQuery(name = "BarbarianWay.findById", query = "SELECT b FROM BarbarianWay b WHERE b.id = :id"),
    @NamedQuery(name = "BarbarianWay.findByFuryLevel", query = "SELECT b FROM BarbarianWay b WHERE b.furyLevel = :furyLevel"),
    @NamedQuery(name = "BarbarianWay.findByDamageReducer", query = "SELECT b FROM BarbarianWay b WHERE b.damageReducer = :damageReducer"),
    @NamedQuery(name = "BarbarianWay.findByWildInstinctBonus", query = "SELECT b FROM BarbarianWay b WHERE b.wildInstinctBonus = :wildInstinctBonus"),
    @NamedQuery(name = "BarbarianWay.findByTinaticFury", query = "SELECT b FROM BarbarianWay b WHERE b.tinaticFury = :tinaticFury")})
public class BarbarianWay implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "furyLevel")
    private Integer furyLevel;
    @Column(name = "damageReducer")
    private Integer damageReducer;
    @Column(name = "wildInstinctBonus")
    private Integer wildInstinctBonus;
    @Column(name = "tinaticFury")
    private Boolean tinaticFury;
    @JoinTable(name = "BarbarianPowers", joinColumns = {
        @JoinColumn(name = "barbarianWayId", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "poderId", referencedColumnName = "id")})
    @ManyToMany
    private Collection<Poder> poderCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "barbarianWayId")
    private Collection<Classe> classeCollection;
}
