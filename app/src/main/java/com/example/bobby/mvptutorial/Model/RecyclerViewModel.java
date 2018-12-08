package com.example.bobby.mvptutorial.Model;

import android.content.Context;
import android.text.TextUtils;

import com.example.bobby.mvptutorial.Presenter.RecyclerViewPresenter;
import com.example.bobby.mvptutorial.Utilities.MySharedPref;
import com.example.bobby.mvptutorial.View.RecyclerViewView;

public class RecyclerViewModel implements RecyclerViewPresenter {

    private Context context;

    private RecyclerViewView recyclerViewView;

    public RecyclerViewModel(Context context, RecyclerViewView recyclerViewView) {
        this.context = context;
        this.recyclerViewView = recyclerViewView;
    }

    @Override
    public void setValues() {
        MySharedPref.init(context);
        String name = MySharedPref.read("Name", null);
        String pass = MySharedPref.read("Password", null);

        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(pass))
        {
            recyclerViewView.retrieveFailed();
        }
        else
        {
            recyclerViewView.retrieveSuccess(name, pass);
        }

    }
}
