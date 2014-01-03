package Dr_Sideburns.SecretAgentMod;

import net.minecraft.nbt.NBTTagCompound;

public class Fuelage {
	
	public boolean jetpackFueled;
	
	public void writeCapabilitiesToNBT(NBTTagCompound par1NBTTagCompound)
    {
	 NBTTagCompound nbttagcompound1 = new NBTTagCompound();
	 nbttagcompound1.setBoolean("jetpackfueled", this.jetpackFueled);
	 par1NBTTagCompound.setTag("fuelage", nbttagcompound1);
    }
 
 public void readCapabilitiesFromNBT(NBTTagCompound par1NBTTagCompound)
    {
	 if (par1NBTTagCompound.hasKey("fuelage"))
        {
		 NBTTagCompound nbttagcompound1 = par1NBTTagCompound.getCompoundTag("fuelage");
		 this.jetpackFueled = nbttagcompound1.getBoolean("jetpackfueled");
        }
    }

}
