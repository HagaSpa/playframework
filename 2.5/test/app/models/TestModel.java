package models;

import java.util.ArrayList;
import java.util.List;

import play.Configuration;
import play.api.Play;
import play.data.validation.ValidationError;

public class TestModel {

    // confファイルを読み込む？
    private  Configuration configuration = Play.current().injector().instanceOf(Configuration .class);

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ValidationError> validate() {

        List<ValidationError> errors = new ArrayList<ValidationError>();

        long validLength = configuration.getLong("valid.name");

        if(validLength < getName().length()) {
            errors.add(new ValidationError("name", "5文字以下で入力してください"));
        }

        return errors.isEmpty() ? null : errors;
    }
}
