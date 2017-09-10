package models;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import play.data.validation.ValidationError;

public class CreateApiModel {

    private String name;

    private String target;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public List<ValidationError> validate() {

        List<ValidationError> errors = new ArrayList<ValidationError>();

        // 半角スラッシュの個数が同じじゃないならエラー
        if (StringUtils.countMatches(getName(), "/") != StringUtils.countMatches(getTarget(), "/")) {
            errors.add(new ValidationError("name", "半角スラッシュの数が違います"));
        }


        return errors.isEmpty() ? null : errors;
    }
}
