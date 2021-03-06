package com.jadencode.main.pluginbuilder.modules;

import com.jadencode.main.pluginbuilder.PluginBuilderPanel;
import com.jadencode.main.pluginbuilder.contenteditors.ContentEditor;
import com.jadencode.main.pluginbuilder.contenteditors.MaterialModifierEditor;
import com.jadencode.main.pluginbuilder.contenteditors.WeaponTypeEditor;
import com.jadencode.main.pluginbuilder.items.ItemMaterialModifier;
import com.jadencode.main.pluginbuilder.items.ItemWeaponType;

/**
 * Created by gtrpl on 6/18/2016.
 */
public class ModuleMaterialModifierCreator extends Module<ItemMaterialModifier> {
    private final ContentEditor<ItemMaterialModifier> contentEditor;
    public ModuleMaterialModifierCreator(PluginBuilderPanel parent) {
        super("Material Modifiers");
        this.contentEditor = new MaterialModifierEditor(this, parent);
    }
    @Override
    public ContentEditor<ItemMaterialModifier> getContentEditor() {
        return this.contentEditor;
    }
}