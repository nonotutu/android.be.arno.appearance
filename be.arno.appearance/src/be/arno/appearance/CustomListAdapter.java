package be.arno.appearance;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import be.arno.appearance.Item;

public class CustomListAdapter extends BaseAdapter {

    private ArrayList<Item> listData;

    private LayoutInflater layoutInflater;

    public CustomListAdapter(Context context, ArrayList<Item> listData) {
        this.listData = listData;
        layoutInflater = LayoutInflater.from(context);
    }
 
    @Override
    public int getCount() {
        return listData.size();
    }
 
    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }
 
    @Override
    public long getItemId(int position) {
        return position;
    }
 
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.list_item_row_layout, null);
            holder = new ViewHolder();
            holder.name = (TextView) convertView.findViewById(R.id.txvwName);
            holder.prop = (TextView) convertView.findViewById(R.id.txvwProp);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
 
        holder.name.setText(listData.get(position).getName());
        holder.prop.setText(listData.get(position).getProp());
 
        return convertView;
    }
 
    static class ViewHolder {
        TextView name;
        TextView prop;
    }
 
}