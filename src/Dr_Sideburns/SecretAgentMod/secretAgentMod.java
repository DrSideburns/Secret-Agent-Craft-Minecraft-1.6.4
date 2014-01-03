package Dr_Sideburns.SecretAgentMod;

//Imports
import Dr_Sideburns.SecretAgentMod.entity.EntityAgent;
import Dr_Sideburns.SecretAgentMod.entity.EntityArchAgent;
import Dr_Sideburns.SecretAgentMod.entity.EntityJungleNinja;
import Dr_Sideburns.SecretAgentMod.entity.EntityNinja;
import Dr_Sideburns.SecretAgentMod.entity.EntityOddJob;
import Dr_Sideburns.SecretAgentMod.models.Oddjob;
import Dr_Sideburns.SecretAgentMod.models.agent;
import Dr_Sideburns.SecretAgentMod.models.jungleNinja;
import Dr_Sideburns.SecretAgentMod.models.ninja;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockColored;
import net.minecraft.block.StepSound;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MapColor;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.potion.Potion;
import net.minecraft.src.ModLoader;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;

//Mod Name and Stuff
@Mod (modid="DrSideburnsSAMod", name="Secret Agent Craft", version="1.2.2")
@NetworkMod (clientSideRequired=true, serverSideRequired=false)

public class secretAgentMod {
	
	@Instance ("DrSideburnsSAMod")
	public static secretAgentMod instance;
	
	//Create Things
	
	//Armor
	public static Item bowlerHat;
	public static Item tuxedo;
	public static Item tuxedoPants;
	public static Item tuxedoShoes;
	
	public static Item leatherBowlerHat;
	public static Item leatherTuxedo;
	public static Item leatherTuxedoPants;
	public static Item leatherTuxedoShoes;
	
	public static Item ironBowlerHat;
	public static Item ironTuxedo;
	public static Item ironTuxedoPants;
	public static Item ironTuxedoShoes;
	
	public static Item goldBowlerHat;
	public static Item goldTuxedo;
	public static Item goldTuxedoPants;
	public static Item goldTuxedoShoes;
	
	public static Item chainBowlerHat;
	public static Item chainTuxedo;
	public static Item chainTuxedoPants;
	public static Item chainTuxedoShoes;
	
	public static Item diamondBowlerHat;
	public static Item diamondTuxedo;
	public static Item diamondTuxedoPants;
	public static Item diamondTuxedoShoes;
	
	//Gadgets
	public static Item miniAirCanister;
	public static ItemSelfDestruct selfDestructor;
	public static Item nightVisionGoggles;
	public static ExplodingPen explodingPen;
	public static Item jetpack;
	public static JetpackController jetpackControl;
	
	//Other Items
	public static Item bullet;
	public static Item gunGrip;
	public static Item gunBarrel;
	public static Item gunHammer;
	public static Item goldenBullet;
	public static Item goldenGunGrip;
	public static Item goldenGunBarrel;
	public static Item goldenGunHammer;
	public static Item appleSeeds;
	public static Item cyanide;
	public static Item poisonDart;
	public static RocketFuel rocketFuel;
	public static Item largeRocketEngine;
	public static Item smallRocketEngine;
	public static Item ironDust;
	public static Item villainSpawner;
	
	//Weapons
	public static ItemGun handGun;
	public static ItemGoldenGun goldenGun;
	public static ItemThrowableHat throwableHat;
	public static Item ironKnuckles;
	public static ItemThrowingKnife throwingKnife;
	public static ItemBlowGun blowGun;
	
	//Mob IDs
	static int startEntityId = 500;
	
	//Mob Gen
	public static int getUniqueEntityId() {
		do {
			startEntityId++;
		}
		while(EntityList.getStringFromID(startEntityId) != null);
		return startEntityId++;
	}
	
	public static void registerEntityEgg(Class<? extends Entity> entity, int primaryColor, int secondaryColor) {
		int id = getUniqueEntityId();
		EntityList.IDtoClassMapping.put(id, entity);
		EntityList.entityEggs.put(id, new EntityEggInfo(id, primaryColor, secondaryColor));
	}
	
	//Entity IDs
	private static int throwableHatEntity = 0;
	private static int throwingKnifeEntity = 1;
	private static int poisonDartEntity = 2;
	private static int oddjobsHatEntity = 3;
	private static int kunaiEntity = 4;
	private static int ninjaDartEntity = 5;
	
	//Armor Materials
	public static EnumArmorMaterial armorNOTHING = EnumHelper.addArmorMaterial("NOTHING", 1, new int[] {0, 0, 0, 0}, 0);
	public static EnumArmorMaterial armorLEATHER = EnumHelper.addArmorMaterial("LEATHER", 5, new int[] {1, 3, 2, 1}, 15);
	
	//Tool Materials
	public static EnumToolMaterial toolKNUCKLES = EnumHelper.addToolMaterial("KNUCKLES", 0, 300, 2.0F, 1.0F, 10);
	
