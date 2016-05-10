package mods.belgabor.acmobdrops;

import com.InfinityRaider.AgriCraft.api.v1.BlockWithMeta;
import com.InfinityRaider.AgriCraft.api.v1.IAgriCraftPlant;
import com.InfinityRaider.AgriCraft.api.v1.IGrowthRequirement;
import com.InfinityRaider.AgriCraft.farming.cropplant.CropPlantVanilla;
import net.minecraft.block.BlockCrops;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSeeds;

/**
 * Created by Belgabor on 10.05.2016.
 */
public class MobDropPlant extends CropPlantVanilla {

    public MobDropPlant(BlockCrops crop, ItemSeeds seed) {
        super(crop, seed);
    }

    @Override
    protected IGrowthRequirement initGrowthRequirement() {
        return ACMobDrops.acapi.createGrowthRequirementBuilder().soil(new BlockWithMeta(Blocks.soul_sand)).build();
    }

    @Override
    public int tier() {return 3;}
}
