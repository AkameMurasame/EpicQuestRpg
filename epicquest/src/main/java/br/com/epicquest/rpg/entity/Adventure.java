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

    public Adventure() {
    }

    public Adventure(Integer id) {
        this.id = id;
    }

    public Adventure(Integer id, String name, String photoUrl, String description) {
        this.id = id;
        this.name = name;
        this.photoUrl = photoUrl;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIsSessionActive() {
        return isSessionActive;
    }

    public void setIsSessionActive(Boolean isSessionActive) {
        this.isSessionActive = isSessionActive;
    }

    public Collection<User> getUserCollection() {
        return userCollection;
    }

    public void setUserCollection(Collection<User> userCollection) {
        this.userCollection = userCollection;
    }

    public Collection<Player> getPlayerCollection() {
        return playerCollection;
    }

    public void setPlayerCollection(Collection<Player> playerCollection) {
        this.playerCollection = playerCollection;
    }

    public User getMestre() {
        return mestre;
    }

    public void setMestre(User mestre) {
        this.mestre = mestre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Adventure)) {
            return false;
        }
        Adventure other = (Adventure) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gradleproject1.Adventure[ id=" + id + " ]";
    }
    
}
