package com.nubiru.stream;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        webView = new WebView(this);
        setContentView(webView);

        WebSettings ws = webView.getSettings();
        ws.setJavaScriptEnabled(true);
        ws.setDomStorageEnabled(true);
        ws.setMediaPlaybackRequiresUserGesture(false);
        ws.setLoadWithOverviewMode(true);
        ws.setUseWideViewPort(true);

        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient());

        webView.loadUrl("https://nubiru-stream-production.up.railway.app");
    }

    @Override
    public void onBackPressed() {
        if(webView.canGoBack()){
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
