package com.example.test;

import org.xwalk.core.XWalkView;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {

	private XWalkView wvBrowser;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		wvBrowser = new XWalkView(this);
		wvBrowser.load("http://www.baidu.com", null);
		setContentView(wvBrowser);
	}

}
