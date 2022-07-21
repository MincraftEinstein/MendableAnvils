package einstein.mendable_anvils;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod;

@Mod(MendableAnvilsCommon.MODID)
public class MendableAnvilsForge {
    
    public MendableAnvilsForge() {
        MendableAnvilsCommon.init();
        MinecraftForge.EVENT_BUS.addListener(this::onBlockClick);
    }

    private void onBlockClick(PlayerInteractEvent.RightClickBlock event) {
        MendableAnvilsCommon.onBlockClick(event.getEntity(), event.getLevel(), event.getHand(), event.getHitVec());
    }
}
