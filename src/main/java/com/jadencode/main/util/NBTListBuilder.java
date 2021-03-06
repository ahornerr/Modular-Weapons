package com.jadencode.main.util;


import com.jadencode.main.nbt.NBTBase;
import com.jadencode.main.nbt.NBTTagList;

/**
 * Created by Jaden on 6/29/2014.
 */
public class NBTListBuilder
{
    private NBTTagList nbtTagList;

    public NBTListBuilder() {
        this.nbtTagList = new NBTTagList();
    }

    public NBTListBuilder(NBTTagList list) {
        this.nbtTagList = list;
    }
    public NBTTagList get()
    {
        return this.nbtTagList;
    }
    public NBTListBuilder append(NBTBase nbt)
    {
        this.nbtTagList.appendTag(nbt);
        return this;
    }
}