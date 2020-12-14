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
@Table(name = "Iten")
@NamedQueries({
    @NamedQuery(name = "Iten.findAll", query = "SELECT i FROM Iten i"),
    @NamedQuery(name = "Iten.findById", query = "SELECT i FROM Iten i WHERE i.id = :id"),
    @NamedQuery(name = "Iten.findByName", query = "SELECT i FROM Iten i WHERE i.name = :name"),
    @NamedQuery(name = "Iten.findByDescription", query = "SELECT i FROM Iten i WHERE i.description = :description"),
    @NamedQuery(name = "Iten.findByValue", query = "SELECT i FROM Iten i WHERE i.value = :value"),
    @NamedQuery(name = "Iten.findByDamegeDice", query = "SELECT i FROM Iten i WHERE i.damegeDice = :damegeDice"),
    @NamedQuery(name = "Iten.findByAdditionalDamagePoints", query = "SELECT i FROM Iten i WHERE i.additionalDamagePoints = :additionalDamagePoints"),
    @NamedQuery(name = "Iten.findByPenaltyDice", query = "SELECT i FROM Iten i WHERE i.penaltyDice = :penaltyDice"),
    @NamedQuery(name = "Iten.findByPenaltyPoints", query = "SELECT i FROM Iten i WHERE i.penaltyPoints = :penaltyPoints"),
    @NamedQuery(name = "Iten.findByCaPoints", query = "SELECT i FROM Iten i WHERE i.caPoints = :caPoints"),
    @NamedQuery(name = "Iten.findByConsumable", query = "SELECT i FROM Iten i WHERE i.consumable = :consumable"),
    @NamedQuery(name = "Iten.findByConsumableEffectDiceAdditional", query = "SELECT i FROM Iten i WHERE i.consumableEffectDiceAdditional = :consumableEffectDiceAdditional"),
    @NamedQuery(name = "Iten.findByConsumableEffectDiceDuration", query = "SELECT i FROM Iten i WHERE i.consumableEffectDiceDuration = :consumableEffectDiceDuration"),
    @NamedQuery(name = "Iten.findByLifePointsEffect", query = "SELECT i FROM Iten i WHERE i.lifePointsEffect = :lifePointsEffect"),
    @NamedQuery(name = "Iten.findByManaPointsEffect", query = "SELECT i FROM Iten i WHERE i.manaPointsEffect = :manaPointsEffect"),
    @NamedQuery(name = "Iten.findByStrenghPointsEffect", query = "SELECT i FROM Iten i WHERE i.strenghPointsEffect = :strenghPointsEffect"),
    @NamedQuery(name = "Iten.findByWisdomPointsEffect", query = "SELECT i FROM Iten i WHERE i.wisdomPointsEffect = :wisdomPointsEffect"),
    @NamedQuery(name = "Iten.findByDexterityPointsEffect", query = "SELECT i FROM Iten i WHERE i.dexterityPointsEffect = :dexterityPointsEffect"),
    @NamedQuery(name = "Iten.findByConstitutionPointsEffect", query = "SELECT i FROM Iten i WHERE i.constitutionPointsEffect = :constitutionPointsEffect"),
    @NamedQuery(name = "Iten.findByIntelligencePointsEffect", query = "SELECT i FROM Iten i WHERE i.intelligencePointsEffect = :intelligencePointsEffect"),
    @NamedQuery(name = "Iten.findByCharismaPointsEffect", query = "SELECT i FROM Iten i WHERE i.charismaPointsEffect = :charismaPointsEffect"),
    @NamedQuery(name = "Iten.findByPericiaValueModifier", query = "SELECT i FROM Iten i WHERE i.periciaValueModifier = :periciaValueModifier")})
public class Iten implements Serializable {

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
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "value")
    private int value;
    @Column(name = "damegeDice")
    private String damegeDice;
    @Column(name = "additionalDamagePoints")
    private Integer additionalDamagePoints;
    @Column(name = "penaltyDice")
    private String penaltyDice;
    @Column(name = "penaltyPoints")
    private Integer penaltyPoints;
    @Column(name = "caPoints")
    private Integer caPoints;
    @Basic(optional = false)
    @Column(name = "consumable")
    private boolean consumable;
    @Column(name = "consumableEffectDiceAdditional")
    private Integer consumableEffectDiceAdditional;
    @Column(name = "consumableEffectDiceDuration")
    private Integer consumableEffectDiceDuration;
    @Column(name = "lifePointsEffect")
    private Integer lifePointsEffect;
    @Column(name = "manaPointsEffect")
    private Integer manaPointsEffect;
    @Column(name = "strenghPointsEffect")
    private Integer strenghPointsEffect;
    @Column(name = "wisdomPointsEffect")
    private Integer wisdomPointsEffect;
    @Column(name = "dexterityPointsEffect")
    private Integer dexterityPointsEffect;
    @Column(name = "constitutionPointsEffect")
    private Integer constitutionPointsEffect;
    @Column(name = "intelligencePointsEffect")
    private Integer intelligencePointsEffect;
    @Column(name = "charismaPointsEffect")
    private Integer charismaPointsEffect;
    @Column(name = "periciaValueModifier")
    private Integer periciaValueModifier;
    /*@JoinTable(name = "ItensPlayer", joinColumns = {
        @JoinColumn(name = "itenId", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "playerId", referencedColumnName = "id")})
    @ManyToMany
    private List<Player> playerCollection;*/
    @JoinColumn(name = "requerimentId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Requirement requerimentId;
}
