package com.example.ritikamenuitemstudy;

import android.os.Build;
import android.os.Bundle;
import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	ActionBar ab;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ab = getActionBar();

		ab.setTitle("CMC Delhi");
		ab.setSubtitle("cmcdelhi.com");

		Drawable d = getResources().getDrawable(R.drawable.ic_launcher);
		ab.setBackgroundDrawable(d);

		ab.setHomeButtonEnabled(true);

		ab.setBackgroundDrawable(getWallpaper());

	}

	//public void onShow(View v) {
		//ab.show();
//	}

	//public void onHide(View v) {
	//	ab.hide();
	//}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		MenuItem mnu1 = menu.add(0, 1, 1, "Refresh");
		mnu1.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
		mnu1.setIcon(R.drawable.navigationresh);

		MenuItem mnu2 = menu.add(0, 2, 2, "Edit");
		mnu2.setShowAsAction(MenuItem.SHOW_AS_ACTION_WITH_TEXT);
		mnu2.setIcon(R.drawable.actionsettings);

		MenuItem mnu3 = menu.add(0, 3, 3, "Save");
		mnu3.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM
				| MenuItem.SHOW_AS_ACTION_WITH_TEXT);
		mnu3.setIcon(R.drawable.ic_launcher);

		SubMenu sb1 = menu.addSubMenu(0, 1, 1, "Sub Save 1");
		menu.addSubMenu(0, 2, 2, "Sub Save 2");

		MenuItem mnu4 = menu.add(0, 4, 4, "Delete");
		mnu4.setShowAsAction(MenuItem.SHOW_AS_ACTION_NEVER);
 
		return true;
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		switch (item.getItemId()) {
		case 1:
			Toast.makeText(getBaseContext(), "Refresh Selected ",
					Toast.LENGTH_LONG).show();
			break;
		case 2:
			Toast.makeText(getBaseContext(), "Edit Selected ",
					Toast.LENGTH_LONG).show();
			break;
		case 3:
			Toast.makeText(getBaseContext(), "Save Selected ",
					Toast.LENGTH_LONG).show();
			break;
		case 4:
			Toast.makeText(getBaseContext(), "Delete Selected ",
					Toast.LENGTH_LONG).show();
			break;
		case android.R.id.home:
			Toast.makeText(getBaseContext(), "Home  Selected ",
					Toast.LENGTH_LONG).show();
			break;
		default:
			break;
		}

		return super.onMenuItemSelected(featureId, item);
	}

	@Override
	public boolean onMenuOpened(int featureId, Menu menu) {

		Toast.makeText(getBaseContext(), "Menu Opened ", Toast.LENGTH_LONG)
				.show();

		//return false;
		 return super.onMenuOpened(featureId, menu);
	}

	@Override
	public void onBackPressed() {
		//ab.hide();
		 super.onBackPressed();
	}

	public void closeMe(View v) {
		finish();

	}

}
