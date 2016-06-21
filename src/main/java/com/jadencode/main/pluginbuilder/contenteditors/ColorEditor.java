package com.jadencode.main.pluginbuilder.contenteditors;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.jadencode.main.pluginbuilder.PluginBuilderPanel;
import com.jadencode.main.pluginbuilder.items.ItemColor;
import com.jadencode.main.pluginbuilder.modules.Module;

import javax.swing.*;
import java.awt.*;

/**
 * Created by gtrpl on 6/18/2016.
 */
public class ColorEditor extends ContentEditor<ItemColor> {

    private final JButton selectColor;
    private Color color = Color.WHITE;
    private final JPanel displayPanel;
    public ColorEditor(Module module, PluginBuilderPanel parent) {
        super(module, parent);

        this.displayPanel = this.create(new JPanel(), "Color Display", 220, 10, 200, 200);
        this.displayPanel.setBackground(this.color);

        this.selectColor = this.create(new JButton("Select Color"), 10, 150, 200, 40);
        this.selectColor.addActionListener(e -> {
            Color c = this.color;
            this.color = JColorChooser.showDialog(null, "Select a Color", this.color);
            if(this.color == null) {
                this.color = c;
            }
            this.displayPanel.setBackground(this.color);
        });
    }
    @Override
    public void populate(ItemColor item) {
        this.color = new Color(item.red, item.green, item.blue);
        this.displayPanel.setBackground(this.color);
    }
    @Override
    public ItemColor createItem(String name, String owner) {
        return new ItemColor(name, owner, this.color.getRed(), this.color.getGreen(), this.color.getBlue());
    }
    @Override
    public ItemColor getDefault() {
        return new ItemColor("", "", 255, 255, 255);
    }

    @Override
    public ItemColor consume(String name, JsonObject json, String owner) {
        JsonArray rgb = json.get("rgb").getAsJsonArray();
        return new ItemColor(name, owner, rgb.get(0).getAsInt(), rgb.get(1).getAsInt(), rgb.get(2).getAsInt());
    }
}