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

        final WebView webview = new WebView(this);
        webview.getSettings().setJavaScriptEnabled(true);

        webview.setWebViewClient(new WebViewClient() {
            @Override
            public void onReceivedError(WebView webView, int errorCode, String description, String failingUrl) {
                setContentView(R.layout.wotch_pal_error);
                setTryAgainClickListener();
            }
        });

        webview.loadUrl("http://wotchpal.com");
        setContentView(webview);
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
