package Dr_Sideburns.SecretAgentMod;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;
import net.minecraft.entity.item.EntityTNTPrimed;

public class ItemSelfDestruct extends Item {

	public ItemSelfDestruct(int par1) {
		super(par1);
		this.maxStackSize = 1;
		this.setCreativeTab(secretAgentMod.tabSAMod);
	}
	
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		par2World.playSoundAtEntity(par3EntityPlayer, "random.explode", 1.0F, 1.0F);
		
		par2World.createExplosion(null, par3EntityPlayer.posX, par3EntityPlayer.posY, par3EntityPlayer.posZ, 4.0F, true);
		
		par3EntityPlayer.destroyCurrentEquippedItem();
		
		par3EntityPlayer.setHealth(0.0F);
		
		return par1ItemStack;
	}

}
