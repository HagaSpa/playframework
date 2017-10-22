package validators;

import org.apache.commons.lang3.StringUtils;

public class NameValidator {
    
    private static final Integer MAX_LENGTH = 64;

    /**
     * nameのチェックを行う
     *
     * @param name 
     * @return boolean
     * */
    public static boolean checkFileName(String fileName) {
      // null or "" or 64より大きい場合 or ASCⅱ制御文字を含む or \/:*?"<>|を含む
      if (StringUtils.isBlank(fileName)
              || fileName.length() > MAX_LENGTH
              || fileName.matches("^.*[¥x00-¥x1F¥x7F].*")
              || fileName.matches("^.*[\\/:*?\"<>|].*")) {
        return false;
      }
      return true;    
    }
    
}
