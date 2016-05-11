package mods.belgabor.acmobdrops;

import com.InfinityRaider.AgriCraft.api.API;
import com.InfinityRaider.AgriCraft.api.APIBase;
import com.InfinityRaider.AgriCraft.api.v2.APIv2;
import com.pam.mobdropcrops.mobdropcrops;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import mods.belgabor.acmobdrops.proxy.CommonProxy;
import net.minecraft.block.BlockCrops;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

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

    public static int cfgCropsTier;
    public static boolean cfgBonemealCrops;
    public static boolean cfgBonemealBonecrop;

    @EventHandler
    public static void preInit(FMLPreInitializationEvent event) {
        GameRegistry.registerBlock(blockProxy, "texproxy");
        loadConfiguration(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {

        proxy.hideItemInNEI(new ItemStack(blockProxy));

        APIBase base = API.getAPI(2);
        if (base.getStatus().isOK() && (base.getVersion() == 2)) {
            acapi = (APIv2) base;
            acapi.registerCropPlant(new MobDropPlant((BlockCrops) mobdropcrops.pamblazeCrop, (ItemSeeds) mobdropcrops.blazeseedItem, cfgBonemealCrops));
            acapi.registerCropPlant(new MobDropPlant((BlockCrops) mobdropcrops.pamboneCrop, (ItemSeeds) mobdropcrops.boneseedItem, cfgBonemealBonecrop));
            acapi.registerCropPlant(new MobDropPlant((BlockCrops) mobdropcrops.pamenderCrop, (ItemSeeds) mobdropcrops.enderseedItem, cfgBonemealCrops));
            acapi.registerCropPlant(new MobDropPlant((BlockCrops) mobdropcrops.pameyeCrop, (ItemSeeds) mobdropcrops.eyeseedItem, cfgBonemealCrops));
            acapi.registerCropPlant(new MobDropPlant((BlockCrops) mobdropcrops.pamrottenCrop, (ItemSeeds) mobdropcrops.rottenseedItem, cfgBonemealCrops));
            acapi.registerCropPlant(new MobDropPlant((BlockCrops) mobdropcrops.pamtearCrop, (ItemSeeds) mobdropcrops.tearseedItem, cfgBonemealCrops));
            acapi.registerCropPlant(new MobDropPlantCreeper(cfgBonemealCrops));
            acapi.registerCropPlant(new MobDropPlantSlime(cfgBonemealCrops));
        }

    }

    private static void loadConfiguration(FMLPreInitializationEvent event) {
        Configuration cfg = new Configuration(new File(event.getModConfigurationDirectory().toString() + '/', "ACMobDrops.cfg"));
        cfg.load();

        cfgCropsTier = cfg.getInt("Crop Tier", "general", 3, 1, 5, "Tier of all crops");
        cfgBonemealCrops = cfg.getBoolean("Bonemeal Crops", "general", true, "Determines if crops (except bone) can be bonemealed");
        cfgBonemealBonecrop = cfg.getBoolean("Bonemeal Bone Crop", "general", true, "Determines if the bone crop can be bonemealed");

        if(cfg.hasChanged()) {
            cfg.save();
        }

    }
}
