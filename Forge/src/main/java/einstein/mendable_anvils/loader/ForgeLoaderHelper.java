package einstein.mendable_anvils.loader;

import einstein.mendable_anvils.loader.services.LoaderHelper;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.loading.FMLLoader;

public class ForgeLoaderHelper implements LoaderHelper {

    @Override
    public ModLoaderType getModLoader() {
        return ModLoaderType.FORGE;
    }

    @Override
    public boolean isModLoaded(String modId) {
        return ModList.get().isLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {
        return !FMLLoader.isProduction();
    }
}
