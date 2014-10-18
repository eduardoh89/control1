package com.example.control1;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
	private static String url = "http://www.mocky.io/v2/5440667984d353f103f697c0";
	  //JSON Node Names
	  private static final String TAG_TITLE = "title";
	  private static final String TAG_IMAGE = "image";
	  private static final String TAG_POINTS = "points";
	  //private static final String TAG_LINK = "links";
	  JSONArray menu = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// Creating new JSON Parser
	    JSONParser jParser = new JSONParser();
	    // Getting JSON from URL
	    JSONObject json = jParser.getJSONFromUrl(url);
	    int i;
	    for(i=0;i<json.length();i++){
	    try {
	      JSONObject c = menu.getJSONObject(0);
	      // Storing  JSON item in a Variable
	      String title = c.getString(TAG_TITLE);
	      String image = c.getString(TAG_IMAGE);
	      String points = c.getString(TAG_POINTS);
	      //String links = c.getString(TAG_LINK);
	      //Importing TextView
	      final TextView title1 = (TextView)findViewById(R.id.tit);
	      final TextView image1 = (TextView)findViewById(R.id.img);
	      final TextView points1 = (TextView)findViewById(R.id.poin);
	      //final TextView lin1 = (TextView)findViewById(R.id.lin);
	      //Set JSON Data in TextView
	      title1.setText(title);
	      image1.setText(image);
	      points1.setText(points);
	  } catch (JSONException e) {
	    e.printStackTrace();
	  }
	    }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
