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
@Table(name = "Requirement")
@NamedQueries({
    @NamedQuery(name = "Requirement.findAll", query = "SELECT r FROM Requirement r"),
    @NamedQuery(name = "Requirement.findById", query = "SELECT r FROM Requirement r WHERE r.id = :id"),
    @NamedQuery(name = "Requirement.findByStrengthPoints", query = "SELECT r FROM Requirement r WHERE r.strengthPoints = :strengthPoints"),
    @NamedQuery(name = "Requirement.findByWisdomPoints", query = "SELECT r FROM Requirement r WHERE r.wisdomPoints = :wisdomPoints"),
    @NamedQuery(name = "Requirement.findByConstitutionPoints", query = "SELECT r FROM Requirement r WHERE r.constitutionPoints = :constitutionPoints"),
    @NamedQuery(name = "Requirement.findByIntelligencePoints", query = "SELECT r FROM Requirement r WHERE r.intelligencePoints = :intelligencePoints"),
    @NamedQuery(name = "Requirement.findByCharismaPoints", query = "SELECT r FROM Requirement r WHERE r.charismaPoints = :charismaPoints")})
public class Requirement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "strengthPoints")
    private Integer strengthPoints;
    @Column(name = "wisdomPoints")
    private Integer wisdomPoints;
    @Column(name = "constitutionPoints")
    private Integer constitutionPoints;
    @Column(name = "intelligencePoints")
    private Integer intelligencePoints;
    @Column(name = "charismaPoints")
    private Integer charismaPoints;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "requirementId")
    private List<Poder> poderCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "requerimentId")
    private List<Iten> itenCollection;
}
