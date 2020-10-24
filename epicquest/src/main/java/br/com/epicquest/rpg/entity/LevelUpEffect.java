package br.com.epicquest.rpg.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "levelUpEffect")
@NamedQueries({
    @NamedQuery(name = "LevelUpEffect.findAll", query = "SELECT l FROM LevelUpEffect l"),
    @NamedQuery(name = "LevelUpEffect.findById", query = "SELECT l FROM LevelUpEffect l WHERE l.id = :id")})
public class LevelUpEffect implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;    
}
