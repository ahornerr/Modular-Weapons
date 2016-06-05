package com.upadvisor.main.material.libraries;

import com.upadvisor.main.material.MaterialBase;
import com.upadvisor.main.material.MaterialLibrary;
import com.upadvisor.main.material.MaterialModifier;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Jaden on 2/10/2015.
 */
public class WoodLibrary extends MaterialLibrary {

    private static final WoodLibrary instance = new WoodLibrary();

    public MaterialBase ash;
    public MaterialBase beech;
    public MaterialBase birch;
    public MaterialBase elm;
    public MaterialBase ebony;
    public MaterialBase holly;
    public MaterialBase hornbeam;
    public MaterialBase juniper;
    public MaterialBase koa;
    public MaterialBase laurel;
    public MaterialBase locust;
    public MaterialBase maple;
    public MaterialBase mesquite;
    public MaterialBase mahogany;
    public MaterialBase oak;
    public MaterialBase palm;
    public MaterialBase snakewood;
    public MaterialBase teak;
    public MaterialBase walnut;
    public MaterialBase yew;
    public MaterialBase zebrawood;

    public MaterialModifier none;
    public MaterialModifier dark;
    public MaterialModifier black;
    public MaterialModifier red;
    public MaterialModifier ancient;
    public MaterialModifier light;
    public MaterialModifier white;
    public MaterialModifier hardy;
    public MaterialModifier polar;

    //x = 0.7(8)/(1-0.7)
    //x =
    private static final List<String> syllablesFirst  = Arrays.asList("Ac", "Za", "Mat", "Ni");
    private static final List<String> syllablesSecond = Arrays.asList("tan", "rop", "cat", "mat");
    private static final List<String> syllablesThird  = Arrays.asList("ta", "in", "or", "za");

    private WoodLibrary() {
        super("Wood");
    }

