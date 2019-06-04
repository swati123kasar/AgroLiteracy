package com.example.neha.agroliteracy;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MessageFragment extends Fragment {

    @Nullable
    private WebView webView;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        webView= webView.findViewById(R.id.mw);
       //WebView w=R.id.mw;
       // WebSettings websettings=webView.getSettings();
     //   websettings.setJavaScriptEnabled(true);
        webView.loadUrl("https://app.ubidots.com/ubi/getchart/4OBGJqec-xhAcjx0CFpaPvUaS8s");
        return inflater.inflate(R.layout.fragment_message,container,false);

    }

    }


