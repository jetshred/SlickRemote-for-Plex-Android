package com.jetshred.plexremote;

import android.view.Gravity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

import com.flurry.android.FlurryAgent;

import android.app.Activity;
//import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class PlexRemote extends Activity{
	
	 
	public static final String PREF_FILE_NAME = "PrefFile";
	private SharedPreferences settings;
	private String host;
	private String port;
	private String user;
	private String pass;
	private String server;
	
    /** Called when the activity is first created. */
	public static final int INSERT_ID = Menu.FIRST;
	

	 @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	        MenuItem settings = menu.add(R.string.settings);
	        settings.setIcon(android.R.drawable.ic_menu_preferences);
	        settings.setIntent(new Intent(this, Preferences.class));
	        return true;
	    }
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case INSERT_ID:
            //createNote();
            return true;
        }
       
        return super.onOptionsItemSelected(item);
	}
	
	public SharedPreferences getPrefs() {
		settings = PreferenceManager.getDefaultSharedPreferences
		(getBaseContext());
		return settings;
		}
	public String getRequest() {
		settings = getPrefs();
		host = settings.getString("serverpref", null);
		port = settings.getString("portpref", null);
		if (host != null && host.length() > 0) {
		      server = String.format(user + ":" + pass + "@" + host + ":" + port);
		    }
		else {
			server = "0.0.0.0:" + port;
		}
        return String.format("http://" + server + "/xbmcCmds/xbmcHttp?command=");
      }
	
	public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.main);
        Eula.show(this);
 
 
        
    //final AlertDialog.Builder adb = new AlertDialog.Builder(this);
    
    final ImageButton rev = (ImageButton) findViewById(R.id.rev);
    rev.setOnClickListener(new ImageButton.OnClickListener() {
    	
		@Override
		public void onClick(View v) {
        	try
        	{
        		String rev = getRequest() + String.format("Action(78)");
        		HttpParams my_httpParams = new BasicHttpParams();
                HttpConnectionParams.setConnectionTimeout(my_httpParams,1000);
                HttpConnectionParams.setSoTimeout(my_httpParams,1000);
                
                HttpClient hc = new DefaultHttpClient(my_httpParams);
                HttpGet get = new HttpGet(rev);
                hc.execute(get);

            
        	}catch(Exception e){
        		Toast msg = Toast.makeText(PlexRemote.this, "Server cannot be reached", Toast.LENGTH_SHORT);
                msg.setGravity(Gravity.BOTTOM, msg.getXOffset() / 2, msg.getYOffset() / 2);
                msg.show();
        	}
            
        }
			
    });
    
    final ImageButton ff = (ImageButton) findViewById(R.id.ff);
    ff.setOnClickListener(new ImageButton.OnClickListener() {
    	
		@Override
		public void onClick(View v) {
        	try
        	{
        		String ff = getRequest() + String.format("Action(77)");
        		HttpParams my_httpParams = new BasicHttpParams();
                HttpConnectionParams.setConnectionTimeout(my_httpParams,1000);
                HttpConnectionParams.setSoTimeout(my_httpParams,1000);
                
                HttpClient hc = new DefaultHttpClient(my_httpParams);
                HttpGet get = new HttpGet(ff);
                hc.execute(get);

            
        	}catch(Exception e){
        		Toast msg = Toast.makeText(PlexRemote.this, "Server cannot be reached", Toast.LENGTH_SHORT);
                msg.setGravity(Gravity.BOTTOM, msg.getXOffset() / 2, msg.getYOffset() / 2);
                msg.show();
        	}
        	
            
        }
			
    });
    
    final ImageButton stop = (ImageButton) findViewById(R.id.stop);
    stop.setOnClickListener(new ImageButton.OnClickListener() {
    	
		@Override
		public void onClick(View v) {
        	try
        	{
        		String stop = getRequest() + String.format("Action(13)");
        		HttpParams my_httpParams = new BasicHttpParams();
                HttpConnectionParams.setConnectionTimeout(my_httpParams,1000);
                HttpConnectionParams.setSoTimeout(my_httpParams,1000);
                
                HttpClient hc = new DefaultHttpClient(my_httpParams);
                HttpGet get = new HttpGet(stop);
                hc.execute(get);

            
        	}catch(Exception e){
        		Toast msg = Toast.makeText(PlexRemote.this, "Server cannot be reached", Toast.LENGTH_SHORT);
                msg.setGravity(Gravity.BOTTOM, msg.getXOffset() / 2, msg.getYOffset() / 2);
                msg.show();
        	}
            
        }
			
    });
    
    final ImageButton playpause = (ImageButton) findViewById(R.id.playpause);
    playpause.setOnClickListener(new ImageButton.OnClickListener() {
    	
		@Override
		public void onClick(View v) {
        	try
        	{
        		String playpause = getRequest() + String.format("SendKey(0xF00D)");
        		HttpParams my_httpParams = new BasicHttpParams();
                HttpConnectionParams.setConnectionTimeout(my_httpParams,1000);
                HttpConnectionParams.setSoTimeout(my_httpParams,1000);
                
                HttpClient hc = new DefaultHttpClient(my_httpParams);
                HttpGet get = new HttpGet(playpause);
                hc.execute(get);

            
        	}catch(Exception e){
        		Toast msg = Toast.makeText(PlexRemote.this, "Server cannot be reached", Toast.LENGTH_SHORT);
                msg.setGravity(Gravity.BOTTOM, msg.getXOffset() / 2, msg.getYOffset() / 2);
                msg.show();
        	}
            
        }
			
    });
    final Button back = (Button) findViewById(R.id.back);
    back.setOnClickListener(new Button.OnClickListener() {
    	
		@Override
		public void onClick(View v) {
        	try
        	{
        		String back = getRequest() + String.format("SendKey(0xF01B)");
        		HttpParams my_httpParams = new BasicHttpParams();
                HttpConnectionParams.setConnectionTimeout(my_httpParams,1000);
                HttpConnectionParams.setSoTimeout(my_httpParams,1000);
                
                HttpClient hc = new DefaultHttpClient(my_httpParams);
                HttpGet get = new HttpGet(back);
                hc.execute(get);

            
        	}catch(Exception e){
        		Toast msg = Toast.makeText(PlexRemote.this, "Server cannot be reached", Toast.LENGTH_SHORT);
                msg.setGravity(Gravity.BOTTOM, msg.getXOffset() / 2, msg.getYOffset() / 2);
                msg.show();
        	}
            
        }
			
    });
    final Button menu = (Button) findViewById(R.id.menu);
    menu.setOnClickListener(new Button.OnClickListener() {
    	
		@Override
		public void onClick(View v) {
        	try
        	{
        		String menu = getRequest() + String.format("SendKey(0xF043)");
        		HttpParams my_httpParams = new BasicHttpParams();
                HttpConnectionParams.setConnectionTimeout(my_httpParams,1000);
                HttpConnectionParams.setSoTimeout(my_httpParams,1000);
                
                HttpClient hc = new DefaultHttpClient(my_httpParams);
                HttpGet get = new HttpGet(menu);
                hc.execute(get);

            
        	}catch(Exception e){
        		Toast msg = Toast.makeText(PlexRemote.this, "Server cannot be reached", Toast.LENGTH_SHORT);
                msg.setGravity(Gravity.BOTTOM, msg.getXOffset() / 2, msg.getYOffset() / 2);
                msg.show();
        	}
            
        }
			
    });
    final Button osd = (Button) findViewById(R.id.osd);
    osd.setOnClickListener(new Button.OnClickListener() {
    	
		@Override
		public void onClick(View v) {
        	try
        	{
        		String osd = getRequest() + String.format("SendKey(0xF04D)");
        		HttpParams my_httpParams = new BasicHttpParams();
                HttpConnectionParams.setConnectionTimeout(my_httpParams,1000);
                HttpConnectionParams.setSoTimeout(my_httpParams,1000);
                
                HttpClient hc = new DefaultHttpClient(my_httpParams);
                HttpGet get = new HttpGet(osd);
                hc.execute(get);

            
        	}catch(Exception e){
        		Toast msg = Toast.makeText(PlexRemote.this, "Server cannot be reached", Toast.LENGTH_SHORT);
                msg.setGravity(Gravity.BOTTOM, msg.getXOffset() / 2, msg.getYOffset() / 2);
                msg.show();
        	}
            
        }
			
    });
    final Button up = (Button) findViewById(R.id.up);
    up.setOnClickListener(new Button.OnClickListener() {
    	
		@Override
		public void onClick(View v) {
        	try
        	{
        		String up = getRequest() + String.format("SendKey(0xF026)");
        		HttpParams my_httpParams = new BasicHttpParams();
                HttpConnectionParams.setConnectionTimeout(my_httpParams,1000);
                HttpConnectionParams.setSoTimeout(my_httpParams,1000);
                
                HttpClient hc = new DefaultHttpClient(my_httpParams);
                HttpGet get = new HttpGet(up);
                hc.execute(get);

            
        	}catch(Exception e){
        		Toast msg = Toast.makeText(PlexRemote.this, "Server cannot be reached", Toast.LENGTH_SHORT);
                msg.setGravity(Gravity.BOTTOM, msg.getXOffset() / 2, msg.getYOffset() / 2);
                msg.show();
        	}
            
        }
			
    });
    final Button down = (Button) findViewById(R.id.down);
    down.setOnClickListener(new Button.OnClickListener() {
    	
		@Override
		public void onClick(View v) {
        	try
        	{
        		String down = getRequest() + String.format("SendKey(0xF028)");
        		HttpParams my_httpParams = new BasicHttpParams();
                HttpConnectionParams.setConnectionTimeout(my_httpParams,1000);
                HttpConnectionParams.setSoTimeout(my_httpParams,1000);
                
                HttpClient hc = new DefaultHttpClient(my_httpParams);
                HttpGet get = new HttpGet(down);
                hc.execute(get);

            
        	}catch(Exception e){
        		Toast msg = Toast.makeText(PlexRemote.this, "Server cannot be reached", Toast.LENGTH_SHORT);
                msg.setGravity(Gravity.BOTTOM, msg.getXOffset() / 2, msg.getYOffset() / 2);
                msg.show();
        	}
            
        }
			
    });
    
    final Button left = (Button) findViewById(R.id.left);
    left.setOnClickListener(new Button.OnClickListener() {
    	
		@Override
		public void onClick(View v) {
        	try
        	{
        		String left = getRequest() + String.format("SendKey(0xF025)");
        		HttpParams my_httpParams = new BasicHttpParams();
                HttpConnectionParams.setConnectionTimeout(my_httpParams,1000);
                HttpConnectionParams.setSoTimeout(my_httpParams,1000);
                
                HttpClient hc = new DefaultHttpClient(my_httpParams);
                HttpGet get = new HttpGet(left);
                hc.execute(get);

            
        	}catch(Exception e){
        		Toast msg = Toast.makeText(PlexRemote.this, "Server cannot be reached", Toast.LENGTH_SHORT);
                msg.setGravity(Gravity.BOTTOM, msg.getXOffset() / 2, msg.getYOffset() / 2);
                msg.show();
        	}
            
        }
			
    });
    final Button right = (Button) findViewById(R.id.right);
    right.setOnClickListener(new Button.OnClickListener() {
    	
		@Override
		public void onClick(View v) {
        	try
        	{
        		String right = getRequest() + String.format("SendKey(0xF027)");
        		HttpParams my_httpParams = new BasicHttpParams();
                HttpConnectionParams.setConnectionTimeout(my_httpParams,1000);
                HttpConnectionParams.setSoTimeout(my_httpParams,1000);
                
                HttpClient hc = new DefaultHttpClient(my_httpParams);
                HttpGet get = new HttpGet(right);
                hc.execute(get);

            
        	}catch(Exception e){
        		Toast msg = Toast.makeText(PlexRemote.this, "Server cannot be reached", Toast.LENGTH_SHORT);
                msg.setGravity(Gravity.BOTTOM, msg.getXOffset() / 2, msg.getYOffset() / 2);
                msg.show();
        	}
            
        }
			
    });
    final Button select = (Button) findViewById(R.id.select);
    select.setOnClickListener(new Button.OnClickListener() {
    	
		@Override
		public void onClick(View v) {
        	try
        	{
        		String select = getRequest() + String.format("SendKey(0xF00D)");
        		HttpParams my_httpParams = new BasicHttpParams();
                HttpConnectionParams.setConnectionTimeout(my_httpParams,1000);
                HttpConnectionParams.setSoTimeout(my_httpParams,1000);
                
                HttpClient hc = new DefaultHttpClient(my_httpParams);
                HttpGet get = new HttpGet(select);
                hc.execute(get);

            
        	}catch(Exception e){
        		Toast msg = Toast.makeText(PlexRemote.this, "Server cannot be reached", Toast.LENGTH_SHORT);
                msg.setGravity(Gravity.BOTTOM, msg.getXOffset() / 2, msg.getYOffset() / 2);
                msg.show();
        	}
            
        }
			
    });
    final ImageButton fullscreen = (ImageButton) findViewById(R.id.fullscreen);
    fullscreen.setOnClickListener(new ImageButton.OnClickListener() {
    	
		@Override
		public void onClick(View v) {
        	try
        	{
        		String fullscreen = getRequest() + String.format("Action(199)");
        		HttpParams my_httpParams = new BasicHttpParams();
                HttpConnectionParams.setConnectionTimeout(my_httpParams,1000);
                HttpConnectionParams.setSoTimeout(my_httpParams,1000);
                
                HttpClient hc = new DefaultHttpClient(my_httpParams);
                HttpGet get = new HttpGet(fullscreen);
                hc.execute(get);

            
        	}catch(Exception e){
        		/* AlertDialog ad = adb.create();
                ad.setMessage("No server found at that address");
                ad.show(); */
        		Toast msg = Toast.makeText(PlexRemote.this, "Server cannot be reached", Toast.LENGTH_SHORT);
                msg.setGravity(Gravity.BOTTOM, msg.getXOffset() / 2, msg.getYOffset() / 2);
                msg.show();
        	}
            
        }
			
    });
    final Button updatelib = (Button) findViewById(R.id.updatelib);
    updatelib.setOnClickListener(new Button.OnClickListener() {
    	
		@Override
		public void onClick(View v) {
        	try
        	{
        		String updatelib = getRequest() + String.format("ExecBuiltIn&parameter=XBMC.updatelibrary(video)");
        		HttpParams my_httpParams = new BasicHttpParams();
                HttpConnectionParams.setConnectionTimeout(my_httpParams,1000);
                HttpConnectionParams.setSoTimeout(my_httpParams,1000);
                
                HttpClient hc = new DefaultHttpClient(my_httpParams);
                HttpGet get = new HttpGet(updatelib);
                hc.execute(get);

            
        	}catch(Exception e){
        		/* AlertDialog ad = adb.create();
                ad.setMessage("No server found at that address");
                ad.show(); */
                Toast msg = Toast.makeText(PlexRemote.this, "Server cannot be reached", Toast.LENGTH_SHORT);
                msg.setGravity(Gravity.BOTTOM, msg.getXOffset() / 2, msg.getYOffset() / 2);
                msg.show();
        	}
            
        }
			
    });
    
    }
	public void onStop()
	{
	   super.onStop();
	   FlurryAgent.onEndSession(this);
	   // your code
	}
	
	
}