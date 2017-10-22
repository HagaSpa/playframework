package models;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import play.data.validation.Constraints.Pattern;
import play.data.validation.ValidationError;
import validators.NameValidator;

public class CreateApiModel {

    private String name;

    // 文字列の先頭と、末尾は「/」以外
    @Pattern(value = "^[^/].*[^/]$")
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
        
        // フォーマットチェック
        if (!NameValidator.checkFileName(getName())) {
            errors.add(new ValidationError("name", "フォーマットが違います"));
        }

        // 半角スラッシュの個数が同じじゃないならエラー
        if (StringUtils.countMatches(getName(), "/") != StringUtils.countMatches(getTarget(), "/")) {
            errors.add(new ValidationError("name", "半角スラッシュの数が違います"));
        }

        return errors.isEmpty() ? null : errors;
    }
}
