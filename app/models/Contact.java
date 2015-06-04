package models;

import play.db.ebean.Model;

import javax.persistence.*;
import javax.persistence.Embeddable;

import java.util.*;

import play.data.format.*;
import play.data.validation.*;
import play.db.ebean.Model.Finder;

@Entity
public class Contact extends Model {

    @Id
    @Column(name  = "ID_CONTACT", nullable = false, length = 4)
    public Integer id;
	
	@ManyToOne
    public TypeContact typeContact;
	
	@ManyToOne
    public Applicant owner;

    public String value;
	
	public static Finder<Integer,Contact> find = new Finder(Integer.class, Contact.class);
	
/*Error with the Join on [models.Contact.owner]. Could not find the local match for [null]  Perhaps an error in a @JoinColumn
Ошибка с присоединением к models.Contact.owner. Не могу найте локальное совпадение для null. Возможно ошибка в @JoinColumn	

Can not find Master [class models.Applicant] in Child[models.Contact]
не можем найти мастер класс models.Applicant в ребенке models.Contact

fetch - получать
join - присоеденится
match - совпадение
Perhaps - возможно
owner - владелец
exist - существовать
compose - составить
particular - частности (особенности)
manages - управляет
retrieve - извлекат
entity - объект, сущность, организация
explicity - в явной
customize - настроить
underlying - лежащий в основе
either - либо
fairly - довольно
reducing - сокращение
sequence - последовательность
batch - партия
gaps - пробелы
attempt - попытка
however - однако
enhance - повышать
persist - сохраняется

all about jpa (on Russian)
http://alextretyakov.blogspot.com/2013/06/jpa-mapping-tipa-odin-ko-mnogim-i.html

superclass for model
https://gist.github.com/anonymous/3410579	
	*/
}
