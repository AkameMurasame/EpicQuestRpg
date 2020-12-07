package br.com.epicquest.rpg.game.websocket.entity;

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
@Table(name = "SorcererLineageBuff")
@NamedQueries({
    @NamedQuery(name = "SorcererLineageBuff.findAll", query = "SELECT s FROM SorcererLineageBuff s"),
    @NamedQuery(name = "SorcererLineageBuff.findById", query = "SELECT s FROM SorcererLineageBuff s WHERE s.id = :id"),
    @NamedQuery(name = "SorcererLineageBuff.findByMagicType", query = "SELECT s FROM SorcererLineageBuff s WHERE s.magicType = :magicType"),
    @NamedQuery(name = "SorcererLineageBuff.findByDamageReduction", query = "SELECT s FROM SorcererLineageBuff s WHERE s.damageReduction = :damageReduction"),
    @NamedQuery(name = "SorcererLineageBuff.findByExtraLifePoints", query = "SELECT s FROM SorcererLineageBuff s WHERE s.extraLifePoints = :extraLifePoints"),
    @NamedQuery(name = "SorcererLineageBuff.findByDamageTypeManaCostReducer", query = "SELECT s FROM SorcererLineageBuff s WHERE s.damageTypeManaCostReducer = :damageTypeManaCostReducer"),
    @NamedQuery(name = "SorcererLineageBuff.findByDamageTypeExtraDamage", query = "SELECT s FROM SorcererLineageBuff s WHERE s.damageTypeExtraDamage = :damageTypeExtraDamage"),
    @NamedQuery(name = "SorcererLineageBuff.findByTemporaryManaPointsOnKill", query = "SELECT s FROM SorcererLineageBuff s WHERE s.temporaryManaPointsOnKill = :temporaryManaPointsOnKill"),
    @NamedQuery(name = "SorcererLineageBuff.findByEnhancementOrIlusionMagic", query = "SELECT s FROM SorcererLineageBuff s WHERE s.enhancementOrIlusionMagic = :enhancementOrIlusionMagic"),
    @NamedQuery(name = "SorcererLineageBuff.findByEnhancementOrIlusionMagicCD", query = "SELECT s FROM SorcererLineageBuff s WHERE s.enhancementOrIlusionMagicCD = :enhancementOrIlusionMagicCD"),
    @NamedQuery(name = "SorcererLineageBuff.findByEnhancementOrIlusionMagicManaCostReducer", query = "SELECT s FROM SorcererLineageBuff s WHERE s.enhancementOrIlusionMagicManaCostReducer = :enhancementOrIlusionMagicManaCostReducer"),
    @NamedQuery(name = "SorcererLineageBuff.findByExtraCharisma", query = "SELECT s FROM SorcererLineageBuff s WHERE s.extraCharisma = :extraCharisma"),
    @NamedQuery(name = "SorcererLineageBuff.findByResistPenalty", query = "SELECT s FROM SorcererLineageBuff s WHERE s.resistPenalty = :resistPenalty"),
    @NamedQuery(name = "SorcererLineageBuff.findByNewMagicForEveryTormentaPower", query = "SELECT s FROM SorcererLineageBuff s WHERE s.newMagicForEveryTormentaPower = :newMagicForEveryTormentaPower"),
    @NamedQuery(name = "SorcererLineageBuff.findByExtraManaPointsForEveryTormentaPower", query = "SELECT s FROM SorcererLineageBuff s WHERE s.extraManaPointsForEveryTormentaPower = :extraManaPointsForEveryTormentaPower")})
public class SorcererLineageBuff implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "magicType")
    private String magicType;
    @Column(name = "damageReduction")
    private Integer damageReduction;
    @Column(name = "extraLifePoints")
    private Integer extraLifePoints;
    @Column(name = "damageTypeManaCostReducer")
    private Integer damageTypeManaCostReducer;
    @Column(name = "damageTypeExtraDamage")
    private Integer damageTypeExtraDamage;
    @Column(name = "temporaryManaPointsOnKill")
    private Boolean temporaryManaPointsOnKill;
    @Column(name = "enhancementOrIlusionMagic")
    private Boolean enhancementOrIlusionMagic;
    @Column(name = "enhancementOrIlusionMagicCD")
    private Integer enhancementOrIlusionMagicCD;
    @Column(name = "enhancementOrIlusionMagicManaCostReducer")
    private Integer enhancementOrIlusionMagicManaCostReducer;
    @Column(name = "extraCharisma")
    private Integer extraCharisma;
    @Column(name = "resistPenalty")
    private Boolean resistPenalty;
    @Column(name = "newMagicForEveryTormentaPower")
    private Boolean newMagicForEveryTormentaPower;
    @Column(name = "extraManaPointsForEveryTormentaPower")
    private Boolean extraManaPointsForEveryTormentaPower;
    @JoinColumn(name = "periciaTrained", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Pericia periciaTrained;
    @JoinColumn(name = "newTormentPower", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Poder newTormentPower;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "basicBuffId")
    private List<SorcererLineage> sorcererLineageCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "advancedBuffId")
    private List<SorcererLineage> sorcererLineageCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aprimoredBuffId")
    private List<SorcererLineage> sorcererLineageCollection2;
}
