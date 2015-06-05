/*
json https://www.youtube.com/watch?v=zzaZj3wmGe4
json table https://www.youtube.com/watch?v=BbEFv-psVW8
tutorial https://www.youtube.com/watch?v=kXImTUlHwAo
https://www.youtube.com/watch?v=8AOEMe7_W-k
 */

package controllers;

import models.Applicant;
import models.Category;
import models.Job;
import org.elasticsearch.client.Client;
import org.elasticsearch.node.Node;
import play.data.Form;
import play.db.ebean.Model;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.finish;
import views.html.index;
import views.html.show;

import static org.elasticsearch.node.NodeBuilder.*;

import java.util.List;

import static play.libs.Json.stringify;
import static play.libs.Json.toJson;
import play.data.Form;
import play.mvc.*;

import views.html.*;

import models.*;

public class Application extends Controller {

    public static Result add(Long categoryId) {
        Form<Job> filledForm = Form.form(Job.class).bindFromRequest();
        if (filledForm.hasErrors()) {
            Category category = Category.find.byId(categoryId);
            return badRequest(show.render(category, filledForm));
        }
        Job job = filledForm.get();
        job.category = Category.find.ref(categoryId);
        job.save();
        return redirect(routes.Application.show(categoryId));
    }

    public static Result show1(Long id) { return TODO; }


    public static Result addJob() {
        Form<Category> filledForm = Form.form(Category.class).bindFromRequest();
        if (filledForm.hasErrors()) {
            System.out.println("Category has error !");
            System.out.println("====================");
        } else { 
        Category category = filledForm.get();
        category.save();
		}
        return redirect(routes.Application.index());
    }

    public static Result show(Long id) { return ok(show.render(Category.find.byId(id), Form.form(Job.class))); }

    public static Result index() { return ok(index.render(Category.all(), Form.form(Category.class))); }

    public static Result indexRWR() {
//-----------------------elasticsearch
        // on startup
        Node node = nodeBuilder().node();
        Client client = node.client();
		// run code here
        // on shutdown
        node.close();
//-----------------------END elasticsearch		
        System.out.println("-----------------------------------------------------we are in the indexRWR");
//        return ok(indexRWR.render(Applicant.all(), "Hello World !!!", Form.form(Applicant.class)));
        return ok(indexRWR.render(Applicant.all(), TypeContact.all(), Skill.all(), Form.form(Applicant.class)));
    }

	public static Result finish() {
        System.out.println("-----------------------------------------------------we are in finish controller");
//        List<Applicant> applicants = new Model.Finder(Integer.class, Applicant.class).all();
//        return ok(finish.render("Люси"));
//        com.fasterxml.jackson.databind.JsonNode l = toJson(applicants);
//        String k = fromJson(l, java.lang.String);
        return ok(indexRWR.render(Applicant.all(), TypeContact.all(), Skill.all(), Form.form(Applicant.class)));
//        return ok(finish.render(stringify(toJson(applicants))));
    }


    public static Result addApplicant() {
//        Form<Category> filledForm = Form.form(Category.class).bindFromRequest();
//        Category category = filledForm.get();
//        category.save();
        Form<Applicant> filledForm = Form.form(Applicant.class).bindFromRequest();
        if (filledForm.hasErrors()) {
            System.out.println("Applicant has errors !!!");
            System.out.println("*************************");
        } else {
            Applicant applicant = filledForm.get();
            applicant.save();
        }
        return finish();
    }

    public static Result addTypeContact() {
        Form<TypeContact> filledForm = Form.form(TypeContact.class).bindFromRequest();
        if (filledForm.hasErrors()) {
            System.out.println("Type contact has errors !!!");
            System.out.println("***************************");
        } else {
            TypeContact typeContact = filledForm.get();
            typeContact.save();
        }
        return finish();
    }

    public static Result addSkill() {
        Form<Skill> filledForm = Form.form(Skill.class).bindFromRequest();
        if (filledForm.hasErrors()) {
            System.out.println("Skill has errors !!!");
            System.out.println("***************************");
        } else {
            Skill skill = filledForm.get();
            skill.save();
        }
        return finish();
    }

    public static Result getApplicants() {
        List<Applicant> applicants = new Model.Finder(Integer.class, Applicant.class).all();
        System.out.println("Applicants = " + applicants);
        return ok(toJson(applicants));
    }

/*
https://ebean-orm.github.io/apidocs/com/avaje/ebean/Query.html#findPagedList-int-int-
https://www.playframework.com/documentation/2.4.0/JavaEbean
 */
//        return redirect("/example");

//        return seeOther("/example");
        /*
        return redirect("http://stackoverflow.com/questions/10962694");
It's also worth to use other availabe redirects such as

seeOther(String url)
movedPermanently(String url)
temporaryRedirect(String url)
         */
//        return ok("example");


//    public Result index() {
//        return redirect("/user/home");
//    }
/*----------------------------Transaction manager

https://www.playframework.com/documentation/2.4.x/JavaEbean
http://alextretyakov.blogspot.com/2013/06/osnovy-jpa-i-hibernate.html

// Created implicit transaction
Task task = Task.find.byId(34L);
// Transaction committed or rolled back

task.done = true;

// Created implicit transaction
task.save();
// Transaction committed or rolled back

----------------------------END Transaction manager
*/


/*  Redirect to /hello/Bob
    public Result index() {

    Result htmlResult = ok("<h1>Hello World!</h1>").as("text/html");

    response().setContentType("text/html");
    response().setHeader(CACHE_CONTROL, "max-age=3600");

    response().setCookie(
        "theme",        // name
        "blue",         // value
        3600,           // maximum age
        "/some/path",   // path
        ".example.com", // domain
        false,          // secure
        true            // http only
);
//To discard a Cookie previously stored on the web browser:

        response().discardCookie("theme");

        response().setContentType("text/html; charset=iso-8859-1");

    return redirect(controllers.routes.Application.hello("Bob"));
    }

--------------------------------------- Session
    public Result login() {
       session("connected", "user@gmail.com");
        return ok("Welcome!");
    }
The same way, you can remove any value from the incoming session:

public Result logout() {
    session().remove("connected");
    return ok("Bye");
}
    public Result index() {
    String user = session("connected");
    if(user != null) {
        return ok("Hello " + user);
    } else {
        return unauthorized("Oops, you are not connected");
    }
}

public Result logout() {
    session().clear();
    return ok("Bye");
}

public Result save() {
    flash("success", "The item has been created");
    return redirect("/home");
}
----- flash scope, and if so, render it:

public Result index() {
    String message = flash("success");
    if(message == null) {
        message = "Welcome!";
    }
    return ok(message);
}
A flash value is also automatically available in Twirl templates. For example:

@if(flash.containsKey("success")) {
  @flash.get("success")
} else {
  Welcome!
}
--------------------------------------- End Session
--------------------------------------- End Session


    */

}
