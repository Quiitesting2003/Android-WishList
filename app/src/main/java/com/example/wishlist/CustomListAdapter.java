package com.example.wishlist;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private List<Country> listCountry;
    private LayoutInflater layoutInflater;
    private Context context;

    public CustomListAdapter(List<Country> listCountry, Context context) {
        this.listCountry = listCountry;
        this.layoutInflater = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public int getCount() {
        return listCountry.size();
    }

    @Override
    public Object getItem(int i) {
        return listCountry.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view == null){
            view = layoutInflater.inflate(R.layout.layout2, null);
            holder = new ViewHolder();
            holder.flagView = (ImageView) view.findViewById(R.id.imageView_flag);
            holder.nameView = (TextView) view.findViewById(R.id.textView_name);
            holder.countryView = (TextView) view.findViewById(R.id.textView_country);
            holder.checkbox=(CheckBox)view.findViewById(R.id.cityCheckBox);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }
        Country country = this.listCountry.get(i);
        holder.nameView.setText(country.getName());
        holder.countryView.setText(country.getCountry());
        int imageId = this.getMipmapResId(country.getFlag());
        holder.flagView.setImageResource(imageId);
        holder.checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                country.setCheckbox(isChecked);
            }
        });
        return view;

    }

    public int getMipmapResId(String resName){
        String pkgName = context.getPackageName();
        int resID = context.getResources().getIdentifier(resName,
                "mipmap", pkgName);
        Log.i("CustomListView", "Res Name: " +
                resName + "==> Res ID = " + resID);
        return resID;
    }
    static class ViewHolder{
        ImageView flagView;
        TextView nameView;
        TextView countryView;
        CheckBox checkbox;

    }
}
