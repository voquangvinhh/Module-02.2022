package User;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Password {
    public static final String Pass = "(^([0-9A-Z]+)([a-zA-Z]+)([0-9a-zA-Z]*).{7,31}$)"; //Còn lỗi
    public static Pattern p = Pattern.compile(Pass);

}