	//Creative Tabs
	public static CreativeTabs tabSAMod = new CreativeTabs("tabSAMod") {
		public ItemStack getIconItemStack() {
			return new ItemStack(secretAgentMod.goldenGun, 1, 0);
		}
	};
	
	@SidedProxy (clientSide="Dr_Sideburns.SecretAgentMod.client.ClientProxy", serverSide="Dr_Sideburns.SecretAgentMod.CommonProxy")
	public static CommonProxy proxy;
	//Nothing
	
	@EventHandler
	public void PreInit (FMLPreInitializationEvent event) {
		proxy.registerRenderers();
		proxy.registerServerTickHandler();
		
		//Define Things
		
		//Render Armor
		int renderSAArmor = proxy.addArmor("sAArmor");
		
		//Define Armor
		bowlerHat = new SAArmor(13650, armorNOTHING, renderSAArmor, 0).setUnlocalizedName("bowlerHat")
				.setCreativeTab(this.tabSAMod).setTextureName("secretagentmod:bowlerhat");
		tuxedo = new SAArmor(13651, armorNOTHING, renderSAArmor, 1).setUnlocalizedName("tuxedo")
				.setCreativeTab(this.tabSAMod).setTextureName("secretagentmod:tuxedo");
		tuxedoPants = new SAArmor(13652, armorNOTHING, renderSAArmor, 2).setUnlocalizedName("tuxedoPants")
				.setCreativeTab(this.tabSAMod).setTextureName("secretagentmod:tuxedopants");
		tuxedoShoes = new SAArmor(13653, armorNOTHING, renderSAArmor, 3).setUnlocalizedName("tuxedoShoes")
				.setCreativeTab(this.tabSAMod).setTextureName("secretagentmod:tuxedoshoes");
		
		leatherBowlerHat = new SAArmor(13654, armorLEATHER, renderSAArmor, 0).setUnlocalizedName("leatherBowlerHat")
				.setCreativeTab(this.tabSAMod).setTextureName("secretagentmod:leatherbowlerhat");
		leatherTuxedo = new SAArmor(13655, armorLEATHER, renderSAArmor, 1).setUnlocalizedName("leatherTuxedo")
				.setCreativeTab(this.tabSAMod).setTextureName("secretagentmod:leathertuxedo");
		leatherTuxedoPants = new SAArmor(13656, armorLEATHER, renderSAArmor, 2).setUnlocalizedName("leatherTuxedoPants")
				.setCreativeTab(this.tabSAMod).setTextureName("secretagentmod:leathertuxedopants");
		leatherTuxedoShoes = new SAArmor(13657, armorLEATHER, renderSAArmor, 3).setUnlocalizedName("leatherTuxedoShoes")
				.setCreativeTab(this.tabSAMod).setTextureName("secretagentmod:leathertuxedoshoes");
		
		ironBowlerHat = new SAArmor(13658, EnumArmorMaterial.IRON, renderSAArmor, 0).setUnlocalizedName("ironBowlerHat")
				.setCreativeTab(this.tabSAMod).setTextureName("secretagentmod:ironbowlerhat");
		ironTuxedo = new SAArmor(13659, EnumArmorMaterial.IRON, renderSAArmor, 1).setUnlocalizedName("ironTuxedo")
				.setCreativeTab(this.tabSAMod).setTextureName("secretagentmod:irontuxedo");
		ironTuxedoPants = new SAArmor(13660, EnumArmorMaterial.IRON, renderSAArmor, 2).setUnlocalizedName("ironTuxedoPants")
				.setCreativeTab(this.tabSAMod).setTextureName("secretagentmod:irontuxedopants");
		ironTuxedoShoes = new SAArmor(13661, EnumArmorMaterial.IRON, renderSAArmor, 3).setUnlocalizedName("ironTuxedoShoes")
				.setCreativeTab(this.tabSAMod).setTextureName("secretagentmod:irontuxedoshoes");
		
		goldBowlerHat = new SAArmor(13662, EnumArmorMaterial.GOLD, renderSAArmor, 0).setUnlocalizedName("goldBowlerHat")
				.setCreativeTab(this.tabSAMod).setTextureName("secretagentmod:goldbowlerhat");
		goldTuxedo = new SAArmor(13663, EnumArmorMaterial.GOLD, renderSAArmor, 1).setUnlocalizedName("goldTuxedo")
				.setCreativeTab(this.tabSAMod).setTextureName("secretagentmod:goldtuxedo");
		goldTuxedoPants = new SAArmor(13664, EnumArmorMaterial.GOLD, renderSAArmor, 2).setUnlocalizedName("goldTuxedoPants")
				.setCreativeTab(this.tabSAMod).setTextureName("secretagentmod:goldtuxedopants");
		goldTuxedoShoes = new SAArmor(13665, EnumArmorMaterial.GOLD, renderSAArmor, 3).setUnlocalizedName("goldTuxedoShoes")
				.setCreativeTab(this.tabSAMod).setTextureName("secretagentmod:goldtuxedoshoes");
		
		chainBowlerHat = new SAArmor(13666, EnumArmorMaterial.CHAIN, renderSAArmor, 0).setUnlocalizedName("chainBowlerHat")
				.setCreativeTab(this.tabSAMod).setTextureName("secretagentmod:chainbowlerhat");
		chainTuxedo = new SAArmor(13667, EnumArmorMaterial.CHAIN, renderSAArmor, 1).setUnlocalizedName("chainTuxedo")
				.setCreativeTab(this.tabSAMod).setTextureName("secretagentmod:chaintuxedo");
		chainTuxedoPants = new SAArmor(13668, EnumArmorMaterial.CHAIN, renderSAArmor, 2).setUnlocalizedName("chainTuxedoPants")
				.setCreativeTab(this.tabSAMod).setTextureName("secretagentmod:chaintuxedopants");
		chainTuxedoShoes = new SAArmor(13669, EnumArmorMaterial.CHAIN, renderSAArmor, 3).setUnlocalizedName("chainTuxedoShoes")
				.setCreativeTab(this.tabSAMod).setTextureName("secretagentmod:chaintuxedoshoes");
		
		diamondBowlerHat = new SAArmor(13670, EnumArmorMaterial.DIAMOND, renderSAArmor, 0).setUnlocalizedName("diamondBowlerHat")
				.setCreativeTab(this.tabSAMod).setTextureName("secretagentmod:diamondbowlerhat");
		diamondTuxedo = new SAArmor(13671, EnumArmorMaterial.DIAMOND, renderSAArmor, 1).setUnlocalizedName("diamondTuxedo")
				.setCreativeTab(this.tabSAMod).setTextureName("secretagentmod:diamondtuxedo");
		diamondTuxedoPants = new SAArmor(13672, EnumArmorMaterial.DIAMOND, renderSAArmor, 2).setUnlocalizedName("diamondTuxedoPants")
				.setCreativeTab(this.tabSAMod).setTextureName("secretagentmod:diamondtuxedopants");
		diamondTuxedoShoes = new SAArmor(13673, EnumArmorMaterial.DIAMOND, renderSAArmor, 3).setUnlocalizedName("diamondTuxedoShoes")
				.setCreativeTab(this.tabSAMod).setTextureName("secretagentmod:diamondtuxedoshoes");
		
		//Define gadgets
		miniAirCanister = new SAAirCanister(13685, armorNOTHING, renderSAArmor, 0).setUnlocalizedName("miniAirCanister")
				.setCreativeTab(this.tabSAMod).setTextureName("secretagentmod:miniaircanister");
		selfDestructor = (ItemSelfDestruct) new ItemSelfDestruct(13686).setUnlocalizedName("selfDestructor")
				.setTextureName("secretagentmod:selfdestructor");
		nightVisionGoggles = new SAArmor(13687, armorNOTHING, renderSAArmor, 0).setUnlocalizedName("nightVisionGoggles")
				.setCreativeTab(this.tabSAMod).setTextureName("secretagentmod:nightvisiongoggles");
		explodingPen = (ExplodingPen) new ExplodingPen(13690).setUnlocalizedName("explodingPen")
				.setTextureName("secretagentmod:explodingpen");
		jetpack = new Jetpack(13696, armorNOTHING, renderSAArmor, 1).setUnlocalizedName("jetpack")
				.setCreativeTab(this.tabSAMod).setTextureName("secretagentmod:jetpack");
		jetpackControl = (JetpackController) new JetpackController(13697).setUnlocalizedName("jetpackControl")
				.setTextureName("secretagentmod:jetpackcontroller");
		
		//Define other items
		bullet = new SAItem(13674).setUnlocalizedName("bullet").setCreativeTab(this.tabSAMod).setTextureName("secretagentmod:bullet");
		gunGrip = new SAItem(13676).setUnlocalizedName("gunGrip").setCreativeTab(this.tabSAMod).setTextureName("secretagentmod:gungrip");
		gunBarrel = new SAItem(13677).setUnlocalizedName("gunBarrel").setCreativeTab(this.tabSAMod).setTextureName("secretagentmod:gunbarrel");
		gunHammer = new SAItem(13678).setUnlocalizedName("gunHammer").setCreativeTab(this.tabSAMod).setTextureName("secretagentmod:gunhammer");
		goldenBullet = new SAItem(13679).setUnlocalizedName("goldenBullet").setCreativeTab(this.tabSAMod).setTextureName("secretagentmod:goldenbullet");
		goldenGunGrip = new SAItem(13681).setUnlocalizedName("goldenGunGrip").setCreativeTab(this.tabSAMod).setTextureName("secretagentmod:goldengungrip");
		goldenGunBarrel = new SAItem(13682).setUnlocalizedName("goldenGunBarrel").setCreativeTab(this.tabSAMod).setTextureName("secretagentmod:goldengunbarrel");
		goldenGunHammer = new SAItem(13683).setUnlocalizedName("goldenGunHammer").setCreativeTab(this.tabSAMod).setTextureName("secretagentmod:goldengunhammer");
		appleSeeds = new SAItem(13688).setUnlocalizedName("appleSeeds").setCreativeTab(this.tabSAMod).setTextureName("secretagentmod:appleseeds");
		cyanide = new SAFood(13689, 0, 0.0F, false).setPotionEffect(Potion.wither.id, 25, 10, 1.0F)
				.setUnlocalizedName("cyanide").setTextureName("secretagentmod:cyanide").setCreativeTab(this.tabSAMod);
		poisonDart = new SAItem(13693).setUnlocalizedName("poisonDart").setCreativeTab(this.tabSAMod).setTextureName("secretagentmod:poisondart");
		rocketFuel = (RocketFuel) new RocketFuel(13695).setUnlocalizedName("rocketFuel").setCreativeTab(this.tabSAMod).setTextureName("secretagentmod:rocketfuel");
		largeRocketEngine = new SAItem(13698).setUnlocalizedName("largeRocketEngine").setCreativeTab(this.tabSAMod).setTextureName("secretagentmod:largejetpackengine");
		smallRocketEngine = new SAItem(13699).setUnlocalizedName("smallRocketEngine").setCreativeTab(this.tabSAMod).setTextureName("secretagentmod:smalljetpackengine");
		ironDust = new SAItem(13700).setUnlocalizedName("ironDust").setCreativeTab(this.tabSAMod).setTextureName("secretagentmod:irondust");
		
		//Define weapons
		handGun = (ItemGun)(new ItemGun(13675)).setUnlocalizedName("handGun").setTextureName("secretagentmod:handgun");
		goldenGun = (ItemGoldenGun)(new ItemGoldenGun(13680)).setUnlocalizedName("goldenGun").setTextureName("secretagentmod:goldengun");
		throwableHat = (ItemThrowableHat)(new ItemThrowableHat(13684)).setUnlocalizedName("throwableHat").setTextureName("secretagentmod:bowlerhat");
		ironKnuckles = new ItemKnuckles(13691, toolKNUCKLES).setUnlocalizedName("ironKnuckles").setTextureName("secretagentmod:ironknuckles");
		throwingKnife = (ItemThrowingKnife)(new ItemThrowingKnife(13692, EnumToolMaterial.IRON)).setUnlocalizedName("throwingKnife").setTextureName("secretagentmod:throwingknife");
		blowGun = (ItemBlowGun)(new ItemBlowGun(13694)).setUnlocalizedName("blowGun").setTextureName("secretagentmod:blowgun");
		
		//Define Mobs
		EntityRegistry.registerGlobalEntityID(EntityOddJob.class, "Oddjob", -1);
		EntityRegistry.addSpawn(EntityOddJob.class, 1, 1, 1, EnumCreatureType.monster, BiomeGenBase.desert);
		EntityRegistry.addSpawn(EntityOddJob.class, 1, 1, 1, EnumCreatureType.monster, BiomeGenBase.desertHills);
		EntityRegistry.addSpawn(EntityOddJob.class, 1, 1, 1, EnumCreatureType.monster, BiomeGenBase.extremeHills);
		EntityRegistry.addSpawn(EntityOddJob.class, 1, 1, 1, EnumCreatureType.monster, BiomeGenBase.extremeHillsEdge);
		EntityRegistry.addSpawn(EntityOddJob.class, 1, 1, 1, EnumCreatureType.monster, BiomeGenBase.plains);
		EntityRegistry.addSpawn(EntityOddJob.class, 1, 1, 1, EnumCreatureType.monster, BiomeGenBase.forest);
		EntityRegistry.addSpawn(EntityOddJob.class, 1, 1, 1, EnumCreatureType.monster, BiomeGenBase.forestHills);
		EntityRegistry.addSpawn(EntityOddJob.class, 1, 1, 1, EnumCreatureType.monster, BiomeGenBase.taiga);
		EntityRegistry.addSpawn(EntityOddJob.class, 1, 1, 1, EnumCreatureType.monster, BiomeGenBase.taigaHills);
		EntityRegistry.addSpawn(EntityOddJob.class, 1, 1, 1, EnumCreatureType.monster, BiomeGenBase.icePlains);
		EntityRegistry.addSpawn(EntityOddJob.class, 1, 1, 1, EnumCreatureType.monster, BiomeGenBase.iceMountains);
		EntityRegistry.addSpawn(EntityOddJob.class, 1, 1, 1, EnumCreatureType.monster, BiomeGenBase.swampland);
		EntityRegistry.findGlobalUniqueEntityId();
		registerEntityEgg(EntityOddJob.class, 0xa56143, 0x141414);
		LanguageRegistry.instance().addStringLocalization("entity.Oddjob.name", "Oddjob");
		
		EntityRegistry.registerGlobalEntityID(EntityAgent.class, "Agent", -2);
		EntityRegistry.addSpawn(EntityAgent.class, 1, 2, 3, EnumCreatureType.monster, BiomeGenBase.desert);
		EntityRegistry.addSpawn(EntityAgent.class, 1, 2, 3, EnumCreatureType.monster, BiomeGenBase.desertHills);
		EntityRegistry.addSpawn(EntityAgent.class, 1, 2, 3, EnumCreatureType.monster, BiomeGenBase.extremeHills);
		EntityRegistry.addSpawn(EntityAgent.class, 1, 2, 3, EnumCreatureType.monster, BiomeGenBase.extremeHillsEdge);
		EntityRegistry.addSpawn(EntityAgent.class, 1, 2, 3, EnumCreatureType.monster, BiomeGenBase.plains);
		EntityRegistry.addSpawn(EntityAgent.class, 1, 2, 3, EnumCreatureType.monster, BiomeGenBase.forest);
		EntityRegistry.addSpawn(EntityAgent.class, 1, 2, 3, EnumCreatureType.monster, BiomeGenBase.forestHills);
		EntityRegistry.addSpawn(EntityAgent.class, 1, 2, 3, EnumCreatureType.monster, BiomeGenBase.taiga);
		EntityRegistry.addSpawn(EntityAgent.class, 1, 2, 3, EnumCreatureType.monster, BiomeGenBase.taigaHills);
		EntityRegistry.addSpawn(EntityAgent.class, 1, 2, 3, EnumCreatureType.monster, BiomeGenBase.icePlains);
		EntityRegistry.addSpawn(EntityAgent.class, 1, 2, 3, EnumCreatureType.monster, BiomeGenBase.iceMountains);
		EntityRegistry.addSpawn(EntityAgent.class, 1, 2, 3, EnumCreatureType.monster, BiomeGenBase.swampland);
		EntityRegistry.findGlobalUniqueEntityId();
		registerEntityEgg(EntityAgent.class, 0x141414, 0x7f0000);
		LanguageRegistry.instance().addStringLocalization("entity.Agent.name", "Agent");
		LanguageRegistry.instance().addStringLocalization("death.attack.bullet", "Player was shot to death by Agent");
		
		EntityRegistry.registerGlobalEntityID(EntityNinja.class, "Ninja", -3);
		EntityRegistry.addSpawn(EntityNinja.class, 1, 4, 5, EnumCreatureType.monster, BiomeGenBase.extremeHills);
		EntityRegistry.addSpawn(EntityNinja.class, 1, 4, 5, EnumCreatureType.monster, BiomeGenBase.extremeHillsEdge);
		EntityRegistry.addSpawn(EntityNinja.class, 1, 4, 5, EnumCreatureType.monster, BiomeGenBase.iceMountains);
		EntityRegistry.addSpawn(EntityNinja.class, 1, 4, 5, EnumCreatureType.monster, BiomeGenBase.jungle);
		EntityRegistry.addSpawn(EntityNinja.class, 1, 4, 5, EnumCreatureType.monster, BiomeGenBase.jungleHills);
		EntityRegistry.findGlobalUniqueEntityId();
		registerEntityEgg(EntityNinja.class, 0x141414, 0x000000);
		LanguageRegistry.instance().addStringLocalization("entity.Ninja.name", "Ninja");
		
		EntityRegistry.registerGlobalEntityID(EntityJungleNinja.class, "JungleNinja", -4);
		EntityRegistry.addSpawn(EntityJungleNinja.class, 2, 4, 5, EnumCreatureType.monster, BiomeGenBase.jungle);
		EntityRegistry.addSpawn(EntityJungleNinja.class, 2, 4, 5, EnumCreatureType.monster, BiomeGenBase.jungleHills);
		EntityRegistry.findGlobalUniqueEntityId();
		registerEntityEgg(EntityJungleNinja.class, 0x141414, 0x00af14);
		LanguageRegistry.instance().addStringLocalization("entity.JungleNinja.name", "Jungle Ninja");
		
		EntityRegistry.registerGlobalEntityID(EntityArchAgent.class, "ArchAgent", -5);
		EntityRegistry.findGlobalUniqueEntityId();
		registerEntityEgg(EntityArchAgent.class, 0xFFFFFF, 0x7c6940);
		LanguageRegistry.instance().addStringLocalization("entity.ArchAgent.name", "Arch Agent");
		LanguageRegistry.instance().addStringLocalization("death.attack.goldenBullet", "Player was shot to death by Arch Agent");
		
	}
	
