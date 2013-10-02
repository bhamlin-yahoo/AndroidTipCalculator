package com.bhamlin.tipcalculator;

import java.text.NumberFormat;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TipCalculatorActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);
        
        // 10% Button
        Button buttonTenPercent = (Button) findViewById(R.id.buttonTenPercent);
        buttonTenPercent.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				calculateTip(0.1f);
			}
		}); 
        
        
        // 15% Button
        Button buttonFifteenPercent = (Button) findViewById(R.id.buttonFifteenPercent);
        buttonFifteenPercent.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				calculateTip(0.15f);
			}
		}); 
        
        
        // 20% Button
        Button buttonTwentyPercent = (Button) findViewById(R.id.buttonTwentyPercent);
        buttonTwentyPercent.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				calculateTip(0.2f);
			}
		});
    }


    public void calculateTip(float percent) {
    	
    	EditText dollarAmount = (EditText) findViewById(R.id.editTextAmount);
    	String dollarString = "";
		if(!(dollarString = dollarAmount.getText().toString()).matches("")) {	
			
			try{
				TextView tipAmount = (TextView) findViewById(R.id.textViewTipAmount);			
				float calculatedTip = Float.parseFloat(dollarString) * percent;
				NumberFormat dollarValue = NumberFormat.getCurrencyInstance();
				tipAmount.setText(dollarValue.format(calculatedTip));
				
				dollarAmount.setText("");
			}
			catch (NumberFormatException e) {				
				showError("You've entered an invalid number");
			}
		}
		else {
			showError("You must enter a dollar amount");
		}
    }

    public void showError(String text) {
    	Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG).show();
    	TextView tipAmount = (TextView) findViewById(R.id.textViewTipAmount);
    	tipAmount.setText("");
    }
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.tip_calculator, menu);
        return true;
    }
    
}