    @Override
    public void loadMaterials() {

//        this.ash       = new MaterialBase(MaterialLibrary.getWoodLibrary(), "Ash", Colors.WOOD_ASH, 1F, 1);
//        this.beech     = new MaterialBase(MaterialLibrary.getWoodLibrary(), "Beech", Colors.WOOD_BEECH, 1F, 4);
//        this.birch     = new MaterialBase(MaterialLibrary.getWoodLibrary(), "Birch", Colors.WOOD_BIRCH, 1F, 9);
//        this.elm       = new MaterialBase(MaterialLibrary.getWoodLibrary(), "Elm", Colors.WOOD_ELM, 1F, 12);
//        this.ebony     = new MaterialBase(MaterialLibrary.getWoodLibrary(), "Ebony", Colors.WOOD_EBONY, 1F, 15);
//        this.holly     = new MaterialBase(MaterialLibrary.getWoodLibrary(), "Holly", Colors.WOOD_HOLLY, 1F, 18);
//        this.hornbeam  = new MaterialBase(MaterialLibrary.getWoodLibrary(), "Hornbeam", Colors.WOOD_HORNBEAM, 1F, 21);
//        this.juniper   = new MaterialBase(MaterialLibrary.getWoodLibrary(), "Juniper", Colors.WOOD_JUNIPER, 1F, 24);
//        this.koa       = new MaterialBase(MaterialLibrary.getWoodLibrary(), "Koa", Colors.WOOD_KOA, 1F, 27);
//        this.laurel    = new MaterialBase(MaterialLibrary.getWoodLibrary(), "Laurel", Colors.WOOD_LAUREL, 1F, 30);
//        this.locust    = new MaterialBase(MaterialLibrary.getWoodLibrary(), "Locust", Colors.WOOD_LOCUST, 1F, 33);
//        this.maple     = new MaterialBase(MaterialLibrary.getWoodLibrary(), "Maple", Colors.WOOD_MAPLE, 1F, 36);
//        this.mesquite  = new MaterialBase(MaterialLibrary.getWoodLibrary(), "Mesquite", Colors.WOOD_MESQUITE, 1F, 39);
//        this.mahogany  = new MaterialBase(MaterialLibrary.getWoodLibrary(), "Mahogany", Colors.WOOD_MAHOGANY, 1F, 42);
//        this.oak       = new MaterialBase(MaterialLibrary.getWoodLibrary(), "Oak", Colors.WOOD_OAK, 1F, 45);
//        this.palm      = new MaterialBase(MaterialLibrary.getWoodLibrary(), "Palm", Colors.WOOD_PALM, 1F, 48);
//        this.snakewood = new MaterialBase(MaterialLibrary.getWoodLibrary(), "Snakewood", Colors.WOOD_SNAKEWOOD, 1F, 51);
//        this.teak      = new MaterialBase(MaterialLibrary.getWoodLibrary(), "Teak", Colors.WOOD_TEAK, 1F, 54);
//        this.walnut    = new MaterialBase(MaterialLibrary.getWoodLibrary(), "Walnut", Colors.WOOD_WALNUT, 1F, 57);
//        this.yew       = new MaterialBase(MaterialLibrary.getWoodLibrary(), "Yew", Colors.WOOD_YEW, 1F, 60);
//        this.zebrawood = new MaterialBase(MaterialLibrary.getWoodLibrary(), "Zebrawood", Colors.WOOD_ZEBRAWOOD, 1F, 63);
//
//        this.none    = new MaterialModifier(MaterialLibrary.getWoodLibrary(), "", null, 24F).setLevelMod(1F);
//        this.dark    = new MaterialModifier(MaterialLibrary.getWoodLibrary(), "Dark", Colors.WOOD_MOD_DARK, 1F).setLevelMod(1.2F);
//        this.black   = new MaterialModifier(MaterialLibrary.getWoodLibrary(), "Black", Colors.WOOD_MOD_BLACK, 1F).setLevelMod(1.5F);
//        this.red     = new MaterialModifier(MaterialLibrary.getWoodLibrary(), "Red", Colors.WOOD_MOD_RED, 1F).setLevelMod(2.8F);
//        this.ancient = new MaterialModifier(MaterialLibrary.getWoodLibrary(), "Ancient", Colors.WOOD_MOD_ANCIENT, 1F).setLevelMod(2F);
//        this.light   = new MaterialModifier(MaterialLibrary.getWoodLibrary(), "Light", Colors.WOOD_MOD_LIGHT, 1F).setLevelMod(3.5F);
//        this.white   = new MaterialModifier(MaterialLibrary.getWoodLibrary(), "White", Colors.WOOD_MOD_WHITE, 1F).setLevelMod(0.8F);
//        this.hardy   = new MaterialModifier(MaterialLibrary.getWoodLibrary(), "Hardy", Colors.WOOD_MOD_HARDY, 1F).setLevelMod(3F);
//        this.polar   = new MaterialModifier(MaterialLibrary.getWoodLibrary(), "Polar", Colors.WOOD_MOD_POLAR, 1F).setLevelMod(2.2F);

//        for (String s1 : syllablesFirst) {
//            for (String s2 : syllablesSecond) {
//                for (String s3 : syllablesThird) {
//                    String name = s1 + s2 + s3;
//                    long hash = name.hashCode();
//                    long seed = Main.theWorld.getSeed();
//                    long code = hash % seed;
//
//                    int r = 110 + ((int)Math.abs(code % s1.hashCode()) & 255) & 255;
//                    int g = 60 + ((int)Math.abs(code % s2.hashCode()) & 150) & 255;
//                    int b = 0;
//
//                    int level = (int)Math.abs((code % 41)) + 20;
//
//                    Color c = new Color(r, g, b);
//                    float weight = (float)(hash % 5 + 1) / 5F;
//
//                    float str = (float) (code % 20) / 10F;
//                    float rng = (float) ((code + 7) % 20) / 10F;
//                    float wkn = (float) Math.pow(str * rng, -1F);
//
//                    MaterialBase base = new MaterialBase(MaterialLibrary.getWoodLibrary(), name, c, weight, str, rng, wkn, level);
//                }
//            }
//        }
    }
    public static WoodLibrary getInstance() {
        return instance;
    }
}
