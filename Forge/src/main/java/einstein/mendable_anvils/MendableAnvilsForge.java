package einstein.mendable_anvils;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.OnDatapackSyncEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.server.ServerStartedEvent;
import net.minecraftforge.fml.common.Mod;

@Mod(MendableAnvils.MOD_ID)
public class MendableAnvilsForge {

    public MendableAnvilsForge() {
        MendableAnvils.init();
        MinecraftForge.EVENT_BUS.addListener((PlayerInteractEvent.RightClickBlock event) ->
                MendableAnvils.onBlockClick(event.getEntity(), event.getLevel(), event.getHand(), event.getHitVec()));
        MinecraftForge.EVENT_BUS.addListener((ServerStartedEvent event) -> MendableAnvils.onDatapackSync());
        MinecraftForge.EVENT_BUS.addListener((OnDatapackSyncEvent event) -> MendableAnvils.onDatapackSync());
    }
}
