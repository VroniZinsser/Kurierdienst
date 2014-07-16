package com.example.kurierdienstvroni;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class KurierdienstStart extends Activity {

	private Button managerButton;
    private Button driverButton;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
       setupUI();
       setupButtons();  
    }

    
    

    private void setupButtons() {
    	managerButton.setOnClickListener(new OnClickListener() {
    		
     	   @Override
 			public void onClick(View v) {
     		  Intent i = new Intent(KurierdienstStart.this,
						ManagerActivity.class)
						.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(i);
 			}
        });
        driverButton.setOnClickListener(new OnClickListener() {
    		
    		@Override
    		public void onClick(View v) {
    			
    		}
    	});
	}




	private void setupUI() {
    	setContentView(R.layout.activity_kurierdienst_start);
    	managerButton = (Button) findViewById(R.id.managerLogin);
    	driverButton = (Button) findViewById(R.id.driverLogin);
	}




	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.kurierdienst_start, menu);
        return true;
    }
    
}
