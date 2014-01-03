package Dr_Sideburns.SecretAgentMod;

import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;

public class MADamageSource {
	
	 public static DamageSource causeBulletDamage(EntityBullet par0EntityBullet, Entity par1Entity)
	    {
	        return (new EntityDamageSourceIndirect("bullet", par0EntityBullet, par1Entity)).setProjectile();
	    }
	 
	 public static DamageSource causeGoldenBulletDamage(EntityGoldenBullet par0EntityBullet, Entity par1Entity)
	    {
	        return (new EntityDamageSourceIndirect("goldenBullet", par0EntityBullet, par1Entity)).setProjectile();
	    }
	 
	 public static DamageSource causePoisonDartDamage(EntityPoisonDart par0EntityDart, Entity par1Entity)
	 {
		 return (new EntityDamageSourceIndirect("poisonDart", par0EntityDart, par1Entity)).setProjectile();
	 }
	 
	 public static DamageSource causeNinjaDartDamage(EntityNinjaDart par0EntityDart, Entity par1Entity)
	 {
		 return (new EntityDamageSourceIndirect("ninjaDart", par0EntityDart, par1Entity)).setProjectile();
	 }

}
