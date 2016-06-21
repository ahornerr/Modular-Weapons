package com.jadencode.main.pluginbuilder.contenteditors;

import com.google.gson.JsonObject;
import com.jadencode.main.pluginbuilder.PluginBuilderPanel;
import com.jadencode.main.pluginbuilder.items.Item;
import com.jadencode.main.pluginbuilder.items.ItemScript;
import com.jadencode.main.pluginbuilder.modules.Module;
import com.sun.webkit.plugin.Plugin;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by gtrpl on 6/18/2016.
 */
public abstract class ContentEditor<T extends Item> extends JPanel {
    private final JTextField nameField;
    private final JButton updateItem;
    private final JButton deleteItem;

    public ContentEditor(Module<T> parent, PluginBuilderPanel panel) {
        this.setLayout(null);
        this.setBackground(Color.LIGHT_GRAY);
        this.setLocation(430, 10);
        this.setSize(1000, 700);

        this.nameField = this.create(new JTextField(), "Item Name", 10, 10, 200, 18);
        this.updateItem = this.create(new JButton("Update Item"), 10, 50, 200, 40);
        this.deleteItem = this.create(new JButton("Delete Item"), 10, 100, 200, 40);

        this.updateItem.addActionListener(e -> {
            String itemName = this.nameField.getText();
            if(itemName != null && !itemName.isEmpty()) {
                parent.addItem(itemName, panel.getActivePlugin());
                panel.updateCurrentObjects(itemName);
            }
        });
        this.deleteItem.addActionListener(e -> {
            String itemName = this.nameField.getText();
            parent.remove(itemName);
            panel.updateCurrentObjects(null);
        });
    }
    public List<String> getScripts(String type, PluginBuilderPanel panel) {
        Module<? extends Item> scriptsModule = panel.getModule("Scripts");
        List<String> scripts = new ArrayList<>();
        for (String key : scriptsModule.getItemKeys()) {
            String scriptType = ((ItemScript) scriptsModule.getItem(key)).getScriptType();
            if(type.equals(scriptType)) scripts.add(key);
        }
        scripts.add("");
        return scripts;
    }
    public void onOpened(Module<T> parent, PluginBuilderPanel panel) {

    }
    public void setName(String name) {
        this.nameField.setText(name);
    }
    public <T extends JComponent> T create(T component, int x, int y, int w, int h) {
        component.setLocation(x, y);
        component.setSize(w, h);
        this.add(component);
        return component;
    }
    public <T extends JComponent> T create(T component, String title, int x, int y, int w, int h) {
        JLabel label = new JLabel(title);
        label.setLocation(x, y);
        label.setSize(w, 18);
        this.add(label);
        return this.create(component, x, y + 20, w, h);
    }
    public <T extends JComponent> T createScrolling(T component, int x, int y, int w, int h) {
        JScrollPane pane = new JScrollPane(component);
        pane.setLocation(x, y);
        pane.setSize(w, h);
        this.add(pane);
        return component;
    }
    public <T extends JComponent> T createScrolling(T component, String title, int x, int y, int w, int h) {
        JLabel label = new JLabel(title);
        label.setLocation(x, y);
        label.setSize(w, 18);
        this.add(label);
        return this.createScrolling(component, x, y + 20, w, h);
    }
    public abstract T createItem(String name, String owner);
    public abstract void populate(T item);
    public abstract T getDefault();
    public abstract T consume(String name, JsonObject json, String owner);
}
