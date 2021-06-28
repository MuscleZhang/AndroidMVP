package com.zjj.androidmvp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.zjj.androidmvp.R;
import com.zjj.androidmvp.presenter.LoginPresenter;

public class MainActivity extends AppCompatActivity implements ILoginView, View.OnClickListener{

    Button get;
    Button set;
    TextView text;
    String mName;
    int count = 0;
    LoginPresenter presenter;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new LoginPresenter(this);
        get = findViewById(R.id.get);
        set = findViewById(R.id.set);
        text = findViewById(R.id.text);
        get.setOnClickListener(this);
        set.setOnClickListener(this);

    }

    @Override
    public String getName() {
        return mName;
    }

    @Override
    public void showTips() {
        Toast.makeText(this, mName + " Toast", Toast.LENGTH_LONG).show();

    }

    @Override
    public void onClick(View v) {
        Log.d("zjjtag", "onclick");
        if(v == get) {
            Log.d("zjjtag", "onclick get");
            presenter.login();
        } else if (v == set) {
            Log.d("zjjtag", "onclick set count:" + count);
            count++;
            if(count % 2 == 0) {
                mName = "zjj";
            } else {
                mName = "hehe";
            }
            text.setText(mName);
        }
    }
}