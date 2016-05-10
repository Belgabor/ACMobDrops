package mods.belgabor.acmobdrops;

import com.pam.mobdropcrops.mobdropcrops;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.init.Items;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Belgabor on 10.05.2016.
 */
public class MobDropPlantSlime extends MobDropPlantSpecial {
    public MobDropPlantSlime() {
        super(mobdropcrops.pamslimepadCrop, (ItemSeeds) mobdropcrops.slimeseedItem);
    }

    @Override
    public ArrayList<ItemStack> getAllFruits() {
        ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
        ret.add(new ItemStack(Items.slime_ball, 1));
        return ret;
    }

    @Override
    public ItemStack getRandomFruit(Random random) {
        return new ItemStack(Items.slime_ball, 1);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getPlantIcon(int meta) {
        switch(meta) {
            case 0:
            case 1:
                return ACMobDrops.blockProxy.iconsSlime[0];
            case 2:
            case 3:
            case 4:
                return ACMobDrops.blockProxy.iconsSlime[1];
            case 5:
            case 6:
                return ACMobDrops.blockProxy.iconsSlime[2];
            case 7:
                return ACMobDrops.blockProxy.iconsSlime[3];
            default:
                return ACMobDrops.blockProxy.iconsSlime[meta / 5];
        }
    }
}
