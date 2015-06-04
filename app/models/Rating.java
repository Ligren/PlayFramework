package models;

import play.db.ebean.Model;

import javax.persistence.*;

@Entity
public class Rating extends Model {
	
    @Id
    private Integer id;
	
	@OneToOne
    public Skill skill;
		
	@ManyToOne
    public Applicant owner;

    @Column(nullable = false, length = 50)
    public String value;
	
}
