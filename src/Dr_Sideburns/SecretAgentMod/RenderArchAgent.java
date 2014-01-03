package Dr_Sideburns.SecretAgentMod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import Dr_Sideburns.SecretAgentMod.entity.EntityAgent;
import Dr_Sideburns.SecretAgentMod.entity.EntityArchAgent;
import Dr_Sideburns.SecretAgentMod.entity.EntityOddJob;
import Dr_Sideburns.SecretAgentMod.models.Oddjob;
import Dr_Sideburns.SecretAgentMod.models.agent;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderArchAgent extends RenderLiving {
	
	protected agent model;
	
	public RenderArchAgent(ModelBase par1ModelBase, float par2) {
		super(par1ModelBase, par2);
		model = ((agent)mainModel);
	}
	
	public void renderArchAgent(EntityArchAgent entity, double par2, double par4, double par6, float par8, float par9) {
		super.doRenderLiving(entity, par2, par4, par6, par8, par9);
	}
	
	public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9) {
		renderArchAgent((EntityArchAgent)par1EntityLiving, par2, par4, par6, par8, par9);
	}

	@Override
	public void doRender(Entity entity, double d0, double d1, double d2, float f, float f1) {
		renderArchAgent((EntityArchAgent)entity, d0, d1, d2, f, f1);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return new ResourceLocation("secretagentmod:textures/mobs/archagent.png");
	}

}
