package com.adriyo.daggerpractice.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.adriyo.daggerpractice.R;
import com.adriyo.daggerpractice.data.PeopleData;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.subscriptions.CompositeSubscription;

public class MainActivity extends AppCompatActivity implements MainViewModel.MainView {

    private static final String TAG = MainActivity.class.getSimpleName();
    @BindView(R.id.people_rv)
    RecyclerView peopleRv;

    @BindView(R.id.next_btn)
    Button nextBtn;

    @BindView(R.id.prev_btn)
    Button prevBtn;

    MainViewModel mainViewModel;
    private CompositeSubscription compositeSubscription;
    private Adapter adapter;
    private ProgressDialog progressDialog;
    private int page = 1;
    private int previousPage = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        compositeSubscription = new CompositeSubscription();

        initRecylerView();

        mainViewModel = new MainViewModel(this);
        mainViewModel.loadPeopleData(page);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        compositeSubscription.clear();
    }

    private void initRecylerView() {
        adapter = new Adapter();
        peopleRv.setLayoutManager(new LinearLayoutManager(this));
        peopleRv.setAdapter(adapter);
    }

    @Override
    public void displayPeopleData(List<PeopleData> datas) {
        adapter.addItem(datas);
    }

    @Override
    public void setNextPage(String url) {
        page = getNextPageNumber(url);
    }

    @Override
    public void setPreviousPage(String url) {
        previousPage = getNextPageNumber(url);
    }

    @Override
    public void hideLoading() {
        if (progressDialog != null) {
            progressDialog.dismiss();
            progressDialog = null;
        }
    }

    @Override
    public void showLoading() {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(this);
            progressDialog.setMessage("Please wait");
            progressDialog.setCancelable(false);
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();
        }
    }

    @Override
    public void showNextBtn() {
        nextBtn.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideNextBtn() {
        nextBtn.setVisibility(View.GONE);
    }

    @Override
    public void showPreviousBtn() {
        prevBtn.setVisibility(View.VISIBLE);
    }

    @Override
    public void hidePreviousBtn() {
        prevBtn.setVisibility(View.GONE);
    }

    @Override
    public void showError(String message) {
        showSnackBar(message);
    }

    @OnClick(R.id.next_btn)
    void onNextBtnClicked() {
        mainViewModel.loadPeopleData(page);
    }

    @OnClick(R.id.prev_btn)
    void onPrevBtnClicked() {
        mainViewModel.loadPeopleData(previousPage);
    }

    public int getNextPageNumber(String url) {
        if (!url.contains("=")) {
            return 1;
        }
        return Integer.parseInt(url.split("=")[1]);
    }

    private void showSnackBar(String message) {
        Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content),
                message, Snackbar.LENGTH_SHORT);
        View sbView = snackbar.getView();
        TextView textView = (TextView) sbView
                .findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(ContextCompat.getColor(this, R.color.white));
        snackbar.show();
    }
}
