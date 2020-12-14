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
@Table(name = "Race")
@NamedQueries({
    @NamedQuery(name = "Race.findAll", query = "SELECT r FROM Race r"),
    @NamedQuery(name = "Race.findById", query = "SELECT r FROM Race r WHERE r.id = :id"),
    @NamedQuery(name = "Race.findByName", query = "SELECT r FROM Race r WHERE r.name = :name"),
    @NamedQuery(name = "Race.findByStrengthPoints", query = "SELECT r FROM Race r WHERE r.strengthPoints = :strengthPoints"),
    @NamedQuery(name = "Race.findByWisdomPoints", query = "SELECT r FROM Race r WHERE r.wisdomPoints = :wisdomPoints"),
    @NamedQuery(name = "Race.findByDexterityPoints", query = "SELECT r FROM Race r WHERE r.dexterityPoints = :dexterityPoints"),
    @NamedQuery(name = "Race.findByConstitutionPoints", query = "SELECT r FROM Race r WHERE r.constitutionPoints = :constitutionPoints"),
    @NamedQuery(name = "Race.findByIntelligencePoints", query = "SELECT r FROM Race r WHERE r.intelligencePoints = :intelligencePoints"),
    @NamedQuery(name = "Race.findByCharismaPoints", query = "SELECT r FROM Race r WHERE r.charismaPoints = :charismaPoints"),
    @NamedQuery(name = "Race.findByFreePoints", query = "SELECT r FROM Race r WHERE r.freePoints = :freePoints")})
public class Race implements Serializable {

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
    @Column(name = "strengthPoints")
    private int strengthPoints;
    @Basic(optional = false)
    @Column(name = "wisdomPoints")
    private int wisdomPoints;
    @Basic(optional = false)
    @Column(name = "dexterityPoints")
    private int dexterityPoints;
    @Basic(optional = false)
    @Column(name = "constitutionPoints")
    private int constitutionPoints;
    @Basic(optional = false)
    @Column(name = "intelligencePoints")
    private int intelligencePoints;
    @Basic(optional = false)
    @Column(name = "charismaPoints")
    private int charismaPoints;
    @Basic(optional = false)
    @Column(name = "freePoints")
    private int freePoints;
    @ManyToMany(mappedBy = "raceCollection")
    private List<Pericia> periciaCollection;
    @ManyToMany(mappedBy = "raceCollection")
    private List<Deus> deusCollection;
    /*
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "raceId")
    private List<Player> playerCollection;*/
}
