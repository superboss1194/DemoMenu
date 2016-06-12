package com.example.mrwan.demomenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Floating_Context_Menu extends AppCompatActivity {
    ListView lv;
    List<String> nameEn;
    ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floating__context__menu);
        lv = (ListView) findViewById(R.id.lv);
        initData();
        arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,nameEn);
        lv.setAdapter(arrayAdapter);
        //b2: dk su dung menu for lv
        registerForContextMenu(lv);
    }
    //b1: tao menu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.demofloatingmenu,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }
    //b3: bat sk

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();
        AdapterView.AdapterContextMenuInfo adapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int pos = adapterContextMenuInfo.position;

        if(id == R.id.mnUpdate){
            Toast.makeText(this, "Update", Toast.LENGTH_SHORT).show();
            return  true;
        } else  if ( id == R.id.mnDelete){
            Toast.makeText(this, "Delete", Toast.LENGTH_SHORT).show();
            nameEn.remove(pos);
            arrayAdapter.notifyDataSetChanged();
            return  true;
        }
        return super.onContextItemSelected(item);
    }

    void initData(){
        nameEn = new ArrayList<>();
        nameEn.add("Vietnam");
        nameEn.add("China");
        nameEn.add("Laos");
        nameEn.add("Cambodia");
        nameEn.add("Thailand");
        nameEn.add("Myanma");
        nameEn.add("Philipin");
        nameEn.add("Malaysia");
        nameEn.add("Indonesia");
        nameEn.add("Singapore");
        nameEn.add("Brunei");
        nameEn.add("DongTiMo");
    }
}
