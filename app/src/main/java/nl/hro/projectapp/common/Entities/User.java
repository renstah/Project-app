package nl.hro.projectapp.common.Entities;

import java.util.Date;

/**
 * Created by Lex Goudriaan on 13-6-2015.
 */
public class User {
    public int UserID;
    public String Name;
    public String Api_Token;
    public String Social_Token;
    public int Gender;

    public User(){}

    public User(String name, String social_token, int gender) {
        this.Name = name.trim();
        this.Social_Token = social_token;
        this.Gender = gender + 1;
    }
}
