package controllers;

import play.mvc.Controller;
import play.mvc.Result;

/**
 * APIController
 */
public class ApiController extends Controller {

    /**
     * index
     */
    public Result index() {

        return ok("ok");
    }

}
