package mods.belgabor.acmobdrops;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Belgabor on 10.05.2016.
 */
public abstract class MobDropPlantSpecial extends MobDropPlant {
    protected Block special_crop;

    public MobDropPlantSpecial(Block crop, ItemSeeds seed) {
        super(null, seed);
        this.special_crop = crop;
    }

    @Override
    public Block getBlock() {
        return this.special_crop;
    }

    @Override
    abstract public ArrayList<ItemStack> getAllFruits();

    @Override
    abstract public ItemStack getRandomFruit(Random random);

    @Override
    public ArrayList<ItemStack> getFruitsOnHarvest(int gain, Random rand) {
        int amount = (int)Math.ceil(((double)gain + 0.0D) / 3.0D);

        ArrayList list;
        for(list = new ArrayList(); amount > 0; --amount) {
            list.add(this.getRandomFruit(rand));
        }

        return list;
    }

    @Override
    abstract public IIcon getPlantIcon(int meta);
}
