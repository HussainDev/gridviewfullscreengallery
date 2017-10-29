package com.fullscreengallery.gridview.gridviewfullscreengallery;

import com.fullscreengallery.gridview.gridviewfullscreengallery.adapter.FullScreenImageAdapter;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

public class FullScreenViewActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fullscreen_view);

		ViewPager viewPager = findViewById(R.id.pager);


		Intent i = getIntent();
		int position = i.getIntExtra("position", 0);

		FullScreenImageAdapter adapter = new FullScreenImageAdapter(FullScreenViewActivity.this);

		viewPager.setAdapter(adapter);

		// displaying selected image first
		viewPager.setCurrentItem(position);
	}
}
