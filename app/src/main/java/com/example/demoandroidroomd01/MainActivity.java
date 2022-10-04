package com.example.demoandroidroomd01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lvContact;
    private EditText edtContact;

    private ArrayAdapter<String> arrayAdapter;
    private List<String> dataSource;

    private ContactDAO contactDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvContact = findViewById(R.id.lvContact);
        edtContact = findViewById(R.id.edtContact);
        // Config DB
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "database-name")
                .allowMainThreadQueries().build();
        contactDAO = db.getContactDAO();

        dataSource = new ArrayList<>();
        // do du lieu tu db -> vao datasource
        List<Contact> tmp=  contactDAO.getAll();
        for(int i= 0; i < tmp.size(); i++ ){
            dataSource.add(tmp.get(i).toString());
        }

        arrayAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1,dataSource);
        lvContact.setAdapter(arrayAdapter);
    }

    public void addNewContact(View view) {
        // Xu ly sau
        String input = edtContact.getText().toString();
        if(input.isEmpty()){
            edtContact.setError("Hay nhap du lieu");
            return;
        }
        Contact item  = new Contact();
        item.contact = input;
        contactDAO.insert(item);

        dataSource.add(input);
        arrayAdapter.notifyDataSetChanged();
        edtContact.setText("");
    }
}