package br.com.epicquest.rpg.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "Adventure")
@NamedQueries({
    @NamedQuery(name = "Adventure.findAll", query = "SELECT a FROM Adventure a"),
    @NamedQuery(name = "Adventure.findById", query = "SELECT a FROM Adventure a WHERE a.id = :id"),
    @NamedQuery(name = "Adventure.findByName", query = "SELECT a FROM Adventure a WHERE a.name = :name"),
    @NamedQuery(name = "Adventure.findByIsSessionActive", query = "SELECT a FROM Adventure a WHERE a.isSessionActive = :isSessionActive")})
public class Adventure implements Serializable {

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
    @Column(name = "photoUrl")
    private String photoUrl;
    
    @Basic(optional = false)
    @Lob
    @Column(name = "description")
    private String description;
    
    @Column(name = "isSessionActive")
    private Boolean isSessionActive;
    
    @ManyToMany(mappedBy = "adventureCollection")
    private Collection<User> userCollection;
    
    @ManyToMany(mappedBy = "adventureCollection")
    private Collection<Player> playerCollection;
    
    @JoinColumn(name = "mestre", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User mestre;
}
