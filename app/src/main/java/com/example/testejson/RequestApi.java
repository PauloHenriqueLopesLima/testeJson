package com.example.testejson;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RequestApi {

@SerializedName("id")
@Expose
private String id;
@SerializedName("type")
@Expose
private String type;
@SerializedName("name")
@Expose
private String name;
@SerializedName("ppu")
@Expose
private Float ppu;
@SerializedName("batters")
@Expose
private Batters batters;
@SerializedName("topping")
@Expose
private List<Topping> topping = null;

public String getId() {
return id;
}

public void setId(String id) {
this.id = id;
}

public String getType() {
return type;
}

public void setType(String type) {
this.type = type;
}

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public Float getPpu() {
return ppu;
}

public void setPpu(Float ppu) {
this.ppu = ppu;
}

public Batters getBatters() {
return batters;
}

public void setBatters(Batters batters) {
this.batters = batters;
}

public List<Topping> getTopping() {
return topping;
}

public void setTopping(List<Topping> topping) {
this.topping = topping;
}

}