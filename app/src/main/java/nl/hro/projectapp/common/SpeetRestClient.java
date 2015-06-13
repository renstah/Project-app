package nl.hro.projectapp.common;

import android.content.Context;
import com.loopj.android.http.*;

import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.message.BasicHeader;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Lex Goudriaan on 13-6-2015.
 */
public class SpeetRestClient {

    static Context _context;

    public SpeetRestClient(Context context)
    {
        this._context = context;
    }

    //private static final String BASE_URL = "http://speet.hol.es/";
    private static final String BASE_URL = "http://192.168.0.109/";

    private static AsyncHttpClient client = new AsyncHttpClient();

    public static void get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.get(_context, getAbsoluteUrl(url),getHeaders(), params, responseHandler);
    }

    public static void post(String url, RequestParams params, HttpEntity entity, AsyncHttpResponseHandler responseHandler) {
        client.post(_context, getAbsoluteUrl(url), getHeaders(), entity, "application/json", responseHandler);
    }

    private static String getAbsoluteUrl(String relativeUrl) {
        return BASE_URL + relativeUrl;
    }

    private static Header[] getHeaders(){
        ArrayList<org.apache.http.Header> headers = new ArrayList<>();

        //TODO headers toevoegen als ze beschikbaar zijn. deze worden teruggegeven in de response van de login
        headers.add(new BasicHeader("X-API-TOKEN",""));
        headers.add(new BasicHeader("X-API-CLIENT-ID",""));

        return (Header[]) headers.toArray();
    }
}
