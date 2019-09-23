package com.example.joorezende;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {
    private WebView mywebView;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && mywebView.canGoBack()) {
            mywebView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mywebView = (WebView) findViewById(R.id.webview);


        WebViewClientImpl webViewClient = new WebViewClientImpl(this);
        mywebView.setWebViewClient(webViewClient);

        mywebView.loadUrl("https://www.joaorezende.com.br/");

        //Habilitando o JavaScript
        WebSettings webSettings = mywebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }
}
