package be.arno.appearance;

import java.util.Calendar;

import android.os.Bundle;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

public class EditActivity extends Activity {

	private int year = 0, month = 0, day = 0;
	private int hour = 0, minute = 0;
	
	private EditText edtxDate;
	private EditText edtxTime;

	private DatePickerDialog dialogDate = null;
	private TimePickerDialog dialogTime = null;

	Context context;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit);
		
		edtxDate = (EditText) findViewById(R.id.edtxDate);
		edtxTime = (EditText) findViewById(R.id.edtxTime);
		context = getApplicationContext();
    
		Button bttnDate = (Button) findViewById(R.id.bttnDate);
		bttnDate.setOnClickListener(
				new View.OnClickListener() {
					@Override
			        public void onClick(View v) {
			            if ( year != 0 && month != 0 && day != 0 )
				            dialogDate = new DatePickerDialog(v.getContext(), new PickDate(), year, month, day);
			            else {
				            Calendar dtTxt = Calendar.getInstance();
			            	dialogDate = new DatePickerDialog(v.getContext(), new PickDate(), dtTxt.get(Calendar.YEAR),dtTxt.get(Calendar.MONTH), dtTxt.get(Calendar.DAY_OF_MONTH));
			            }
			            dialogDate.show();
			}});

		Button bttnTime = (Button) findViewById(R.id.bttnTime);
		bttnTime.setOnClickListener(
				new View.OnClickListener() {
					@Override
			        public void onClick(View v) {
						dialogTime = new TimePickerDialog(v.getContext(), new PickTime(), hour, minute, true);
			            dialogTime.show();
			}});

	}
	

	private class PickDate implements DatePickerDialog.OnDateSetListener {
		@Override
		public void onDateSet(DatePicker view, int y, int m, int d) {
			Log.i("PickDate", "onDateSet");
			Calendar date = Calendar.getInstance();
			date.set(Calendar.YEAR, year = y);
		    date.set(Calendar.MONTH, month = m);
		    date.set(Calendar.DAY_OF_MONTH, day = d);
			String datef = DateFormat.getDateFormat(getApplicationContext()).format(date.getTime());
			dialogDate.dismiss();
			edtxDate.setText(datef);
		}
	}

	
	private class PickTime implements TimePickerDialog.OnTimeSetListener {
		@Override
		public void onTimeSet(TimePicker view, int h, int m) {
			Log.i("PickTime", "onTimeSet");
			Calendar time = Calendar.getInstance();
			time.set(Calendar.HOUR, hour = h);
		    time.set(Calendar.MINUTE, minute = m);
			String timef = DateFormat.getTimeFormat(getApplicationContext()).format(time.getTime());
			dialogTime.dismiss();
			edtxTime.setText(timef);
		}
	}

}
