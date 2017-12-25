package com.example.dong.test1.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.dong.test1.utils.Const;

import butterknife.ButterKnife;

/**
 * Created by dong on 25/12/2017.
 */

public abstract class BaseActivity extends AppCompatActivity {
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        initView();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }


    protected abstract int getLayoutId();

    protected abstract void initView();

    public void showProgressDialog(String message) {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(this);
        }
        progressDialog.setCancelable(false);
        progressDialog.setMessage(message);
        progressDialog.show();
    }

    public void showProgressDialog(int messageId) {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(this);
        }
        progressDialog.setCancelable(false);
        progressDialog.setMessage(getString(messageId));
        progressDialog.show();
    }


    public void hideProgressDialog() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

    protected void makeToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    protected void makeToast(int messageId) {
        Toast.makeText(this, messageId, Toast.LENGTH_LONG).show();
    }

    public void goToActivity(Class c) {
        Intent intent = new Intent(this, c);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }

    public void goToActivity(Class c, Bundle bundle) {
        Intent intent = new Intent(this, c);
        intent.putExtra(Const.KEY_EXTRA_DATA, bundle);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }
}
