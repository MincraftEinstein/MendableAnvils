package einstein.mendable_anvils;

import net.minecraft.core.BlockPos;
import net.minecraft.core.dispenser.BlockSource;
import net.minecraft.core.dispenser.OptionalDispenseItemBehavior;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.DispenserBlock;

public class MendAnvilDispenseItemBehavior extends OptionalDispenseItemBehavior {

    @Override
    protected ItemStack execute(BlockSource source, ItemStack stack) {
        ServerLevel level = source.level();
        if (!level.isClientSide) {
            BlockPos pos = source.pos().relative(source.state().getValue(DispenserBlock.FACING));
            setSuccess(MendableAnvilsCommon.mendAnvil(level, pos));
            if (isSuccess()) {
                stack.shrink(1);
                level.playSound(null, pos, SoundEvents.ANVIL_LAND, SoundSource.BLOCKS, 1, 1);
                return stack;
            }
        }

        return super.execute(source, stack);
    }
}
