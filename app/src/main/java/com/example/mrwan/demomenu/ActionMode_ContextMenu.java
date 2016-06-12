package com.example.mrwan.demomenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ActionMode_ContextMenu extends AppCompatActivity {
ListView listView;
    List<String> nameEn;
    ArrayAdapter<String> adapter;
    int mCount = 0;

    public  final static  String TAG ="DemoActionMode";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_mode__context_menu);
        listView = (ListView) findViewById(R.id.lv1);
        initData();
        adapter = new ArrayAdapter<String>(this,R.layout.item_listview,nameEn);
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        listView.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
                if(checked)
                    mCount ++;
                else
                    mCount --;
                mode.setTitle("count" + mCount);


            }
            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                getMenuInflater().inflate(R.menu.demofloatingmenu,menu);
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                // pt thuc dc goi khi actionmode dc kich hoat
                Log.d(TAG, "onPrepareActionMode: ");
                mCount = 0;
                return true;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.mnDelete) {
                    //xoa thì cần list position
                    //lấy ở đâu???
                    //TODO: xem lại hàm xóa item
                    //Vị trí chắc chắn đúng.
                    SparseBooleanArray checkedArray = listView.getCheckedItemPositions();
                    int itemCount = listView.getCount();
                    for (int  i= itemCount -1 ; i>=0 ;  i--) {
//                    for (int  i=0 ; i<itemCount;  i++) {

//                                               Log.d(TAG, "Click value "  + i + ":"+ checkedArray.valueAt(i));
//                                               Log.d(TAG, "Click Key: " + checkedArray.keyAt(i));
                        if(checkedArray.get(i)) {
                            adapter.remove(nameEn.get(i));

                        }



                    }
                    checkedArray.clear();
                    adapter.notifyDataSetChanged();

                    mode.finish();
                    return true;
                }

                return false;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {
                Log.d(TAG, "onDestroyActionMode: ");
                mCount =0;

            }


        });

    }




    void initData(){
        nameEn = new ArrayList<>();
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
