package com.example.tutorialsample.API;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LanguageRequest {
    @SerializedName("texts")
    @Expose
    private List<String> texts = null;
    @SerializedName("tl")
    @Expose
    private String tl;
    @SerializedName("sl")
    @Expose
    private String sl;

    public List<String> getTexts() {
        return texts;
    }

    public void setTexts(List<String> texts) {
        this.texts = texts;
    }

    public String getTl() {
        return tl;
    }

    public void setTl(String tl) {
        this.tl = tl;
    }

    public String getSl() {
        return sl;
    }

    public void setSl(String sl) {
        this.sl = sl;
    }
}
