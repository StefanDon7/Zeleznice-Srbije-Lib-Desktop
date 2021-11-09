/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.stefanlezaic.zeleznice.srbije.lib.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Stefan
 */
public class EmailValidator {

    private final static String emailRegex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
    private final static Pattern emailPat=Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);

    public static boolean validate(String email) {
        Matcher matcher = emailPat.matcher(email);
        return matcher.find();
    }
}
