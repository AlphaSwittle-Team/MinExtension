package mcmod.nxs.minextension;

import mcmod.nxs.minextension.core.ArmorHandler;
import mcmod.nxs.minextension.core.BlockHandler;
import mcmod.nxs.minextension.core.CraftingHandler;
import mcmod.nxs.minextension.core.EnchantmentHandler;
import mcmod.nxs.minextension.core.EntityHandler;
import mcmod.nxs.minextension.core.ItemHandler;
import mcmod.nxs.minextension.core.ToolHandler;
import mcmod.nxs.minextension.event.DropEvent;
import mcmod.nxs.minextension.event.UpdateEvent;
import mcmod.nxs.minextension.gen.WorldGenHandler;
import mcmod.nxs.minextension.lib.ResourcePathHelper;
import mcmod.nxs.minextension.proxy.CommonProxy;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = MainClass.MODID, name = MainClass.NAME, version = MainClass.VERSION)
public class MainClass {
	public static final String MODID = "minextension";
	public static final String NAME = "MinExtension";
	public static final String VERSION = "0.1";
	public static final String TEXTURES_PATH = "minextension:";
	public static final String CLIENT_PROXY_PATH = "mcmod.nxs.minextension.proxy.ClientProxy";
	public static final String COMMON_PROXY_PATH = "mcmod.nxs.minextension.proxy.CommonProxy";
	@SidedProxy(clientSide = MainClass.CLIENT_PROXY_PATH, serverSide = MainClass.COMMON_PROXY_PATH)
	public static CommonProxy proxy;
	@Instance(MainClass.MODID)
	public static MainClass instance;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		ResourcePathHelper.instance.load(TEXTURES_PATH);
		proxy.registerEntityRender();
		proxy.registerItemRender();
		BlockHandler.instance().load();
		ItemHandler.instance().load();
		ToolHandler.instance().load();
		EntityHandler.instance().load();
		ArmorHandler.instance().load();
		EnchantmentHandler.instance().load();
		GameRegistry.registerWorldGenerator(new WorldGenHandler(), 0);
		MinecraftForge.EVENT_BUS.register(new DropEvent());
		MinecraftForge.EVENT_BUS.register(new UpdateEvent());
	}

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		CraftingHandler.instance().load();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{

	}

}
