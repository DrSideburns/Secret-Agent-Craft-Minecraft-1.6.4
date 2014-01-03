package Dr_Sideburns.SecretAgentMod;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class SAAirCanister extends SAArmor {

	protected Enchantment enchantment;
	protected int level;

	public SAAirCanister(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4)
	{
		super(par1, par2EnumArmorMaterial, par3, par4);
	}
	
	@Override
	public int getDamage(ItemStack stack) {
		if (!stack.isItemEnchanted() && !isRestricted(stack)) {
			stack.addEnchantment(Enchantment.respiration, 2);
			NBTTagCompound tag = stack.getTagCompound();
			tag.setBoolean("enchant-set", true);
			stack.setTagCompound(tag);
		}
		return super.getDamage(stack);
}
	

private boolean isRestricted(ItemStack item) {
	if (item.hasTagCompound()) {
		NBTTagCompound tag = item.getTagCompound();
		if (tag.hasKey("enchant-set")) {
			return tag.getBoolean("enchant-set");
		} else {
			tag.setBoolean("enchant-set", false);
			item.setTagCompound(tag);
		}
	}
	return false;
}

}