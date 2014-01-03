package Dr_Sideburns.SecretAgentMod.client;

import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.client.renderer.entity.RenderArrow;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraftforge.client.MinecraftForgeClient;
import Dr_Sideburns.SecretAgentMod.CommonProxy;
import Dr_Sideburns.SecretAgentMod.EntityKunai;
import Dr_Sideburns.SecretAgentMod.EntityNinjaDart;
import Dr_Sideburns.SecretAgentMod.EntityOddjobsHat;
import Dr_Sideburns.SecretAgentMod.EntityPoisonDart;
import Dr_Sideburns.SecretAgentMod.EntityThrowableHat;
import Dr_Sideburns.SecretAgentMod.EntityThrowingKnife;
import Dr_Sideburns.SecretAgentMod.RenderAgent;
import Dr_Sideburns.SecretAgentMod.RenderArchAgent;
import Dr_Sideburns.SecretAgentMod.RenderJungleNinja;
import Dr_Sideburns.SecretAgentMod.RenderNinja;
import Dr_Sideburns.SecretAgentMod.RenderOddJob;
import Dr_Sideburns.SecretAgentMod.secretAgentMod;
import Dr_Sideburns.SecretAgentMod.entity.EntityAgent;
import Dr_Sideburns.SecretAgentMod.entity.EntityArchAgent;
import Dr_Sideburns.SecretAgentMod.entity.EntityJungleNinja;
import Dr_Sideburns.SecretAgentMod.entity.EntityNinja;
import Dr_Sideburns.SecretAgentMod.entity.EntityOddJob;
import Dr_Sideburns.SecretAgentMod.models.Oddjob;
import Dr_Sideburns.SecretAgentMod.models.agent;
import Dr_Sideburns.SecretAgentMod.models.jungleNinja;
import Dr_Sideburns.SecretAgentMod.models.ninja;

public class ClientProxy extends CommonProxy {
	
	@Override
	public void registerRenderers() {
		RenderingRegistry.registerEntityRenderingHandler(EntityThrowableHat.class, new RenderSnowball(secretAgentMod.throwableHat));
		RenderingRegistry.registerEntityRenderingHandler(EntityThrowingKnife.class, new RenderSnowball(secretAgentMod.throwingKnife));
		RenderingRegistry.registerEntityRenderingHandler(EntityPoisonDart.class, new RenderSnowball(secretAgentMod.poisonDart));
		RenderingRegistry.registerEntityRenderingHandler(EntityOddjobsHat.class, new RenderSnowball(secretAgentMod.throwableHat));
		RenderingRegistry.registerEntityRenderingHandler(EntityKunai.class, new RenderSnowball(secretAgentMod.throwingKnife));
		RenderingRegistry.registerEntityRenderingHandler(EntityNinjaDart.class, new RenderSnowball(secretAgentMod.poisonDart));
		RenderingRegistry.registerEntityRenderingHandler(EntityOddJob.class, new RenderOddJob(new Oddjob(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityAgent.class, new RenderAgent(new agent(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityNinja.class, new RenderNinja(new ninja(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityJungleNinja.class, new RenderJungleNinja(new jungleNinja(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityArchAgent.class, new RenderArchAgent(new agent(), 0.3F));
	}
	
	@Override
	public int addArmor(String armor) {
		return RenderingRegistry.addNewArmourRendererPrefix(armor);
	}

}
