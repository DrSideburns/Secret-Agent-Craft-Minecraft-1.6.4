package Dr_Sideburns.SecretAgentMod;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class JetpackController extends Item {
	
	public JetpackController(int par1) {
		super(par1);
		this.maxStackSize = 1;
		this.setCreativeTab(secretAgentMod.tabSAMod);
	}
	
	
	public int getMaxItemUseDuration(ItemStack par1ItemStack)
    {
        return 72000;
    }
	
	
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		
		if(!par3EntityPlayer.capabilities.isFlying) {
		
		if(par3EntityPlayer.getCurrentItemOrArmor(3) != null) {
			ItemStack jetpack = par3EntityPlayer.getCurrentItemOrArmor(3);
			
			if(jetpack.getItem() == secretAgentMod.jetpack) {
					
					if(par3EntityPlayer.inventory.hasItem(secretAgentMod.rocketFuel.itemID) || par3EntityPlayer.capabilities.isCreativeMode) {
						
						if(par3EntityPlayer.onGround == false) {
						par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
						if(!par3EntityPlayer.capabilities.isCreativeMode) {
						par3EntityPlayer.inventory.consumeInventoryItem(secretAgentMod.rocketFuel.itemID);
						}
						par3EntityPlayer.setVelocity(0.0F, 0.0F, 0.0F);
						par3EntityPlayer.playSound("random.fizz", 1.2F, 0.4F);
						}
					}
			}
			}
			
		}
		
		return par1ItemStack;
	}
	
	public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        return par1ItemStack;
    }
	
	public void onUsingItemTick(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, int par3) {
		
		if(par2EntityPlayer.onGround == false) {
			if(par2EntityPlayer.isInWater() == false) {
		par2EntityPlayer.moveEntity(par2EntityPlayer.motionX * 200.0F, 2.0F, par2EntityPlayer.motionZ * 200.0F);
		par2EntityPlayer.playSound("random.fizz", 0.3F, 0.1F);
		}
		}
		
		if(par2EntityPlayer.onGround == true) {
			par2EntityPlayer.clearItemInUse();
		}
		
		par2EntityPlayer.fallDistance = 0.0F;
	}
	
	public void onPlayerStoppedUsing(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer, int par4) {
		
	}
	

}
