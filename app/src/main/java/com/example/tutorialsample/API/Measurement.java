
package com.example.tutorialsample.API;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Measurement {

    @SerializedName("elementName")
    @Expose
    private String elementName;
    @SerializedName("elementDescription")
    @Expose
    private Object elementDescription;
    @SerializedName("elementMeasurements")
    @Expose
    private ElementMeasurements elementMeasurements;

    public String getElementName() {
        return elementName;
    }

    public void setElementName(String elementName) {
        this.elementName = elementName;
    }

    public Object getElementDescription() {
        return elementDescription;
    }

    public void setElementDescription(Object elementDescription) {
        this.elementDescription = elementDescription;
    }

    public ElementMeasurements getElementMeasurements() {
        return elementMeasurements;
    }

    public void setElementMeasurements(ElementMeasurements elementMeasurements) {
        this.elementMeasurements = elementMeasurements;
    }

}
