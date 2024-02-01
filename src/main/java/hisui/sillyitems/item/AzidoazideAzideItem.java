package hisui.sillyitems.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class AzidoazideAzideItem extends Item {
    public AzidoazideAzideItem(Settings settings) {
        super(settings);
    }

    @Override
    public void onCraft(ItemStack stack, World world, PlayerEntity player) {
        if(!world.isClient()){
            if(player != null){
                Vec3d pos = player.getPos();
                world.createExplosion(null, pos.x, player.getBodyY(0.5), pos.z, Math.max(4F, stack.getCount()), World.ExplosionSourceType.NONE);
                stack.setCount(0);
            }
        }
        super.onCraft(stack, world, player);
    }
}