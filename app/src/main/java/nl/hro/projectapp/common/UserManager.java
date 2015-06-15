package nl.hro.projectapp.common;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.entity.StringEntity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import nl.hro.projectapp.R;
import nl.hro.projectapp.common.Entities.User;

/**
 * Created by Lex Goudriaan on 13-6-2015.
 */
public class UserManager extends BaseManager{

    private final String USERMANAGER = "UserManager";
    private final String USER = "user";

    SharedPreferences sharedPref;

    public UserManager(Context context)
    {
        super(context);
        if (context != null) {
            this.sharedPref = context.getSharedPreferences(USERMANAGER, Context.MODE_PRIVATE);
        }
    }

    public void LoginOrSignUp(User user){

        StringEntity entity = null;
        try {
             entity = new StringEntity(gson.toJson(user));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        client.post("user/create",null, entity, new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {

                try {

                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putString(USER, response.getString(USER));
                    editor.commit();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                //TODO response verwerken naar user data
                super.onSuccess(statusCode, headers, response);
            }
            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                int a = statusCode;
                super.onFailure(statusCode, headers, throwable, errorResponse);
            }
        });
    }

    public User GetUser() {
        User user = null;
        try{
            String userString = sharedPref.getString(USER, "");
            if (!userString.equals(""))
                user = gson.fromJson(userString, User.class);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return user;
    }
}
