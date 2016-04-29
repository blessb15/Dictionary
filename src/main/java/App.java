import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import java.util.ArrayList;
import static spark.Spark.*;

public class App {

  public static void main (String[] args){
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();

      model.put("definitions", request.session().attribute("definitions"));
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/words/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/word-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/words", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("words", Words.all());
      model.put("template", "templates/words.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/words", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String name = request.queryParams("name");
      Words newWord = new Words(name);
      model.put("template", "templates/words-success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/words/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Words words = Words.find(Integer.parseInt(request.params(":id")));
      model.put("words", words);
      model.put("template", "templates/word.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("words/:id/definitions/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Words words = Words.find(Integer.parseInt(request.params(":id")));
      model.put("words", words);
      model.put("template", "templates/words-def-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/definitions", (request, response) -> {
     HashMap<String, Object> model = new HashMap<String, Object>();
     Words words =
     Words.find(Integer.parseInt(request.queryParams("wordsId")));
     String description = request.queryParams("description");
     Definitions newDef = new Definitions(description);
     words.addDefinition(newDef);
     model.put("words", words);
     model.put("template", "templates/words-def-success.vtl");
     return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());
  }
}
