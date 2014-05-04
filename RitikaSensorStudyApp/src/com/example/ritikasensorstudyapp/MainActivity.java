package com.example.ritikasensorstudyapp;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity implements SensorEventListener {

	SensorManager sensmgr;
	Sensor accSensor;

	TextView tvX, tvY, tvZ; //ravi

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tvX = (TextView) findViewById(R.id.textView1);
		tvY = (TextView) findViewById(R.id.textView2);
		tvZ = (TextView) findViewById(R.id.textView3);

		sensmgr = (SensorManager) getSystemService(SENSOR_SERVICE);

		accSensor = sensmgr.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);


		
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
	}

	@Override
	public void onSensorChanged(SensorEvent event) {

		float[] sensorValue = event.values;

		float xValue = sensorValue[0];
		float yValue = sensorValue[1];
		float zValue = sensorValue[2];

		tvX.setText("X : " + xValue);
		tvY.setText("Y : " + yValue);
		tvZ.setText("Z : " + zValue);
		
		    
		
		if(xValue>18) 
		{
			Intent shareIntent = new Intent(Intent.ACTION_SEND);
		     shareIntent.setType("text/plain");
		     shareIntent.putExtra(Intent.EXTRA_TEXT, "Download Thirsty crow story app - Read Listen. Download ★free★ apps link: https://play.google.com/store/apps/developer?id=XoToZo+Interactive");
		     startActivity(Intent.createChooser(shareIntent, "Share via...")); 
		     
		     
		     Intent i2 = new Intent(Intent.ACTION_VIEW);
		     i2.setData(Uri.parse("http://google.com"));
		     startActivity(i2);
		     
		     
		     
		     Intent i1= new Intent(Intent.ACTION_CALL);
		     i1.setData(Uri.parse("tel:9999654592"));
		     startActivity(i1);
		}
		

	}

	@Override
	protected void onResume() {


		sensmgr.registerListener(this, accSensor, SensorManager.SENSOR_DELAY_NORMAL);

		super.onResume();
	}

	@Override
	protected void onPause() {
		sensmgr.unregisterListener(this, accSensor);

		super.onPause();
	}
	
	

}
