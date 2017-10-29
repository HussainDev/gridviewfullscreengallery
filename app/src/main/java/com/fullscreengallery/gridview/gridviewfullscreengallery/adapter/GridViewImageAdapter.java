package com.fullscreengallery.gridview.gridviewfullscreengallery.adapter;

import android.app.Activity;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class GridViewImageAdapter extends BaseAdapter {

	private Activity _activity;
	private int imageWidth;



	public GridViewImageAdapter(Activity activity,
								int imageWidth) {
		this._activity = activity;
		this.imageWidth = imageWidth;
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
	public Object getItem(int position) {
		return 0;


	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ImageView imageView;
		if (convertView == null) {
			imageView = new ImageView(_activity);

		} else {
			imageView = (ImageView) convertView;
		}

		String[] images = new String[0];
		try {
			images = _activity.getAssets().list("fajr_maghrib_and_duas");
		} catch (IOException e) {
			e.printStackTrace();
		}
		ArrayList<String> listImages = new ArrayList<String>(Arrays.asList(images));

		Glide.with(_activity)
				.load(Uri.parse("file:///android_asset/fajr_maghrib_and_duas/" + listImages.get(position)))
				.apply(new RequestOptions()
						.diskCacheStrategy(DiskCacheStrategy.NONE))
				.into(imageView);


		imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
		imageView.setLayoutParams(new GridView.LayoutParams(imageWidth,
				imageWidth));
		return imageView;
	}


}
