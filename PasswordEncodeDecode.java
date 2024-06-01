package HelperClasses;

import java.util.Base64;

public class PasswordEncodeDecode {
    public static String getEncodedString(String password){
        return Base64.getEncoder().encodeToString(password.getBytes());
    }
    public static String getDecodeString(String encryptedPassword){
        return new String(Base64.getMimeDecoder().decode(encryptedPassword));
    }  
}
