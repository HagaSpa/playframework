package controllers;

import javax.inject.Inject;

import models.CreateApiModel;
import models.TestModel;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * APIController
 */
public class ApiController extends Controller {

    @Inject
    FormFactory formFactory;

    /**
     * index
     */
    public Result index(String name) {

        Form<TestModel> form = formFactory.form(TestModel.class).bindFromRequest();

        if (form.hasErrors()) {
          return badRequest(form.errorsAsJson());
        }

        return ok("ok");
    }

    /**
     * create
     */
    public Result create() {

        Form<CreateApiModel> form = formFactory.form(CreateApiModel.class).bindFromRequest();

        if (form.hasErrors()) {
          return badRequest(form.errorsAsJson());
        }

        return ok("ok");
    }

}
