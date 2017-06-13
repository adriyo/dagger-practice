
package com.adriyo.daggerpractice.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class PeopleData {

    @SerializedName("birth_year")
    private String mBirthYear;
    @SerializedName("created")
    private String mCreated;
    @SerializedName("edited")
    private String mEdited;
    @SerializedName("eye_color")
    private String mEyeColor;
    @SerializedName("films")
    private List<String> mFilms;
    @SerializedName("gender")
    private String mGender;
    @SerializedName("hair_color")
    private String mHairColor;
    @SerializedName("height")
    private String mHeight;
    @SerializedName("homeworld")
    private String mHomeworld;
    @SerializedName("mass")
    private String mMass;
    @SerializedName("name")
    private String mName;
    @SerializedName("skin_color")
    private String mSkinColor;
    @SerializedName("species")
    private List<String> mSpecies;
    @SerializedName("starships")
    private List<String> mStarships;
    @SerializedName("url")
    private String mUrl;
    @SerializedName("vehicles")
    private List<String> mVehicles;

    public String getBirthYear() {
        return mBirthYear;
    }

    public void setBirthYear(String birthYear) {
        mBirthYear = birthYear;
    }

    public String getCreated() {
        return mCreated;
    }

    public void setCreated(String created) {
        mCreated = created;
    }

    public String getEdited() {
        return mEdited;
    }

    public void setEdited(String edited) {
        mEdited = edited;
    }

    public String getEyeColor() {
        return mEyeColor;
    }

    public void setEyeColor(String eyeColor) {
        mEyeColor = eyeColor;
    }

    public List<String> getFilms() {
        return mFilms;
    }

    public void setFilms(List<String> films) {
        mFilms = films;
    }

    public String getGender() {
        return mGender;
    }

    public void setGender(String gender) {
        mGender = gender;
    }

    public String getHairColor() {
        return mHairColor;
    }

    public void setHairColor(String hairColor) {
        mHairColor = hairColor;
    }

    public String getHeight() {
        return mHeight;
    }

    public void setHeight(String height) {
        mHeight = height;
    }

    public String getHomeworld() {
        return mHomeworld;
    }

    public void setHomeworld(String homeworld) {
        mHomeworld = homeworld;
    }

    public String getMass() {
        return mMass;
    }

    public void setMass(String mass) {
        mMass = mass;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getSkinColor() {
        return mSkinColor;
    }

    public void setSkinColor(String skinColor) {
        mSkinColor = skinColor;
    }

    public List<String> getSpecies() {
        return mSpecies;
    }

    public void setSpecies(List<String> species) {
        mSpecies = species;
    }

    public List<String> getStarships() {
        return mStarships;
    }

    public void setStarships(List<String> starships) {
        mStarships = starships;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    public List<String> getVehicles() {
        return mVehicles;
    }

    public void setVehicles(List<String> vehicles) {
        mVehicles = vehicles;
    }

}
