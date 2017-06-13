
package com.adriyo.daggerpractice.network;

import com.adriyo.daggerpractice.data.PeopleData;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class PeopleResponse {

    @SerializedName("count")
    private Long mCount;
    @SerializedName("next")
    private String mNext;
    @SerializedName("previous")
    private String mPrevious;
    @SerializedName("results")
    private List<PeopleData> mPeopleDatas;

    public Long getCount() {
        return mCount;
    }

    public void setCount(Long count) {
        mCount = count;
    }

    public String getNext() {
        return mNext;
    }

    public void setNext(String next) {
        mNext = next;
    }

    public String getPrevious() {
        return mPrevious;
    }

    public void setPrevious(String previous) {
        mPrevious = previous;
    }

    public List<PeopleData> getResults() {
        return mPeopleDatas;
    }

    public void setResults(List<PeopleData> peopleDatas) {
        mPeopleDatas = peopleDatas;
    }

}
