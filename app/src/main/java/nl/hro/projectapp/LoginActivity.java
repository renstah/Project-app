package nl.hro.projectapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findViewById(R.id.sign_in_button).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                SignIn();
            }
        });
    }

    @Override
    public void onConnected(Bundle bundle) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        this.finish();
    }
}