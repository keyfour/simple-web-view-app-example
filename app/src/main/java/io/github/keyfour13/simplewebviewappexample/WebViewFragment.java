package io.github.keyfour13.simplewebviewappexample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * reated by Aleksandr Karpov <keyfour13@gmail.com> on 05.12.16.
 */

public class WebViewFragment extends Fragment {

    private final String defaultURL = "https://google.com";
    private boolean isJavaScriptEnabled = true;
    private boolean isLoadImagesAuto = true;


    //Public constructor, need to FragmentManager
    public WebViewFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        //Inflate with resource file without attachment to root
        View view = inflater.inflate(R.layout.fragment_web_view, container, false);

        WebView webView = (WebView) view.findViewById(R.id.webview);

        //We need to have client to use as browser
        webView.setWebViewClient(new MyBrowser());
        webView.getSettings().setLoadsImagesAutomatically(isJavaScriptEnabled);
        webView.getSettings().setJavaScriptEnabled(isLoadImagesAuto);

        //Load default URL
        webView.loadUrl(defaultURL);

        return view;
    }

    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }


}
