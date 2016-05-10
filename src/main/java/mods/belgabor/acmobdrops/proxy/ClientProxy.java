package mods.belgabor.acmobdrops.proxy;

import codechicken.nei.api.API;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.ModContainer;
import net.minecraft.item.ItemStack;

import java.util.Iterator;

/**
 * Created by Belgabor on 10.05.2016.
 */
public class ClientProxy extends CommonProxy {
    @Override
    public void hideItemInNEI(ItemStack stack) {
        Iterator mods = Loader.instance().getActiveModList().iterator();

        while(mods.hasNext()) {
            ModContainer modContainer = (ModContainer)mods.next();
            if(modContainer.getModId().equalsIgnoreCase("NotEnoughItems")) {
                API.hideItem(stack);
            }
        }

    }
}
