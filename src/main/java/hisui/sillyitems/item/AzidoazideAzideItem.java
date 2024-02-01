package hisui.sillyitems.item;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class AzidoazideAzideItem extends Item {
    public AzidoazideAzideItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable(this.getTranslationKey()+".desc").setStyle(Style.EMPTY.withColor(Formatting.GRAY)));
        super.appendTooltip(stack, world, tooltip, context);
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