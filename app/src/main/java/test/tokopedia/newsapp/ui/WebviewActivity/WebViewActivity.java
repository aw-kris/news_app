package test.tokopedia.newsapp.ui.WebviewActivity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import test.tokopedia.newsapp.R;

/**
 * Created by Kharisma AW on 8/15/2018.
 */
public class WebViewActivity extends AppCompatActivity{
    @BindView(R.id.webview)
    WebView mWebView;

    private String url;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        ButterKnife.bind(this);
        url = getIntent().getExtras().getString("url");

        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
//                mWebView.loadUrl("javascript:(function() { " +
//                        "var head = document.getElementById('header').style.display='none'; " +
//                        "})()");
            }
        });
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setDomStorageEnabled(true);
        mWebView.setOverScrollMode(WebView.OVER_SCROLL_NEVER);
        mWebView.loadUrl(url);
    }
}
