package models;

import play.data.validation.Constraints;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

import play.data.format.*;
import play.data.validation.*;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * http://stackoverflow.com/questions/5127129/mapping-many-to-many-association-table-with-extra-columns
 http://en.wikibooks.org/wiki/Java_Persistence/ManyToMany
 https://giannigar.wordpress.com/2009/09/04/mapping-a-many-to-many-join-table-with-extra-column-using-jpa/
 */
@Entity
@Table(name = "APPLICANTS")
public class Applicant extends Model {

    @Id
    public Integer id;
	
	@Version
	public java.sql.Timestamp dateAddition;
  
	@Formats.DateTime(pattern="dd/MM/yyyy")
    public Date dateInterview;
  
  	@OneToMany(mappedBy= "owner")
	public List<Contact> contacts;
	
  	@OneToMany(mappedBy= "owner")
	public List<Rating> ratings;

    public static Finder<Integer, Applicant> find = new Finder (Integer.class, Applicant.class);

    public static List<Applicant> all() { return find.all(); }
/*
// Find all tasks
List<Task> tasks = Task.find.all();

// Find a task by ID
Task anyTask = Task.find.byId(34L);

// Delete a task by ID
Task.find.ref(34L).delete();

// More complex task query
List<Task> cocoTasks = Task.find.where()
        .ilike("name", "%coco%")
        .orderBy("dueDate asc")
        .findPagedList(1, 25)
        .getList();
		
---------------------------------------------		
		
	*/

}