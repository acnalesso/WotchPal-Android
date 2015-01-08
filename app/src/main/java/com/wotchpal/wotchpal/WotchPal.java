package com.wotchpal.wotchpal;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;


public class WotchPal extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        setContentView(R.layout.loading);

        final WebView webview = new WebView(this);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.loadUrl("http://wotchpal.com");

        webview.setWebViewClient(new WebViewClient() {
            @Override
            public void onReceivedError(WebView webView, int errorCode, String description, String failingUrl) {
                setContentView(R.layout.error);
                WebView errorWebView = (WebView) findViewById(R.id.error);
                errorWebView.loadUrl("file:///android_asset/error.html");
                setTryAgainClickListener();
            }

            @Override
            public void onPageFinished(WebView webView, String url) {
                setContentView(webView);
            }
        });

    }

    private void setTryAgainClickListener() {
        Button tryAgain = (Button) findViewById(R.id.try_again);
        tryAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(getIntent());
            }
        });
    }

}
