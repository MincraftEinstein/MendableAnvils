package einstein.mendable_anvils.loader.services;

public interface LoaderHelper {

    ModLoaderType getModLoader();

    boolean isModLoaded(String modId);

    boolean isDevelopmentEnvironment();

    enum ModLoaderType {
        FORGE,
        FABRIC;

        public boolean isForge() {
            return this == FORGE;
        }

        public boolean isFabric() {
            return this == FABRIC;
        }
    }
}
