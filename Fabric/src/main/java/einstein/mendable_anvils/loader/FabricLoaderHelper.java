package einstein.mendable_anvils.loader;

import einstein.mendable_anvils.loader.services.LoaderHelper;
import net.fabricmc.loader.api.FabricLoader;

public class FabricLoaderHelper implements LoaderHelper {

    @Override
    public ModLoaderType getModLoader() {
        return ModLoaderType.FABRIC;
    }

    @Override
    public boolean isModLoaded(String modId) {
        return FabricLoader.getInstance().isModLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {
        return FabricLoader.getInstance().isDevelopmentEnvironment();
    }
}
