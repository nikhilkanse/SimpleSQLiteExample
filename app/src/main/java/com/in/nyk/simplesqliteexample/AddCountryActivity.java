package com.in.nyk.simplesqliteexample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.in.nyk.simplesqliteexample.DataBase.DBManager;

/**
 * Created by nikhilkanse on 19/02/18.
 */

public class AddCountryActivity extends Activity implements View.OnClickListener {

    private Button addTodoBtn;
    private EditText subjectEditText;
    private EditText descEditText;

    private DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("Add Record");

        setContentView(R.layout.activity_add_records);

        subjectEditText = (EditText) findViewById(R.id.subject_edittext);
        descEditText = (EditText) findViewById(R.id.description_edittext);

        addTodoBtn = (Button) findViewById(R.id.add_record);

        dbManager = new DBManager(this);
        dbManager.open();
        addTodoBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_record:

                final String name = subjectEditText.getText().toString();
                final String desc = descEditText.getText().toString();

                dbManager.insert(name, desc);

                Intent main = new Intent(AddCountryActivity.this, MainActivity.class)
                        .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                startActivity(main);
                break;
        }
    }

}
