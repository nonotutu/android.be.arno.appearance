package be.arno.appearance;

import java.util.ArrayList;

import be.arno.appearance.CustomListAdapter;
import be.arno.appearance.Item;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class ListActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list);
		
		ArrayList<Item> image_details = getListData();
        final ListView lsvw = (ListView) findViewById(R.id.lsvwItems);
        lsvw.setAdapter(new CustomListAdapter(this, image_details));
        lsvw.setOnItemClickListener(
        		new OnItemClickListener() {
 
		            @Override
		            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
		                Object o = lsvw.getItemAtPosition(position);
		                Item item = (Item) o;
		                Toast.makeText(getApplicationContext(), "Selected : " + item.getName(), Toast.LENGTH_SHORT).show();
					}});
	    }
	 
    private ArrayList<Item> getListData() {
        
    	ArrayList<Item> items = new ArrayList<Item>();

        items.add(new Item("Élément 1", "Élément 11"));
        items.add(new Item("Élément 2", "Élément 21"));
        items.add(new Item("Élément 3", "Élément 31"));

        return items;
    }
}