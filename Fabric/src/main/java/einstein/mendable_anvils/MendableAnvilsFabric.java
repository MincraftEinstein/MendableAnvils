package einstein.mendable_anvils;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;

public class MendableAnvilsFabric implements ModInitializer {
    
    @Override
    public void onInitialize() {
        MendableAnvilsCommon.init();
        UseBlockCallback.EVENT.register(MendableAnvilsCommon::onBlockClick);
    }
}
