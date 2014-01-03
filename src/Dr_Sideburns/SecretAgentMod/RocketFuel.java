package Dr_Sideburns.SecretAgentMod;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class RocketFuel extends Item {
	
	public RocketFuel(int par1) {
		super(par1);
		this.maxStackSize = 64;
		this.setCreativeTab(secretAgentMod.tabSAMod);
	}
	
}

