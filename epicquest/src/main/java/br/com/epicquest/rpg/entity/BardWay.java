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

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "BardWay")
@NamedQueries({
    @NamedQuery(name = "BardWay.findAll", query = "SELECT b FROM BardWay b"),
    @NamedQuery(name = "BardWay.findById", query = "SELECT b FROM BardWay b WHERE b.id = :id"),
    @NamedQuery(name = "BardWay.findByVersatility", query = "SELECT b FROM BardWay b WHERE b.versatility = :versatility"),
    @NamedQuery(name = "BardWay.findByFullArtist", query = "SELECT b FROM BardWay b WHERE b.fullArtist = :fullArtist"),
    @NamedQuery(name = "BardWay.findByMagicCirclesAllowed", query = "SELECT b FROM BardWay b WHERE b.magicCirclesAllowed = :magicCirclesAllowed"),
    @NamedQuery(name = "BardWay.findByMagicMainAttribute", query = "SELECT b FROM BardWay b WHERE b.magicMainAttribute = :magicMainAttribute")})
public class BardWay implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "versatility")
    private Boolean versatility;
    @Column(name = "fullArtist")
    private Boolean fullArtist;
    @Column(name = "magicCirclesAllowed")
    private Integer magicCirclesAllowed;
    @Basic(optional = false)
    @Column(name = "magicMainAttribute")
    private String magicMainAttribute;
    @JoinTable(name = "BardPowers", joinColumns = {
        @JoinColumn(name = "bardWayId", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "poderId", referencedColumnName = "id")})
    @ManyToMany
    private Collection<Poder> poderCollection;
    @JoinColumn(name = "magicSchoolsAllowed", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private MagicSchool magicSchoolsAllowed;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bardWayId")
    private Collection<Classe> classeCollection;
}
