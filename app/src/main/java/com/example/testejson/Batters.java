package com.example.testejson;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Batters {

@SerializedName("batter")
@Expose
private List<Batter> batter = null;

public List<Batter> getBatter() {
return batter;
}

public void setBatter(List<Batter> batter) {
this.batter = batter;
}

}