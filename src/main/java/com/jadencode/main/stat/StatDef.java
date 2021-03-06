package com.jadencode.main.stat;

import com.jadencode.main.scripts.ScriptStat;
import com.jadencode.main.material.Material;

/**
 * Created by gtrpl on 6/5/2016.
 */
public class StatDef implements StatBase {
    
    private final double defaultValue;
    private final String statName;
    private final ScriptStat script;

    public StatDef(String s, double val, ScriptStat script) {
        this.defaultValue = val;
        this.statName = s;
        this.script = script;
    }
    @Override
    public double getDefaultValue() {
        return this.defaultValue;
    }
    @Override
    public String getStatName() {
        return this.statName;
    }
    @Override
    public double modify(Material resource, double original) {
        return original * resource.getMultiplier();
    }
    @Override
    public double combine(double first, double second) {
        return this.script.combine(first, second);
    }
    @Override
    public double scale(int i, double original) {
        return this.script.scale(i, original);
    }
}
