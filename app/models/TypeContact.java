package models;

import java.util.List;
import play.db.ebean.Model;

import javax.persistence.*;

@Entity
public class TypeContact extends Model {

    @Id
    public Integer id;
	
    public String name;
	
	@OneToMany(mappedBy="typeContact")
	public List<Contact> contacts;
	 
	public static Finder<Integer, TypeContact> find = new Finder (Integer.class, TypeContact.class);

    public static List<TypeContact> all() { return find.all(); }

}
