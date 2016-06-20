package com.jadencode.main.pluginbuilder.items;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.jadencode.main.pluginbuilder.JsonHelper;

import java.util.List;

/**
 * Created by gtrpl on 6/19/2016.
 */
public class ItemWeaponPart extends Item {

    private final String nameMod;
    private final String partInfo;
    private final float weight;
    private final String partType;
    private final List<String> materialTypes;

    public ItemWeaponPart(String name, String nameMod, String partInfo, float weight, String partType, List<String> materialTypes) {
        super(name);
        this.nameMod = nameMod;
        this.partInfo = partInfo;
        this.weight = weight > 0 ? weight : 1F;
        this.partType = partType;
        this.materialTypes = materialTypes;
    }
    public String getNameMod() {
        return nameMod;
    }
    public String getPartInfo() {
        return partInfo;
    }
    public float getWeight() {
        return weight;
    }
    public String getPartType() {
        return partType;
    }
    public List<String> getMaterialTypes() {
        return materialTypes;
    }
    @Override
    public void toJson(JsonObject json) {
        JsonHelper helper = new JsonHelper(json)
                .add("nameMod", this.nameMod)
                .add("partInfo", this.partInfo)
                .add("weight", this.weight)
                .add("partType", this.partType)
                .addNotEmpty("materials", JsonHelper.toArray(this.materialTypes));
    }
}