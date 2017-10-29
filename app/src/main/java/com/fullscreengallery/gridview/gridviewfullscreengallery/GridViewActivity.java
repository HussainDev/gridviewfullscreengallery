package com.fullscreengallery.gridview.gridviewfullscreengallery;

import com.fullscreengallery.gridview.gridviewfullscreengallery.adapter.GridViewImageAdapter;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class GridViewActivity extends Activity {

	private GridView gridView;
	private int columnWidth;
	// Number of columns of Grid View
	public static final int NUM_OF_COLUMNS = 3;

	// Gridview image padding
	public static final int GRID_PADDING = 8; // in dp

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_grid_view);

		gridView = findViewById(R.id.grid_view);

		ActionBar bar = getActionBar();
		assert bar != null;
		bar.setBackgroundDrawable(new ColorDrawable(Color.MAGENTA));


		// Initiliazing Grid View
		InitilizeGridLayout();

		// Gridview adapter
		GridViewImageAdapter adapter = new GridViewImageAdapter(GridViewActivity.this,
				columnWidth);

		// setting grid view adapter
		gridView.setAdapter(adapter);


		gridView.setAdapter(adapter);
		gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			public void onItemClick(AdapterView parent, View v, int position, long id) {
				Toast.makeText(GridViewActivity.this, "" + position,
						Toast.LENGTH_SHORT).show();
				Intent i = new Intent(GridViewActivity.this, FullScreenViewActivity.class);
			i.putExtra("position", position);
				GridViewActivity.this.startActivity(i);
			}
		});




	}

	private void InitilizeGridLayout() {
		Resources r = getResources();
		float padding = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
				GRID_PADDING, r.getDisplayMetrics());

		columnWidth = (int) ((getScreenWidth() - ((NUM_OF_COLUMNS + 1) * padding)) / NUM_OF_COLUMNS);

		gridView.setNumColumns(NUM_OF_COLUMNS);
		gridView.setColumnWidth(columnWidth);
		gridView.setStretchMode(GridView.NO_STRETCH);
		gridView.setPadding((int) padding, (int) padding, (int) padding,
				(int) padding);
		gridView.setHorizontalSpacing((int) padding);
		gridView.setVerticalSpacing((int) padding);
	}

	public int getScreenWidth() {
		int columnWidth;
		WindowManager wm = (WindowManager) this
				.getSystemService(Context.WINDOW_SERVICE);
		assert wm != null;
		Display display = wm.getDefaultDisplay();

		final Point point = new Point();
		try {
			display.getSize(point);
		} catch (java.lang.NoSuchMethodError ignore) { // Older device
			point.x = display.getWidth();
			point.y = display.getHeight();
		}
		columnWidth = point.x;
		return columnWidth;
	}

}
