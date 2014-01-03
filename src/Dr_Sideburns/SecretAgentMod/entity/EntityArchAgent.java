package Dr_Sideburns.SecretAgentMod.entity;

import java.util.Calendar;

import Dr_Sideburns.SecretAgentMod.EntityBullet;
import Dr_Sideburns.SecretAgentMod.EntityGoldenBullet;
import Dr_Sideburns.SecretAgentMod.EntityOddjobsHat;
import Dr_Sideburns.SecretAgentMod.EntityThrowableHat;
import Dr_Sideburns.SecretAgentMod.secretAgentMod;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityLivingData;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIFleeSun;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.WorldProviderHell;

public class EntityArchAgent extends EntityMob implements IRangedAttackMob {
	
	public EntityArchAgent(World par1World) {
		super(par1World);
		this.experienceValue = 50;
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIArrowAttack(this, 1.25D, 60, 10.0F));
		this.tasks.addTask(5, new EntityAIWander(this, 0.15D));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
	    this.tasks.addTask(6, new EntityAILookIdle(this));
	    this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
	}
	
	
	protected boolean isAIEnabled() {
		return true;
	}
	
	public void applyEntityAttributes() {
		super.applyEntityAttributes();
		
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(120.0F);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setAttribute(80.0F);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(0.18D);
	}
	
	 
	protected String getHurtSound()
	{
	    return "mob.villager.hit";
	}
	
	protected String getDeathSound()
	{
		return "mob.villager.death";
	}
	
	protected void dropFewItems(boolean par1, int par2)
    {
		this.dropItem(secretAgentMod.goldenGun.itemID, 1);
		this.dropItem(secretAgentMod.goldenBullet.itemID, 8);
    }
	
	 public void attackEntityWithRangedAttack(EntityLivingBase par1EntityLivingBase, float par2)
	    {
			 	EntityGoldenBullet entitybullet = new EntityGoldenBullet(this.worldObj, this, 1.6F);
		        this.playSound("mob.zombie.metal", 3.0F, 1.0F);
		        this.playSound("random.explode", 0.5F, 1.0F);
		        this.worldObj.spawnEntityInWorld(entitybullet);
		        double d0 = par1EntityLivingBase.posX - this.posX;
		        double d1 = par1EntityLivingBase.posY + (double)par1EntityLivingBase.getEyeHeight() - 1.100000023841858D - entitybullet.posY;
		        double d2 = par1EntityLivingBase.posZ - this.posZ;
		        float f1 = MathHelper.sqrt_double(d0 * d0 + d2 * d2) * 0.2F;
		        entitybullet.setThrowableHeading(d0, d1 + (double)f1, d2, 1.6F, 12.0F);
	        }

}