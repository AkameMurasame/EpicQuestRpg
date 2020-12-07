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
import javax.persistence.Lob;
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
@Table(name = "MagicSchool")
@NamedQueries({
    @NamedQuery(name = "MagicSchool.findAll", query = "SELECT m FROM MagicSchool m"),
    @NamedQuery(name = "MagicSchool.findById", query = "SELECT m FROM MagicSchool m WHERE m.id = :id"),
    @NamedQuery(name = "MagicSchool.findByName", query = "SELECT m FROM MagicSchool m WHERE m.name = :name")})
public class MagicSchool implements Serializable {

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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "magicSchoolsAllowed")
    private Collection<BardWay> bardWayCollection;
}
