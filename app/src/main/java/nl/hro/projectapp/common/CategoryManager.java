package nl.hro.projectapp.common;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.apache.http.Header;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import nl.hro.projectapp.common.Entities.Category;

/**
 * Created by Lex on 15-6-2015.
 */
public class CategoryManager {

    public List<Category> GetCategories() {
        List<Category> result = new ArrayList<>();

        SpeetRestClient.get("/categories", null, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {

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
