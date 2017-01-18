package ru.geekbrains.lesson5.solarsystem;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

public class WebActivity extends AppCompatActivity {

    static final String WEB_LINK = "WEB_LINK";

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        final ProgressBar mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        mProgressBar.setProgress(0);
        WebView mWebView = (WebView) findViewById(R.id.webview);
        mWebView.setWebViewClient(new WebViewClient());
        WebSettings wSettings = mWebView.getSettings();
        wSettings.setJavaScriptEnabled(true);
        String url = this.getIntent().getStringExtra(WEB_LINK);
        mWebView.loadUrl(url);
        final ViewGroup.LayoutParams params = mProgressBar.getLayoutParams();
        mWebView.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView wv, int progress) {
                mProgressBar.setLayoutParams(new RelativeLayout.LayoutParams(params.width, params.height));
                mProgressBar.setVisibility(ProgressBar.VISIBLE);
                if (progress < 100 && progress > 0) {
                    mProgressBar.setProgress(progress);
                }
                else if (progress == 100) {
                    mProgressBar.setVisibility(ProgressBar.INVISIBLE);
                    mProgressBar.setLayoutParams(new RelativeLayout.LayoutParams(0, 0));
                }
            }
        });
    }
}
