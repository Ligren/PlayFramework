package models;

import play.db.ebean.Model;

import javax.persistence.*;

@Entity
public class Skill extends Model {

    @Id
    private Integer id;
	
	@OneToOne(mappedBy="skill")
    @Column(nullable = false, length = 50)
    public String name;
	
}
