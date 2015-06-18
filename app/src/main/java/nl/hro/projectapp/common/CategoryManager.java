package nl.hro.projectapp.common;

import android.content.Context;

import com.google.gson.JsonObject;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import nl.hro.projectapp.common.Entities.Category;

/**
 * Created by Lex on 15-6-2015.
 */
public class CategoryManager extends BaseManager {

    public CategoryManager(Context context) {
        super(context);
    }

    public List<Category> GetCategories() {
        final List<Category> result = new ArrayList<>();

        client.get("/categories", null, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {

                try{
                    if (!response.getBoolean("error")) {
                        JSONArray categories = response.getJSONArray("categories");
                        for (int i = 0; i < categories.length(); i++) {
                            Category category = gson.fromJson(categories.getString(i), Category.class);
                            result.add(category);
                        }
                    }

                }catch (Exception e){
                    e.printStackTrace();
                }

                super.onSuccess(statusCode, headers, response);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
            }
        });

        return result;
    }
}
