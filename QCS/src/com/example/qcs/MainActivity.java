package com.example.qcs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	private Button btn01;
	private Button btn02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        btn01 = (Button)findViewById(R.id.btn01);
        btn01.setOnClickListener(new OnClickListener(
        		) {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			
				
				startActivity(new Intent(MainActivity.this,TopRecommendedActivity.class));
			}
		});
        btn02 = (Button)findViewById(R.id.btn02);
        btn02.setOnClickListener(new OnClickListener(
        		) {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			
				
				startActivity(new Intent(MainActivity.this,FilterActivity.class));
			}
		});
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
