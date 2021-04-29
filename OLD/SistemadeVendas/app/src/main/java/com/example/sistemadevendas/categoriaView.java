package com.example.sistemadevendas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.ActionMenuItemView;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class categoriaView extends AppCompatActivity {

    ListView listview;
    ArrayList<String> titles = new ArrayList<String>();
    ArrayAdapter arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria_view);

        listview = findViewById(R.id.Lst1);
        SQLiteDatabase db = openOrCreateDatabase("supervenda", Context.MODE_PRIVATE, null);
        final Cursor c = db.rawQuery("select * from  categoria1", null);
        int id = c.getColumnIndex("id");
        int categoria = c.getColumnIndex("categoria");
        int catdesc = c.getColumnIndex("catdesc");

        titles.clear();

        arrayAdapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item,titles);

        listview.setAdapter(arrayAdapter);
        final ArrayList<cate> catee = new ArrayList<cate>();
        if (c.moveToNext()){
            do{
                cate ca = new cate();
                ca.id = c.getString(id);
                ca.categoria = c.getString(categoria);
                ca.descricao = c.getString(catdesc);

                catee.add(ca);

                titles.add(c.getString(id)+ "\t" + c.getString(categoria)+ "\t" + c.getString(catdesc)+ "\t");


            } while(c.moveToNext());
            arrayAdapter.notifyDataSetChanged();
            listview.invalidateViews();

        }

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String aaa = titles.get(position).toString();
                cate ca = catee.get((position));
                Intent i = new Intent(getApplicationContext(), CategoriaEditar.class);
                i.putExtra("id",ca.id);
                i.putExtra("categoria",ca.categoria);
                i.putExtra("catdesc",ca.descricao);

                startActivity(i);;



            }
        });
    }
}