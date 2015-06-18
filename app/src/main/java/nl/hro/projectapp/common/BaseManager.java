package nl.hro.projectapp.common;

import android.content.Context;

import com.google.gson.Gson;

/**
 * Created by Lex Goudriaan on 15-6-2015.
 */
public abstract class BaseManager {

    public Context context;
    public SpeetRestClient client;
    public Gson gson;

    public BaseManager(Context context) {
        this.context = context;
        this.client = new SpeetRestClient(context);
        this.gson = new Gson();
    }

}
