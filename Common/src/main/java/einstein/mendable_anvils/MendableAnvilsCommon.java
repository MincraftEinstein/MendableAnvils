package einstein.mendable_anvils;

import einstein.mendable_anvils.platform.Services;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AnvilBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

public class MendableAnvilsCommon {

    public static final String MOD_ID = "mendable_anvils";
    public static final Logger LOGGER = LogManager.getLogger();

    private static final Map<Block, Block> MEND_STAGES = Map.of(
            Blocks.CHIPPED_ANVIL, Blocks.ANVIL,
            Blocks.DAMAGED_ANVIL, Blocks.CHIPPED_ANVIL
    );

    public static void init() {
        DispenserBlock.registerBehavior(Items.IRON_INGOT, new MendAnvilDispenseItemBehavior());
    }

    public static InteractionResult onBlockClick(Player player, Level level, InteractionHand hand, BlockHitResult result) {
        ItemStack stack = player.getItemInHand(hand);
        BlockPos pos = result.getBlockPos();

        if (stack.is(Items.IRON_INGOT) && player.isShiftKeyDown()) {
            if (mendAnvil(level, pos)) {
                if (!player.isCreative()) {
                    stack.shrink(1);
                }

                if (Services.PLATFORM.getPlatformName().equals("Forge")) {
                    player.swing(hand, true);
                }

                level.playSound(null, pos, SoundEvents.ANVIL_LAND, SoundSource.BLOCKS, 1, 1);
                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.PASS;
    }

    public static boolean mendAnvil(Level level, BlockPos pos) {
        BlockState state = level.getBlockState(pos);
        Block block = state.getBlock();
        if (MEND_STAGES.containsKey(block)) {
            level.setBlockAndUpdate(pos, MEND_STAGES.get(block).defaultBlockState().setValue(AnvilBlock.FACING, state.getValue(AnvilBlock.FACING)));
            return true;
        }
        return false;
    }
}
