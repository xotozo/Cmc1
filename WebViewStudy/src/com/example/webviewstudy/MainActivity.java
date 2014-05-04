package com.example.webviewstudy;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class MainActivity extends Activity {

	WebView wv;
	WebSettings wb;

	Button btnNext;
	Button btnPrev;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		wv = (WebView) findViewById(R.id.webView1);

		btnNext = (Button) findViewById(R.id.button2);
		btnPrev = (Button) findViewById(R.id.button3);

		wv.setWebViewClient(new WebViewClient() {
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				return false;
			}
		});

		wb = wv.getSettings();
		wb.setBuiltInZoomControls(true);

		wb.setJavaScriptEnabled(true);
		wb.setJavaScriptCanOpenWindowsAutomatically(true);

		wb.setDisplayZoomControls(true);

		if (wv.canGoForward()) {
			btnNext.setEnabled(true);
		} else {
			btnNext.setEnabled(false);
		}

		if (wv.canGoBack()) {
			btnPrev.setEnabled(true);
		} else {
			btnPrev.setEnabled(false);
		}

	}

	public void loadMe(View v) {
		// wv.loadUrl("http://www.google.com");

		// wv.loadData(
		// "<html><head><script type='text/javascript'>function work() {"
		// + "var x=document.getElementById('as');"
		// + "x.innerHTML='ABC';"
		// +
		// "alert('You Clicked Me');}</script></head><body bgcolor='yellow' ><h1>Hello</h1><p id='as'>This is along  description.</p><button onclick='work()'>Clcik me</button><address>Developed by Kapil</address></body></html>",
		// "text/plain", "UTF-8");

		wv.loadData("file:/android_asset/index.html", "text/html", "UTF-8");

		if (wv.canGoForward()) {
			btnNext.setEnabled(true);
		}
		if (wv.canGoBack()) {
			btnPrev.setEnabled(true);
		}

	}

	public void next(View v) {
		wv.goForward();
	}

	public void prev(View v) {
		wv.goBack();

	}

}
