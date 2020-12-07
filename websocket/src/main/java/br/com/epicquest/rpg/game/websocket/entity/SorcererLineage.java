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
@Table(name = "SorcererLineage")
@NamedQueries({
    @NamedQuery(name = "SorcererLineage.findAll", query = "SELECT s FROM SorcererLineage s"),
    @NamedQuery(name = "SorcererLineage.findById", query = "SELECT s FROM SorcererLineage s WHERE s.id = :id"),
    @NamedQuery(name = "SorcererLineage.findByName", query = "SELECT s FROM SorcererLineage s WHERE s.name = :name")})
public class SorcererLineage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @JoinColumn(name = "basicBuffId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SorcererLineageBuff basicBuffId;
    @JoinColumn(name = "advancedBuffId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SorcererLineageBuff advancedBuffId;
    @JoinColumn(name = "aprimoredBuffId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SorcererLineageBuff aprimoredBuffId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sorcererLineageId")
    private List<ArcanistWay> arcanistWayCollection;    
}
