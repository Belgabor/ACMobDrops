package mods.belgabor.acmobdrops;

import com.pam.mobdropcrops.mobdropcrops;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockCrops;
import net.minecraft.init.Items;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Belgabor on 10.05.2016.
 */
public class MobDropPlantCreeper extends MobDropPlantSpecial {
    public MobDropPlantCreeper(boolean bonemeal) {
        super(mobdropcrops.pamcreeperVine, (ItemSeeds) mobdropcrops.creeperseedItem, bonemeal);
    }

    @Override
    public ArrayList<ItemStack> getAllFruits() {
        ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
        ret.add(new ItemStack(Items.gunpowder, 1));
        return ret;
    }

    @Override
    public ItemStack getRandomFruit(Random random) {
        return new ItemStack(Items.gunpowder, 1);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getPlantIcon(int meta) {
        System.out.println(meta);
        switch(meta) {
            case 0:
            case 1:
                return ACMobDrops.blockProxy.iconsCreeper[0];
            case 2:
            case 3:
            case 4:
                return ACMobDrops.blockProxy.iconsCreeper[1];
            case 5:
            case 6:
                return ACMobDrops.blockProxy.iconsCreeper[2];
            case 7:
                return ACMobDrops.blockProxy.iconsCreeper[3];
            default:
                return ACMobDrops.blockProxy.iconsCreeper[meta / 5];
        }
    }
}
