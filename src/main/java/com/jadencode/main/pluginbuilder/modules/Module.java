package com.jadencode.main.pluginbuilder.modules;

import com.jadencode.main.pluginbuilder.contenteditors.ContentEditor;
import com.jadencode.main.pluginbuilder.items.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by gtrpl on 6/18/2016.
 */
public abstract class Module<T extends Item> {
    private final List<String> itemKeys = new ArrayList<>();
    private final HashMap<String, T> items = new HashMap<>();
    private final String name;

    public Module(String name) {
        this.name = name;
    }
    public abstract ContentEditor<T> getContentEditor();
    public String getName() {
        return this.name;
    }
    public T getItem(String name) {
        return this.items.get(name);
    }
    public void addItem(String name) {
        if(!this.itemKeys.contains(name)) {
            T item = this.createItem(name);
            this.items.put(name, item);
            this.itemKeys.add(name);
            this.itemKeys.sort(null);
        }
    }
    public void remove(String name) {
        this.items.remove(name);
        this.itemKeys.remove(name);
        this.itemKeys.sort(null);
    }
    public List<String> getItemKeys() {
        return this.itemKeys;
    }
    public HashMap<String, T> getItems() {
        return this.items;
    }
    @Override
    public String toString() {
        return this.getName();
    }
    public T createItem(String name) {
        return this.getContentEditor().createItem(name);
    }
}