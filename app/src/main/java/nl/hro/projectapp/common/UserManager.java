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
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import nl.hro.projectapp.common.Entities.User;

/**
 * Created by Lex Goudriaan on 13-6-2015.
 */
public class UserManager {

    Gson gson;
    public UserManager()
    {
        this.gson = new Gson();
    }

    public void LoginOrSignUp(User user){

        StringEntity entity = null;
        try {
             entity = new StringEntity(gson.toJson(user));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        SpeetRestClient.post("user/create",null, entity, new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
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
}
