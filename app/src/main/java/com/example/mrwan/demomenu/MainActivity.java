package com.example.mrwan.demomenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ActionMode_ContextMenu.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.demooptionmenu,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.mnSearch){
            Toast.makeText(this, "Search", Toast.LENGTH_SHORT).show();
            return  true;
        }else if (id == R.id.mnInsert){
            Toast.makeText(this, "Insert", Toast.LENGTH_SHORT).show();
            return  true;
        }
        else if (id == R.id.mnRefresh){
            Toast.makeText(this, "Refresh", Toast.LENGTH_SHORT).show();
            return  true;
        }
        return super.onOptionsItemSelected(item);
    }
}
