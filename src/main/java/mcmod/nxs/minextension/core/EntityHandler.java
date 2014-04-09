package mcmod.nxs.minextension.core;

import mcmod.nxs.minextension.entity.hostile.EntityEnderCreeper;
import mcmod.nxs.minextension.entity.hostile.EntityEnderGolem;
import mcmod.nxs.minextension.entity.hostile.EntityNetherCreeper;
import mcmod.nxs.minextension.entity.hostile.EntityNetherSpider;
import mcmod.nxs.minextension.entity.hostile.EntityNetherman;
import mcmod.nxs.minextension.entity.passive.EntityArcher;
import mcmod.nxs.minextension.entity.passive.EntityDiamondGolem;
import mcmod.nxs.minextension.entity.passive.EntityGoldGolem;
import mcmod.nxs.minextension.entity.passive.EntityShield;
import mcmod.nxs.minextension.entity.passive.EntityWarrior;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import cpw.mods.fml.common.registry.EntityRegistry;

public class EntityHandler {

	public static EntityHandler instance()
	{
		return new EntityHandler();
	}

	public void load()
	{
		addEntities();
	}

	public void addEntities()
	{
		EntityRegistry.registerGlobalEntityID(EntityWarrior.class, "Warrior", EntityRegistry.findGlobalUniqueEntityId(), 0X613D06, 0X312616);
		EntityRegistry.addSpawn("Warrior", 25, 1, 1, EnumCreatureType.creature, BiomeGenBase.plains, BiomeGenBase.river);
		EntityRegistry.registerGlobalEntityID(EntityShield.class, "Shield", EntityRegistry.findGlobalUniqueEntityId(), 0X613D06, 0X286561);
		EntityRegistry.addSpawn("Shield", 25, 1, 1, EnumCreatureType.creature, BiomeGenBase.plains, BiomeGenBase.river);
		EntityRegistry.registerGlobalEntityID(EntityArcher.class, "Archer", EntityRegistry.findGlobalUniqueEntityId(), 0X613D06, 0XC30B0B);
		EntityRegistry.addSpawn("Archer", 25, 1, 1, EnumCreatureType.creature, BiomeGenBase.plains, BiomeGenBase.river);
		EntityRegistry.registerGlobalEntityID(EntityNetherSpider.class, "NetherSpider", EntityRegistry.findGlobalUniqueEntityId(), 0XC30B0B, 0X391A38);
		EntityRegistry.addSpawn("NetherSpider", 100, 1, 4, EnumCreatureType.monster, BiomeGenBase.hell);
		EntityRegistry.registerGlobalEntityID(EntityNetherCreeper.class, "NetherCreeper", EntityRegistry.findGlobalUniqueEntityId(), 0XC30B0B, 0X1EC30B);
		EntityRegistry.addSpawn("NetherCreeper", 100, 1, 4, EnumCreatureType.monster, BiomeGenBase.hell);
		EntityRegistry.registerGlobalEntityID(EntityNetherman.class, "Netherman", EntityRegistry.findGlobalUniqueEntityId(), 0XC30BB7, 0XC3110B);
		EntityRegistry.addSpawn("Netherman", 100, 1, 4, EnumCreatureType.monster, BiomeGenBase.hell);
		EntityRegistry.registerGlobalEntityID(EntityEnderCreeper.class, "EnderCreeper", EntityRegistry.findGlobalUniqueEntityId(), 0XC30BB7, 0X1EC30B);
		EntityRegistry.addSpawn("EnderCreeper", 50, 1, 1, EnumCreatureType.monster, BiomeGenBase.sky);
		EntityRegistry.registerGlobalEntityID(EntityEnderGolem.class, "EnderGolem", EntityRegistry.findGlobalUniqueEntityId(), 0XC30BB7, 0X286561);
		EntityRegistry.addSpawn("EnderGolem", 50, 1, 1, EnumCreatureType.monster, BiomeGenBase.sky);
		EntityRegistry.registerGlobalEntityID(EntityGoldGolem.class, "GoldGolem", EntityRegistry.findGlobalUniqueEntityId());
		EntityRegistry.registerGlobalEntityID(EntityDiamondGolem.class, "DiamondGolem", EntityRegistry.findGlobalUniqueEntityId());
	}
}
