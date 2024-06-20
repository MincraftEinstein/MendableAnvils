package einstein.mendable_anvils;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;

public class MendableAnvilsFabric implements ModInitializer {
    
    @Override
    public void onInitialize() {
        MendableAnvils.init();
        UseBlockCallback.EVENT.register(MendableAnvils::onBlockClick);
        ServerLifecycleEvents.SERVER_STARTED.register(server -> MendableAnvils.onDatapackSync());
        ServerLifecycleEvents.END_DATA_PACK_RELOAD.register((server, resourceManager, success) -> MendableAnvils.onDatapackSync());
    }
}
