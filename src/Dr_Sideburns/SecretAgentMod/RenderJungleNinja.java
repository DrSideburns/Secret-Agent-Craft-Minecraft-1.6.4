package Dr_Sideburns.SecretAgentMod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import Dr_Sideburns.SecretAgentMod.entity.EntityJungleNinja;
import Dr_Sideburns.SecretAgentMod.models.jungleNinja;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderJungleNinja extends RenderLiving {
	
	protected jungleNinja model;
	
	public RenderJungleNinja(ModelBase par1ModelBase, float par2) {
		super(par1ModelBase, par2);
		model = ((jungleNinja)mainModel);
	}
	
	public void renderJungleNinja(EntityJungleNinja entity, double par2, double par4, double par6, float par8, float par9) {
		super.doRenderLiving(entity, par2, par4, par6, par8, par9);
	}
	
	public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9) {
		renderJungleNinja((EntityJungleNinja)par1EntityLiving, par2, par4, par6, par8, par9);
	}

	@Override
	public void doRender(Entity entity, double d0, double d1, double d2, float f, float f1) {
		renderJungleNinja((EntityJungleNinja)entity, d0, d1, d2, f, f1);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return new ResourceLocation("secretagentmod:textures/mobs/jungleninja.png");
	}

}
