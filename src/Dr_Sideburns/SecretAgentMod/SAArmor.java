package Dr_Sideburns.SecretAgentMod;

import net.minecraft.entity.Entity;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class SAArmor extends ItemArmor {

	public SAArmor(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3,
			int par4) {
		super(par1, par2EnumArmorMaterial, par3, par4);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String getArmorTexture(ItemStack itemstack, Entity entity, int slot, int layer)
	{
		int i = itemstack.itemID;
		//Apply armor textures.
		if ((i == secretAgentMod.bowlerHat.itemID) || (i == secretAgentMod.tuxedo.itemID) || (i == secretAgentMod.tuxedoShoes.itemID))
			return "secretagentmod:textures/models/armor/tuxedo_layer_1.png";
		if (i == secretAgentMod.tuxedoPants.itemID)
			return "secretagentmod:textures/models/armor/tuxedo_layer_2.png";
		
		if ((i == secretAgentMod.leatherBowlerHat.itemID) || (i == secretAgentMod.leatherTuxedo.itemID) || (i == secretAgentMod.leatherTuxedoShoes.itemID))
			return "secretagentmod:textures/models/armor/leathertuxedo_layer_1.png";
		if (i == secretAgentMod.leatherTuxedoPants.itemID)
			return "secretagentmod:textures/models/armor/leathertuxedo_layer_2.png";
		
		if ((i == secretAgentMod.ironBowlerHat.itemID) || (i == secretAgentMod.ironTuxedo.itemID) || (i == secretAgentMod.ironTuxedoShoes.itemID))
			return "secretagentmod:textures/models/armor/irontuxedo_layer_1.png";
		if (i == secretAgentMod.ironTuxedoPants.itemID)
			return "secretagentmod:textures/models/armor/irontuxedo_layer_2.png";
		
		if ((i == secretAgentMod.goldBowlerHat.itemID) || (i == secretAgentMod.goldTuxedo.itemID) || (i == secretAgentMod.goldTuxedoShoes.itemID))
			return "secretagentmod:textures/models/armor/goldtuxedo_layer_1.png";
		if (i == secretAgentMod.goldTuxedoPants.itemID)
			return "secretagentmod:textures/models/armor/goldtuxedo_layer_2.png";
		
		if ((i == secretAgentMod.chainBowlerHat.itemID) || (i == secretAgentMod.chainTuxedo.itemID) || (i == secretAgentMod.chainTuxedoShoes.itemID))
			return "secretagentmod:textures/models/armor/chaintuxedo_layer_1.png";
		if (i == secretAgentMod.chainTuxedoPants.itemID)
			return "secretagentmod:textures/models/armor/chaintuxedo_layer_2.png";
		
		if ((i == secretAgentMod.diamondBowlerHat.itemID) || (i == secretAgentMod.diamondTuxedo.itemID) || (i == secretAgentMod.diamondTuxedoShoes.itemID))
			return "secretagentmod:textures/models/armor/diamondtuxedo_layer_1.png";
		if (i == secretAgentMod.diamondTuxedoPants.itemID)
			return "secretagentmod:textures/models/armor/diamondtuxedo_layer_2.png";
		
		if (i == secretAgentMod.miniAirCanister.itemID)
			return "secretagentmod:textures/models/armor/miniaircanister_layer_1.png";
		
		if (i == secretAgentMod.nightVisionGoggles.itemID)
			return "secretagentmod:textures/models/armor/nightvisiongoggles_layer_1.png";
		
		if (i == secretAgentMod.jetpack.itemID)
			return "secretagentmod:textures/models/armor/jetpack_layer_1.png";
		
		return "secretagentmod:textures/models/armor/tuxedo_layer_1.png";
		
	}

}
