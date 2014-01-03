package Dr_Sideburns.SecretAgentMod;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

public class CommonProxy {
	
	public void registerRenderers() {
		
	}
	
	public void registerServerTickHandler() {
		TickRegistry.registerTickHandler(new serverTickHandler(), Side.SERVER);
	}

	public int addArmor(String string) {
		// TODO Auto-generated method stub
		return 0;
	}

}