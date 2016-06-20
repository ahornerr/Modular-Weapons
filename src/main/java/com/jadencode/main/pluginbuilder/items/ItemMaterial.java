package com.jadencode.main.pluginbuilder.items;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

import java.util.List;

/**
 * Created by gtrpl on 6/19/2016.
 */
public class ItemMaterial extends Item {

//    "name": "Iron", "color": "METAL_IRON", "weight": 32.0, "mod": 1.0, "level": 0, "material": "Metal"
    private final String colorName;
    private final float weight;
    private final float mod;
    private final int level;
    private final String materialType;

    public ItemMaterial(String name, String color, float w, float m, int l, String type) {
        super(name);
        this.colorName = color;
        this.weight = w;
        this.mod = m;
        this.level = l;
        this.materialType = type;
    }
    public String getColorName() {
        return colorName;
    }
    public float getWeight() {
        return weight;
    }
    public float getMod() {
        return mod;
    }
    public int getLevel() {
        return level;
    }

    public String getMaterialType() {
        return materialType;
    }
    @Override
    public void toJson(JsonObject json) {
        json.add("color", new JsonPrimitive(this.colorName));
        json.add("weight", new JsonPrimitive(this.weight));
        json.add("mod", new JsonPrimitive(this.mod));
        json.add("level", new JsonPrimitive(this.level));
        json.add("material", new JsonPrimitive(this.materialType));
    }
}