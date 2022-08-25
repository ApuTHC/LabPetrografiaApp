package com.example.geomap12;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class VirtualmicroContentFragment extends Fragment {

  WebView browser;
  View layout;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, @Nullable
          Bundle savedInstanceState) {
    layout = inflater.inflate(R.layout.virtualmicro_fragment, container, false);

    browser=(WebView) layout.findViewById(R.id.webviewmicro);

    browser.getSettings().setBuiltInZoomControls(true);
    browser.setWebViewClient(new WebViewClient() {

      @Override
      public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl(url);
        return true;
      }
    });
    // Cargamos la web
    browser.loadUrl("https://virtualmicroscope.org/content/uk-virtual-microscope");
    WebSettings webSettings = browser.getSettings();
    webSettings.setJavaScriptEnabled(true);

    ((HomeActivity) getActivity()).setTitulo(R.string.menu_virtualmicro);

    return layout;
  }


  public boolean onBackPressed(){
    boolean rtn = false;
    if(browser.canGoBack()){
      browser.goBack();
      rtn = true;
    }
    return rtn;
  }

}

