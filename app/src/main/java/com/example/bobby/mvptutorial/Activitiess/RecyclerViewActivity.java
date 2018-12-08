package com.example.bobby.mvptutorial.Activitiess;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bobby.mvptutorial.Model.RecyclerViewModel;
import com.example.bobby.mvptutorial.Presenter.RecyclerViewPresenter;
import com.example.bobby.mvptutorial.R;
import com.example.bobby.mvptutorial.View.RecyclerViewView;

public class RecyclerViewActivity extends AppCompatActivity implements RecyclerViewView {

    TextView name, pass;
    RecyclerViewPresenter recyclerViewPresenter;
    String[] arr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        recyclerViewPresenter = new RecyclerViewModel(getApplicationContext(), this);

        arr = new String[2];

        name=findViewById(R.id.name);
        pass=findViewById(R.id.pass);
         recyclerViewPresenter.setValues();
    }

    @Override
    public void retrieveSuccess(String username, String password) {
        if (!TextUtils.isEmpty(username) || !TextUtils.isEmpty(password))
        {
            name.setText(username);
            pass.setText(password);
        }
        else
            Toast.makeText(this, "Error on retrieveSuccess : logic error", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void retrieveFailed() {
        Toast.makeText(this, "Unable to retrieve data", Toast.LENGTH_SHORT).show();
    }
}