	@EventHandler
	public void load (FMLInitializationEvent event) {
		
		//Name and Register Things. And Recipes.
		
		//Naming Armor.
		LanguageRegistry.addName(bowlerHat, "Bowler Hat");
		LanguageRegistry.addName(tuxedo, "Tuxedo");
		LanguageRegistry.addName(tuxedoPants, "Tuxedo Pants");
		LanguageRegistry.addName(tuxedoShoes, "Tuxedo Shoes");
		
		LanguageRegistry.addName(leatherBowlerHat, "Leather Armored Bowler Hat");
		LanguageRegistry.addName(leatherTuxedo, "Leather Armored Tuxedo");
		LanguageRegistry.addName(leatherTuxedoPants, "Leather Armored Tuxedo Pants");
		LanguageRegistry.addName(leatherTuxedoShoes, "Leather Armored Tuxedo Shoes");
		
		LanguageRegistry.addName(ironBowlerHat, "Iron Armored Bowler Hat");
		LanguageRegistry.addName(ironTuxedo, "Iron Armored Tuxedo");
		LanguageRegistry.addName(ironTuxedoPants, "Iron Armored Tuxedo Pants");
		LanguageRegistry.addName(ironTuxedoShoes, "Iron Armored Tuxedo Shoes");
		
		LanguageRegistry.addName(goldBowlerHat, "Gold Armored Bowler Hat");
		LanguageRegistry.addName(goldTuxedo, "Gold Armored Tuxedo");
		LanguageRegistry.addName(goldTuxedoPants, "Gold Armored Tuxedo Pants");
		LanguageRegistry.addName(goldTuxedoShoes, "Gold Armored Tuxedo Shoes");
		
		LanguageRegistry.addName(chainBowlerHat, "Chain Armored Bowler Hat");
		LanguageRegistry.addName(chainTuxedo, "Chain Armored Tuxedo");
		LanguageRegistry.addName(chainTuxedoPants, "Chain Armored Tuxedo Pants");
		LanguageRegistry.addName(chainTuxedoShoes, "Chain Armored Tuxedo Shoes");
		
		LanguageRegistry.addName(diamondBowlerHat, "Diamond Armored Bowler Hat");
		LanguageRegistry.addName(diamondTuxedo, "Diamond Armored Tuxedo");
		LanguageRegistry.addName(diamondTuxedoPants, "Diamond Armored Tuxedo Pants");
		LanguageRegistry.addName(diamondTuxedoShoes, "Diamond Armored Tuxedo Shoes");
		
		//Naming Weapons
		LanguageRegistry.addName(handGun, "Handgun");
		LanguageRegistry.addName(goldenGun, "Golden Gun");
		LanguageRegistry.addName(throwableHat, "Throwable Hat");
		LanguageRegistry.addName(ironKnuckles, "Iron Knuckles");
		LanguageRegistry.addName(throwingKnife, "Throwing Knife");
		LanguageRegistry.addName(blowGun, "Blowgun");
		
		//Naming Other
		LanguageRegistry.addName(bullet, "Bullet");
		LanguageRegistry.addName(goldenBullet, "Golden Bullet");
		LanguageRegistry.addName(gunGrip, "Handgun Grip");
		LanguageRegistry.addName(gunBarrel, "Handgun Barrel");
		LanguageRegistry.addName(gunHammer, "Handgun Hammer");
		LanguageRegistry.addName(goldenGunGrip, "Golden Gun Grip");
		LanguageRegistry.addName(goldenGunBarrel, "Golden Gun Barrel");
		LanguageRegistry.addName(goldenGunHammer, "Golden Gun Hammer");
		LanguageRegistry.addName(appleSeeds, "Apple Seeds");
		LanguageRegistry.addName(cyanide, "Cyanide");
		LanguageRegistry.addName(poisonDart, "Poison Dart");
		LanguageRegistry.addName(rocketFuel, "Rocket Fuel");
		LanguageRegistry.addName(largeRocketEngine, "Large Jetpack Engine");
		LanguageRegistry.addName(smallRocketEngine, "Small Jetpack Engine");
		LanguageRegistry.addName(ironDust, "Iron Dust");
		
		//Naming Gadgets
		LanguageRegistry.addName(miniAirCanister, "Mini Air Canister");
		LanguageRegistry.addName(selfDestructor, "Self Destruct Mechanism");
		LanguageRegistry.addName(nightVisionGoggles, "Night Vision Goggles");
		LanguageRegistry.addName(explodingPen, "Exploding Pen");
		LanguageRegistry.addName(jetpack, "Jetpack");
		LanguageRegistry.addName(jetpackControl, "Jetpack Controls");
		
		//Naming CreativeTabs
		LanguageRegistry.instance().addStringLocalization("itemGroup.tabSAMod", "en_US", "Secret Agent Gear");
		
		//ItemStacks
		ItemStack woolStack = new ItemStack(Block.cloth, 1, 15);
		ItemStack leatherStack = new ItemStack(Item.leather);
		
		//Crafting Recipes For Armor
		GameRegistry.addRecipe(new ItemStack(bowlerHat), "xxx", "x x", 'x', woolStack);
		GameRegistry.addRecipe(new ItemStack(tuxedo), "x x", "xxx", "xxx", 'x', woolStack);
		GameRegistry.addRecipe(new ItemStack(tuxedoPants), "xxx", "x x", "x x", 'x', woolStack);
		GameRegistry.addRecipe(new ItemStack(tuxedoShoes), "x x", 'x', leatherStack);
		
		GameRegistry.addRecipe(new ItemStack(leatherBowlerHat), "xxx", "xyx", 'x', woolStack, 'y', new ItemStack(Item.helmetLeather));
		GameRegistry.addRecipe(new ItemStack(leatherTuxedo), "xyx", "xxx", "xxx", 'x', woolStack, 'y', new ItemStack(Item.plateLeather));
		GameRegistry.addRecipe(new ItemStack(leatherTuxedoPants), "xxx", "xyx", "x x", 'x', woolStack, 'y', new ItemStack(Item.legsLeather));
		GameRegistry.addRecipe(new ItemStack(leatherTuxedoShoes), "xyx", 'x', leatherStack, 'y', new ItemStack(Item.bootsLeather));
		
		GameRegistry.addRecipe(new ItemStack(ironBowlerHat), "xxx", "xyx", 'x', woolStack, 'y', new ItemStack(Item.helmetIron));
		GameRegistry.addRecipe(new ItemStack(ironTuxedo), "xyx", "xxx", "xxx", 'x', woolStack, 'y', new ItemStack(Item.plateIron));
		GameRegistry.addRecipe(new ItemStack(ironTuxedoPants), "xxx", "xyx", "x x", 'x', woolStack, 'y', new ItemStack(Item.legsIron));
		GameRegistry.addRecipe(new ItemStack(ironTuxedoShoes), "xyx", 'x', leatherStack, 'y', new ItemStack(Item.bootsIron));
		
		GameRegistry.addRecipe(new ItemStack(goldBowlerHat), "xxx", "xyx", 'x', woolStack, 'y', new ItemStack(Item.helmetGold));
		GameRegistry.addRecipe(new ItemStack(goldTuxedo), "xyx", "xxx", "xxx", 'x', woolStack, 'y', new ItemStack(Item.plateGold));
		GameRegistry.addRecipe(new ItemStack(goldTuxedoPants), "xxx", "xyx", "x x", 'x', woolStack, 'y', new ItemStack(Item.legsGold));
		GameRegistry.addRecipe(new ItemStack(goldTuxedoShoes), "xyx", 'x', leatherStack, 'y', new ItemStack(Item.bootsGold));
		
		GameRegistry.addRecipe(new ItemStack(chainBowlerHat), "xxx", "xyx", 'x', woolStack, 'y', new ItemStack(Item.helmetChain));
		GameRegistry.addRecipe(new ItemStack(chainTuxedo), "xyx", "xxx", "xxx", 'x', woolStack, 'y', new ItemStack(Item.plateChain));
		GameRegistry.addRecipe(new ItemStack(chainTuxedoPants), "xxx", "xyx", "x x", 'x', woolStack, 'y', new ItemStack(Item.legsChain));
		GameRegistry.addRecipe(new ItemStack(chainTuxedoShoes), "xyx", 'x', leatherStack, 'y', new ItemStack(Item.bootsChain));
		
		GameRegistry.addRecipe(new ItemStack(diamondBowlerHat), "xxx", "xyx", 'x', woolStack, 'y', new ItemStack(Item.helmetDiamond));
		GameRegistry.addRecipe(new ItemStack(diamondTuxedo), "xyx", "xxx", "xxx", 'x', woolStack, 'y', new ItemStack(Item.plateDiamond));
		GameRegistry.addRecipe(new ItemStack(diamondTuxedoPants), "xxx", "xyx", "x x", 'x', woolStack, 'y', new ItemStack(Item.legsDiamond));
		GameRegistry.addRecipe(new ItemStack(diamondTuxedoShoes), "xyx", 'x', leatherStack, 'y', new ItemStack(Item.bootsDiamond));
		
		//Crafting Recipes for Weapons
		GameRegistry.addRecipe(new ItemStack(handGun), "xy", " z", 'x', new ItemStack(gunBarrel), 'y', new ItemStack(gunHammer), 'z', new ItemStack(gunGrip));
		GameRegistry.addRecipe(new ItemStack(goldenGun), "xy", " z", 'x', new ItemStack(goldenGunBarrel), 'y', new ItemStack(goldenGunHammer), 'z', new ItemStack(goldenGunGrip));
		GameRegistry.addRecipe(new ItemStack(throwableHat), "xxx", "y y", 'x', woolStack, 'y', new ItemStack(Item.ingotIron));
		GameRegistry.addRecipe(new ItemStack(ironKnuckles), "xxx", " x ", 'x', new ItemStack(Item.ingotIron));
		GameRegistry.addRecipe(new ItemStack(throwingKnife), "x ", " y", 'x', new ItemStack(Item.ingotIron), 'y', new ItemStack(Item.stick));
		GameRegistry.addRecipe(new ItemStack(blowGun), "xxx", 'x', new ItemStack(Item.stick));
		
		//Crafting Recipes for Other
		GameRegistry.addRecipe(new ItemStack(bullet, 9), "xy", 'x', new ItemStack(Item.gunpowder), 'y', new ItemStack(Item.ingotIron));
		GameRegistry.addRecipe(new ItemStack(goldenBullet, 9), "xy", 'x', new ItemStack(Item.gunpowder), 'y', new ItemStack(Item.ingotGold));
		GameRegistry.addRecipe(new ItemStack(gunGrip), "xx", " x", 'x', new ItemStack(Item.ingotIron));
		GameRegistry.addRecipe(new ItemStack(gunBarrel), "xxx", "   ", "xxx", 'x', new ItemStack(Item.ingotIron));
		GameRegistry.addRecipe(new ItemStack(gunHammer), "yx", " x", "x ", 'y', new ItemStack(Item.flint), 'x', new ItemStack(Item.ingotIron));
		GameRegistry.addRecipe(new ItemStack(goldenGunGrip), "xx", " x", 'x', new ItemStack(Item.ingotGold));
		GameRegistry.addRecipe(new ItemStack(goldenGunBarrel), "xxx", "   ", "xxx", 'x', new ItemStack(Item.ingotGold));
		GameRegistry.addRecipe(new ItemStack(goldenGunHammer), "yx", " x", "x ", 'y', new ItemStack(Item.flint), 'x', new ItemStack(Item.ingotGold));
		GameRegistry.addShapelessRecipe(new ItemStack(appleSeeds), new ItemStack(Item.appleRed));
		GameRegistry.addShapelessRecipe(new ItemStack(cyanide), new ItemStack(appleSeeds));
		GameRegistry.addRecipe(new ItemStack(poisonDart, 3), "x", "y", "z", 'x', new ItemStack(Item.feather), 'y', new ItemStack(Item.ingotIron), 'z', new ItemStack(cyanide));
		GameRegistry.addShapelessRecipe(new ItemStack(ironDust, 9), new ItemStack(Item.ingotIron));
		GameRegistry.addShapelessRecipe(new ItemStack(rocketFuel), new ItemStack(ironDust), new ItemStack(Item.gunpowder), new ItemStack(Item.coal));
		GameRegistry.addRecipe(new ItemStack(largeRocketEngine), " x ", "xyx", "xzx", 'x', new ItemStack(Item.ingotIron), 'y', new ItemStack(Item.redstone), 'z', new ItemStack(Item.flintAndSteel));
		GameRegistry.addRecipe(new ItemStack(smallRocketEngine), "x", "x", "y", 'x', new ItemStack(Item.ingotIron), 'y', new ItemStack(Item.flintAndSteel));
		
		//Crafting Recipes for Gadgets
		GameRegistry.addRecipe(new ItemStack(miniAirCanister), " x ", "x x", 'x', new ItemStack(Item.ingotIron));
		GameRegistry.addRecipe(new ItemStack(selfDestructor), "x", "y", "z", 'x', new ItemStack(Item.ingotIron), 'y', new ItemStack(Item.redstone), 'z', new ItemStack(Block.tnt));
		GameRegistry.addRecipe(new ItemStack(nightVisionGoggles), "xxx", "y y", "z z", 'x', new ItemStack(Item.ingotIron), 'y', new ItemStack(Item.glowstone), 'z', new ItemStack(Block.thinGlass));
		GameRegistry.addRecipe(new ItemStack(explodingPen), "x", "y", "z", 'x', new ItemStack(Item.redstone), 'y', new ItemStack(Item.gunpowder), 'z', new ItemStack(Item.ingotIron));
		GameRegistry.addRecipe(new ItemStack(jetpack), "xyx", 'x', new ItemStack(smallRocketEngine), 'y', new ItemStack(largeRocketEngine));
		GameRegistry.addRecipe(new ItemStack(jetpackControl), "x", "y", "y", 'x', new ItemStack(Item.ingotIron), 'y', new ItemStack(Item.redstone));
		
		//Register Entities
		EntityRegistry.registerModEntity(EntityThrowableHat.class, "Throwable Hat", ++throwableHatEntity, this, 64, 10, true);
		EntityRegistry.registerModEntity(EntityThrowingKnife.class, "Throwing Knife", ++throwingKnifeEntity, this, 64, 10, true);
		EntityRegistry.registerModEntity(EntityPoisonDart.class, "Poison Dart", ++poisonDartEntity, this, 100, 1, true);
		EntityRegistry.registerModEntity(EntityOddjobsHat.class, "Oddjob's Hat", ++oddjobsHatEntity, this, 64, 10, true);
		EntityRegistry.registerModEntity(EntityKunai.class, "Kunai", ++kunaiEntity, this, 64, 10, true);
		EntityRegistry.registerModEntity(EntityNinjaDart.class, "Ninja Dart", ++ninjaDartEntity, this, 100, 1, true);
		
		//Register Renderers
		proxy.registerRenderers();
		
	}
	
	@EventHandler
	public void postInit (FMLPostInitializationEvent event) {
		//Nothing
	}

}

