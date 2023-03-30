package com.sys.webglobe;

import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.os.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.*;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import org.json.*;

public class MainActivity extends Activity {
	
	private LinearLayout linear1;
	private LinearLayout linear4;
	private LinearLayout linear7;
	private WebView Main_WebView;
	private EditText URLTextbox;
	private Button GoBack;
	private Button SearchButton;
	private Button GoForward;
	private Button SettingsButton;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		linear4 = findViewById(R.id.linear4);
		linear7 = findViewById(R.id.linear7);
		Main_WebView = findViewById(R.id.Main_WebView);
		Main_WebView.getSettings().setJavaScriptEnabled(true);
		Main_WebView.getSettings().setSupportZoom(true);
		URLTextbox = findViewById(R.id.URLTextbox);
		GoBack = findViewById(R.id.GoBack);
		SearchButton = findViewById(R.id.SearchButton);
		GoForward = findViewById(R.id.GoForward);
		SettingsButton = findViewById(R.id.SettingsButton);
		
		Main_WebView.setWebViewClient(new WebViewClient() {
			@Override
			public void onPageStarted(WebView _param1, String _param2, Bitmap _param3) {
				final String _url = _param2;
				URLTextbox.setText(_url);
				super.onPageStarted(_param1, _param2, _param3);
			}
			
			@Override
			public void onPageFinished(WebView _param1, String _param2) {
				final String _url = _param2;
				
				super.onPageFinished(_param1, _param2);
			}
		});
		
		GoBack.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				Main_WebView.goBack();
			}
		});
		
		SearchButton.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View _view) {
				SketchwareUtil.showMessage(getApplicationContext(), "You found an Easter Egg!");
				return true;
			}
		});
		
		SearchButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				Main_WebView.loadUrl(URLTextbox.getText().toString());
			}
		});
		
		GoForward.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				Main_WebView.goForward();
			}
		});
		
		SettingsButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
	}
	
	private void initializeLogic() {
		Main_WebView.loadUrl("syss.eu.org/webglobe/thanks.html");
	}
	
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input) {
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels() {
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels() {
		return getResources().getDisplayMetrics().heightPixels;
	}
}