package Customer;

import java.util.regex.Pattern;

public class Phone {
    public static final String REGEX_PHONE = "^0[9873]\\d{8}$";
    public static Pattern p = Pattern.compile(REGEX_PHONE);
}
