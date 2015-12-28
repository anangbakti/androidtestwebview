package id.co.ptdmc.testwebviewlocalhtml;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private WebView _webView;
    private ProgressBar _progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _webView = (WebView)findViewById(R.id.activity_main_webview);
        _progressBar = (ProgressBar)findViewById(R.id.progressBar1);
        WebSettings webSettings = _webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        _webView.loadUrl("http://beta.html5test.com/");
        _webView.setWebViewClient(new MyAppWebViewClient(_progressBar));
    }

    @Override
    public void onBackPressed() {
        if(_webView.canGoBack()) {
            _webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
