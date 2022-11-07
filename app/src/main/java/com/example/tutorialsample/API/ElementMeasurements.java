
package com.example.tutorialsample.API;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ElementMeasurements {

    @SerializedName("Height")
    @Expose
    private Double height;

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

}
