package be.arno.appearance;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
    
		Button bttnShow = (Button) findViewById(R.id.bttnShow);
		bttnShow.setOnClickListener(
				new View.OnClickListener() {
					@Override
			        public void onClick(View v) {
						Intent i = new Intent(getApplicationContext(), ShowActivity.class);
						startActivity(i);
					}});
		
		Button bttnEdit = (Button) findViewById(R.id.bttnEdit);
		bttnEdit.setOnClickListener(
				new View.OnClickListener() {
					@Override
			        public void onClick(View v) {
						Intent i = new Intent(getApplicationContext(), EditActivity.class);
						startActivity(i);
					}});
		
		Button bttnList = (Button) findViewById(R.id.bttnList);
		bttnList.setOnClickListener(
				new View.OnClickListener() {
					@Override
			        public void onClick(View v) {
						Intent i = new Intent(getApplicationContext(), ListActivity.class);
						startActivity(i);
					}});

		Button bttnChoice = (Button) findViewById(R.id.bttnChoice);
		bttnChoice.setOnClickListener(
				new View.OnClickListener() {
					@Override
			        public void onClick(View v) {
						Toast.makeText(getApplicationContext(), "Boum", Toast.LENGTH_SHORT).show();
					}});	
	}
}
