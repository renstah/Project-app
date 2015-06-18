package nl.hro.projectapp.common;

import android.content.Context;
import com.loopj.android.http.*;

import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.message.BasicHeader;

import java.lang.reflect.Array;
import java.util.ArrayList;

import nl.hro.projectapp.common.Entities.User;

/**
 * Created by Lex Goudriaan on 13-6-2015.
 */
public class SpeetRestClient {

    static Context _context;

    public SpeetRestClient(Context context)
    {
        this._context = context;
    }

    private final String BASE_URL = "http://speet.hol.es/";
    //private static final String BASE_URL = "http://192.168.0.109/";

    private AsyncHttpClient client = new AsyncHttpClient();

    public void get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.get(_context, getAbsoluteUrl(url),getHeaders(), params, responseHandler);
    }

    public void post(String url, RequestParams params, HttpEntity entity, AsyncHttpResponseHandler responseHandler) {
        client.post(_context, getAbsoluteUrl(url), getHeaders(), entity, "application/json", responseHandler);
    }

    private String getAbsoluteUrl(String relativeUrl) {
        return BASE_URL + relativeUrl;
    }

    private Header[] getHeaders(){

        User user = new UserManager(_context).GetUser();

        if (user != null) {
            Header[] headers = {
                    new BasicHeader("X-API-TOKEN", user.Api_Token),
                    new BasicHeader("X-API-CLIENT-ID", user.UserID + "")
            };
            return headers;
        }else{
            return null;
        }
    }
}
