package com.adriyo.daggerpractice.ui;

import com.adriyo.daggerpractice.BaseApplication;
import com.adriyo.daggerpractice.data.PeopleData;
import com.adriyo.daggerpractice.network.Repository;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by adriyo on 13/06/17.
 * adriyo.github.io
 */

public class MainViewModel {

    @Inject
    protected Repository repository;

    MainView mainView;

    MainViewModel(MainView mainView) {
        this.mainView = mainView;
        BaseApplication.getBaseApplication().getDataComponent().inject(this);
    }

    void loadPeopleData(int page) {
        mainView.showLoading();

        HashMap<String, Integer> params = new HashMap<>();
        params.put("page", page);

        repository.getPeopleData(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        peopleResponse -> {
                            mainView.hideLoading();
                            if (peopleResponse.getNext() == null) {
                                mainView.hideNextBtn();
                                mainView.setPreviousPage(peopleResponse.getPrevious());
                            }

                            if (peopleResponse.getPrevious() == null) {
                                mainView.hidePreviousBtn();
                                mainView.setNextPage(peopleResponse.getNext());
                            }

                            if (peopleResponse.getNext() != null
                                    && peopleResponse.getPrevious() == null) {
                                mainView.setNextPage(peopleResponse.getNext());
                                mainView.showNextBtn();
                                mainView.hidePreviousBtn();
                            }

                            if (peopleResponse.getPrevious() != null
                                    && peopleResponse.getNext() == null) {
                                mainView.showPreviousBtn();
                                mainView.hideNextBtn();
                                mainView.setPreviousPage(peopleResponse.getPrevious());
                            }

                            if (peopleResponse.getPrevious() != null
                                    && peopleResponse.getNext() != null) {
                                mainView.showNextBtn();
                                mainView.showPreviousBtn();
                                mainView.setPreviousPage(peopleResponse.getPrevious());
                                mainView.setNextPage(peopleResponse.getNext());
                            }

                            mainView.displayPeopleData(peopleResponse.getResults());
                        },
                        throwable -> {
                            mainView.hideLoading();
                            mainView.showError(throwable.toString());
                        }
                );
    }

    public interface MainView {
        void displayPeopleData(List<PeopleData> datas);

        void setNextPage(String url);

        void hideLoading();

        void showLoading();

        void showNextBtn();

        void hideNextBtn();

        void showPreviousBtn();

        void hidePreviousBtn();

        void setPreviousPage(String url);

        void showError(String message);
    }
}
