package id.co.ptdmc.testwebviewlocalhtml;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

/**
 * Created by Administrator on 12/28/2015.
 */
public class MyAppWebViewClient extends WebViewClient {
    ProgressBar _progressBar;

    public MyAppWebViewClient(ProgressBar pb){
        _progressBar = pb;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        _progressBar.setVisibility(View.VISIBLE);
        if(Uri.parse(url).getHost().endsWith("html5test.com")) {
            return false;
        }

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        view.getContext().startActivity(intent);
        return true;
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
        _progressBar.setVisibility(View.GONE);
    }
}
