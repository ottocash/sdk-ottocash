package com.otto.sdk.ui.activities.tac;

import android.os.Bundle;
import android.webkit.WebView;

import com.otto.sdk.R;

import app.beelabs.com.codebase.base.BaseActivity;

public class TACOttoCashActivity extends BaseActivity {


    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tac_ottocash);
        initView();
        displayTAC();
    }

    private void initView() {
        webView = findViewById(R.id.web_view);
    }

    private void displayTAC() {
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://ottocash.id/terms_and_condition");
    }
}