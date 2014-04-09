package mcmod.nxs.minextension.lib;

public class ResourcePathHelper {

	private static String resourcePath;
	public static ResourcePathHelper instance = new ResourcePathHelper();

	public void load(String resourcePath)
	{
		setTexturesPath(resourcePath);
	}

	public static String getResourcesPath()
	{
		return resourcePath;
	}

	public static void setTexturesPath(String texturesPath)
	{
		ResourcePathHelper.resourcePath = texturesPath;
	}
}
