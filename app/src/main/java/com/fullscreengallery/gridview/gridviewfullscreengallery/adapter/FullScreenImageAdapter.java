package com.fullscreengallery.gridview.gridviewfullscreengallery.adapter;

import com.fullscreengallery.gridview.gridviewfullscreengallery.R;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


public class FullScreenImageAdapter extends PagerAdapter {

	private Activity _activity;

	// constructor
	public FullScreenImageAdapter(Activity activity) {
		this._activity = activity;
	}

	@Override
	public int getCount() {

		String[] images = new String[0];
		try {
			images = _activity.getAssets().list("fajr_maghrib_and_duas");
		} catch (IOException e) {
			e.printStackTrace();
		}
		ArrayList<String> listImages = new ArrayList<>(Arrays.asList(images));

		return listImages.size();

	}

	@Override
	public boolean isViewFromObject(View view, Object object) {
		return view == object;
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		ImageView imgDisplay;
		Button btnClose;

		LayoutInflater inflater = (LayoutInflater) _activity
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		assert inflater != null;
		View viewLayout = inflater.inflate(R.layout.layout_fullscreen_image, container,
				false);


		imgDisplay = viewLayout.findViewById(R.id.imgDisplay);

		String[] images = new String[0];
		try {
			images = _activity.getAssets().list("fajr_maghrib_and_duas");
		} catch (IOException e) {
			e.printStackTrace();
		}
		ArrayList<String> listImages = new ArrayList<>(Arrays.asList(images));

		Glide.with(_activity)
				.load(Uri.parse("file:///android_asset/fajr_maghrib_and_duas/" + listImages.get(position)))
				.apply(new RequestOptions()
						.diskCacheStrategy(DiskCacheStrategy.NONE))
				.into(imgDisplay);


		btnClose = viewLayout.findViewById(R.id.btnClose);


		// close button click event
		btnClose.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				_activity.finish();
			}
		});

		container.addView(viewLayout);

		return viewLayout;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView((RelativeLayout) object);

	}
}