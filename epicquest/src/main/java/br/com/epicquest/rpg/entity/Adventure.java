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
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Adventure")
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
    private Integer isSessionActive;
    
    @ManyToMany(mappedBy = "adventures")
    private List<User> users;
    
    @ManyToMany(mappedBy = "adventures")
    private List<Player> players;
    
    @JoinColumn(name = "mestre", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User mestre;
}
