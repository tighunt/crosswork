package com.crosswalktest;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import org.xwalk.core.XWalkJavascriptResult;
import org.xwalk.core.XWalkJavascriptResultHandler;
import org.xwalk.core.XWalkResourceClient;
import org.xwalk.core.XWalkUIClient;
import org.xwalk.core.XWalkView;

public class MainActivity extends Activity {

    private XWalkView wvBrowser;
    String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        wvBrowser = new XWalkView(this);
        wvBrowser.load("http://www.baidu.com", null);
        wvBrowser.setNetworkAvailable(false);
        setContentView(wvBrowser);

        wvBrowser.setUIClient(new XWalkUIClient(wvBrowser){
            public void onPageLoadStarted(XWalkView view,String url){
                Log.e(TAG, "onPageStarted + " + url);

            }
            public void  onPageLoadStopped(XWalkView view,String url,XWalkUIClient.LoadStatus status){

            }

            public boolean onJavascriptModalDialog(XWalkView view, XWalkUIClient.JavascriptMessageType type, String url, String message, String defaultValue, XWalkJavascriptResult result) {
                Log.e(TAG, "message + " + message);
                return super.onJavascriptModalDialog( view,  type,  url,  message,  defaultValue,  result);
            }
        });

        wvBrowser.setResourceClient(new XWalkResourceClient(wvBrowser){
            public void onProgressChanged(XWalkView view, int progressInPercent){

            }

            public void onReceivedLoadError(XWalkView view, int errorCode, String description, String failingUrl) {
                Log.e(TAG, "errorCode + " + errorCode +" description + " + description);

            }
        });
    }

}
