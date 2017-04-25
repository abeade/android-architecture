package com.abeade.android.architecture.testapp.presentation.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.abeade.android.architecture.testapp.R;
import com.abeade.android.architecture.testapp.presentation.presenter.MainActivityPresenter;
import com.abeade.android.architecture.testapp.presentation.view.MainActivityView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;

public class MainActivity extends AppCompatActivity implements MainActivityView {

    @BindView(R.id.tv_content)
    TextView tvContent;

    @Inject
    MainActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        presenter.loadData();
    }

    @Override
    public void setText(String text) {
        tvContent.setText(text);
    }
}
