package com.example.sistemadevendas;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;




public class fabricanteview extends AppCompatActivity {

    ListView listview;
    ArrayList<String> titles = new ArrayList<String>();
    ArrayAdapter arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fabricante_view);

        listview = findViewById(R.id.Lst2);
        SQLiteDatabase db = openOrCreateDatabase("supervenda", Context.MODE_PRIVATE, null);
        final Cursor c = db.rawQuery("select * from  fabricante", null);
        int id = c.getColumnIndex("id");
        int fabricante = c.getColumnIndex("fabricante");
        int descfab = c.getColumnIndex("descfab");

        titles.clear();

        arrayAdapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item,titles);

        listview.setAdapter(arrayAdapter);
        final ArrayList<fab> fabri = new ArrayList<fab>();
        if (c.moveToNext()){
            do{
                fab br = new fab();
                br.id = c.getString(id);
                br.fabricante = c.getString(fabricante);
                br.descricao = c.getString(descfab);

                fabri.add(br);

                titles.add(c.getString(id)+ "\t" + c.getString(fabricante)+ "\t" + c.getString(descfab)+ "\t");


            } while(c.moveToNext());
            arrayAdapter.notifyDataSetChanged();
            listview.invalidateViews();
        }

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String bbb = titles.get(position).toString();
                fab br = fabri.get((position));
                Intent i = new Intent(getApplicationContext(), CategoriaEditar.class);
                i.putExtra("id",br.id);
                i.putExtra("fabricante",br.fabricante);
                i.putExtra("descfab",br.descricao);

                startActivity(i);;

            }
        });
    }
}