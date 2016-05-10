package mods.belgabor.acmobdrops;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

/**
 * Created by Belgabor on 10.05.2016.
 */
public class BlockProxy extends Block {
    @SideOnly(Side.CLIENT)
    public IIcon[] iconsCreeper;
    @SideOnly(Side.CLIENT)
    public IIcon[] iconsSlime;

    protected BlockProxy() {
        super(Material.ground);
        this.setBlockName("texproxy");
    }
    @Override
    public String getUnlocalizedName()
    {
        return "tile.acmobdrops:texproxy";
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        this.iconsCreeper = new IIcon[4];
        this.iconsSlime = new IIcon[4];

        for(int i = 1; i < this.iconsCreeper.length + 1; ++i) {
            this.iconsCreeper[i - 1] = iconRegister.registerIcon("acmobdrops:cropCreeper" + i);
        }
        for(int i = 1; i < this.iconsSlime.length + 1; ++i) {
            this.iconsSlime[i - 1] = iconRegister.registerIcon("acmobdrops:cropSlime" + i);
        }
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
}
