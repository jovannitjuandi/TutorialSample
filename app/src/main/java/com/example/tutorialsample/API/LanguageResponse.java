package com.example.tutorialsample.API;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LanguageResponse {
    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("texts")
    @Expose
    private List<String> texts = null;
    @SerializedName("tl")
    @Expose
    private String tl;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

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
}
