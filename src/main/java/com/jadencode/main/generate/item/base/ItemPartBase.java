package com.jadencode.main.generate.item.base;

import com.jadencode.main.material.Material;
import com.jadencode.main.material.MaterialType;
import com.jadencode.main.stat.StatSet;

import java.awt.image.BufferedImage;
import java.util.List;

/**
 * Created by gtrpl on 6/24/2016.
 */
public class ItemPartBase {
    private final ItemPartType       partType;
    private final String             partName;
    private final String             partInfo;
    private final String             nameMod;
    private final List<MaterialType> materials;
    private final float              weight;
    private final StatSet            statSet;
    private final BufferedImage      icon;

    public ItemPartBase(String name, String mod, String info, float weight, StatSet stats, ItemPartType type, BufferedImage icon, List<MaterialType> mats) {
        this.partName = name;
        this.nameMod = mod;
        this.partInfo = info;
        this.weight = weight;

        this.statSet = stats;
        this.partType = type;
        this.icon = icon;
        this.materials = mats;
    }
    public ItemPartType getPartType() {
        return partType;
    }
    public String getPartName() {
        return partName;
    }
    public String getPartInfo() {
        return partInfo;
    }
    public String getNameMod() {
        return nameMod;
    }
    public List<MaterialType> getMaterials() {
        return materials;
    }
    public float getWeight() {
        return weight;
    }
    public StatSet getStatSet() {
        return statSet;
    }
    public BufferedImage getIcon() {
        return this.icon;
    }

    public StatSet modifyStats(Material resource) {
        return this.getStatSet().modified(resource);
    }
}
