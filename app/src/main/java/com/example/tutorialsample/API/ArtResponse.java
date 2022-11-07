
package com.example.tutorialsample.API;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ArtResponse {

    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("objectIDs")
    @Expose
    private List<Integer> objectIDs = null;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<Integer> getObjectIDs() {
        return objectIDs;
    }

    public void setObjectIDs(List<Integer> objectIDs) {
        this.objectIDs = objectIDs;
    }

}
