package br.edu.ifpb.agenda.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputManager {

    public static boolean validateUsername( String name){
        return name.matches("[A-z]{4,20}");
    }

    public static boolean validateName(String obj){
        String expression = "^[\\w'\\s\\-,.]+[^0-9_!¡?÷?¿/\\\\+=@#$%ˆ&*(){}|~<>;:]*$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(obj);
        return matcher.matches();
    }

    public static boolean validateCPF(String obj){
        String expression = "^([0-9]{3}.?[0-9]{3}.?[0-9]{3}-?[0-9]{2}|[0-9]{2})$";
        return obj.matches(expression);
    }

    public static boolean validateRG(String obj){
        String expression = "^([0-9].[0-9]{3}.[0-9]{3})$";
        return obj.matches(expression);
    }

    public static boolean validateDateFormat(String obj){
        String expression = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/[12][0-9]{3}$";
        return obj.matches(expression);
    }

    public static boolean validatePassword(String password){
        String expression = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{5,20}$";
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
