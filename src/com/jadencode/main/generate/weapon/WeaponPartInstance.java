package com.upadvisor.main.generate.weapon;

import com.upadvisor.main.item.StatSet;

/**
 * Created by Jaden on 6/15/2015.
 */
public class WeaponPartInstance {
    private final WeaponPart weaponPart;
    private final int        level;
    private final StatSet    statSet;

    public WeaponPartInstance(WeaponPart part, int l) {
        this.weaponPart = part;
        this.level = l;

        this.statSet = this.getWeaponPart().getBaseWeaponPart().scaleStats(this);
    }
    public WeaponPartInstance scaledInstance(int i) {
        WeaponPartInstance scaled = new WeaponPartInstance(this.weaponPart, i);
        return scaled;
    }

    public int getLevel() {
        return level;
    }

    public WeaponPart getWeaponPart() {
        return weaponPart;
    }
    public StatSet getStatSet() {
        return this.statSet;
    }
    public String getPartInfo() {
        return String.format("%s (Level %d)", this.getWeaponPart().getPartInfo(), this.getLevel());
    }
}