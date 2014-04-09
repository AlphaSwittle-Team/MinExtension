package mcmod.nxs.minextension.core;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TabHandler {

	public static CreativeTabs nxsTab = new CreativeTabs("MinExtension") {
		public Item getTabIconItem()
		{
			return ItemHandler.copper_ingot;
		}
	};
}
