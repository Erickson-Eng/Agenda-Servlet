package br.edu.ifpb.agenda.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputManager {

    public static boolean validateUsername( String name){
        return name.matches("[a-z]{4,20}");
    }

    public static boolean validatePassword(String password){
        String expression = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public static boolean validateEmail(String email){
        String expression = "^[\\w._]+@([\\w-]+\\.)+[a-z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
