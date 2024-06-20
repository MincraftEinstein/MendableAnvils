package einstein.mendable_anvils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.OnDatapackSyncEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.event.server.ServerStartedEvent;

@Mod(MendableAnvils.MOD_ID)
public class MendableAnvilsNeoForge {

    public MendableAnvilsNeoForge(IEventBus eventBus) {
        MendableAnvils.init();
        NeoForge.EVENT_BUS.addListener((PlayerInteractEvent.RightClickBlock event) ->
                MendableAnvils.onBlockClick(event.getEntity(), event.getLevel(), event.getHand(), event.getHitVec()));
        NeoForge.EVENT_BUS.addListener((ServerStartedEvent event) -> MendableAnvils.onDatapackSync());
        NeoForge.EVENT_BUS.addListener((OnDatapackSyncEvent event) -> MendableAnvils.onDatapackSync());
    }
}
