package com.jadencode.main.generate.item.base;

import java.awt.image.BufferedImage;

/**
 * Created by gtrpl on 6/24/2016.
 */
public class ItemPartType {
    private final String typeName;
    private final BufferedImage icon;

    public ItemPartType(String s, BufferedImage i) {
        this.typeName = s;
        this.icon = i;
    }
    public String getTypeName() {
        return typeName;
    }
    public BufferedImage getIcon() {
        return icon;
    }
}