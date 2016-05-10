package mods.belgabor.acmobdrops;

import com.InfinityRaider.AgriCraft.api.API;
import com.InfinityRaider.AgriCraft.api.APIBase;
import com.InfinityRaider.AgriCraft.api.v2.APIv2;
import com.pam.mobdropcrops.mobdropcrops;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.registry.GameRegistry;
import mods.belgabor.acmobdrops.proxy.CommonProxy;
import net.minecraft.block.BlockCrops;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;

@Mod(modid = ACMobDrops.MODID, version = ACMobDrops.VERSION, name="AgriCraft Mob Drop Crops", dependencies = "required-after:mobdropcrops;required-after:AgriCraft")
public class ACMobDrops
{
    public static final String MODID = "acmobdrops";
    public static final String VERSION = "0.1";

    @SidedProxy(
            clientSide = "mods.belgabor.acmobdrops.proxy.ClientProxy",
            serverSide = "mods.belgabor.acmobdrops.proxy.CommonProxy"
    )
    public static CommonProxy proxy;

    public static APIv2 acapi;

    public static final BlockProxy blockProxy = new BlockProxy();
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        GameRegistry.registerBlock(blockProxy, "texproxy");

        proxy.hideItemInNEI(new ItemStack(blockProxy));

        APIBase base = API.getAPI(2);
        if (base.getStatus().isOK() && (base.getVersion() == 2)) {
            acapi = (APIv2) base;
            acapi.registerCropPlant(new MobDropPlant((BlockCrops) mobdropcrops.pamblazeCrop, (ItemSeeds) mobdropcrops.blazeseedItem));
            acapi.registerCropPlant(new MobDropPlant((BlockCrops) mobdropcrops.pamboneCrop, (ItemSeeds) mobdropcrops.boneseedItem));
            acapi.registerCropPlant(new MobDropPlant((BlockCrops) mobdropcrops.pamenderCrop, (ItemSeeds) mobdropcrops.enderseedItem));
            acapi.registerCropPlant(new MobDropPlant((BlockCrops) mobdropcrops.pameyeCrop, (ItemSeeds) mobdropcrops.eyeseedItem));
            acapi.registerCropPlant(new MobDropPlant((BlockCrops) mobdropcrops.pamrottenCrop, (ItemSeeds) mobdropcrops.rottenseedItem));
            acapi.registerCropPlant(new MobDropPlant((BlockCrops) mobdropcrops.pamtearCrop, (ItemSeeds) mobdropcrops.tearseedItem));
            acapi.registerCropPlant(new MobDropPlantCreeper());
            acapi.registerCropPlant(new MobDropPlantSlime());
        }

    }
}
