package einstein.mendable_anvils;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.OnDatapackSyncEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.server.ServerStartedEvent;
import net.minecraftforge.fml.common.Mod;

@Mod(MendableAnvilsCommon.MOD_ID)
public class MendableAnvilsForge {
    
    public MendableAnvilsForge() {
        MendableAnvilsCommon.init();
        MinecraftForge.EVENT_BUS.addListener(this::onBlockClick);
        MinecraftForge.EVENT_BUS.addListener((ServerStartedEvent event) -> MendableAnvilsCommon.onDatapackSync());
        MinecraftForge.EVENT_BUS.addListener((OnDatapackSyncEvent event) -> MendableAnvilsCommon.onDatapackSync());
    }

    private void onBlockClick(PlayerInteractEvent.RightClickBlock event) {
        MendableAnvilsCommon.onBlockClick(event.getEntity(), event.getLevel(), event.getHand(), event.getHitVec());
    }
}
