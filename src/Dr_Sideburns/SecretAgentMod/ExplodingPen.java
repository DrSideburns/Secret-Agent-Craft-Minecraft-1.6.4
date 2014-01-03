package Dr_Sideburns.SecretAgentMod;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;

public class ExplodingPen extends Item {

	public ExplodingPen(int par1) {
		super(par1);
		this.maxStackSize = 1;
		this.setCreativeTab(secretAgentMod.tabSAMod);
	}
	
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		par2World.playSoundAtEntity(par3EntityPlayer, "random.explode", 1.0F, 1.0F);
		
		par2World.createExplosion(null, par3EntityPlayer.posX, par3EntityPlayer.posY, par3EntityPlayer.posZ, 1.0F, false);
		
		if(!par3EntityPlayer.capabilities.isCreativeMode)
		{
		par3EntityPlayer.destroyCurrentEquippedItem();
		}
		
		return par1ItemStack;
	}

}