package com.jadencode.main.material;

import com.jadencode.main.constants.MaterialModifiers;
import com.jadencode.main.util.WeightedItem;

import java.awt.*;
import java.util.Arrays;

/**
 * Created by Jaden on 2/4/2015.
 */
public class MaterialModifier implements WeightedItem {
    private final String name;
    private final Color color;
    private final float mod;
    private final float level;
    private final float weight;

    public MaterialModifier(String name, Color color, float mod, float level, float weight, MaterialType... types) {
        this.name = name;
        this.color = color;
        this.mod = mod;
        this.level = level;
        this.weight = weight;
        Arrays.stream(types).forEach(t -> MaterialModifiers.register(t, this));
    }
    public String getName() {
        return name;
    }
    public Color getColor() {
        return color;
    }
    public float getMod() {
        return mod;
    }
    public float getLevel() {
        return level;
    }
    @Override
    public float getWeight() {
        return weight;
    }
}