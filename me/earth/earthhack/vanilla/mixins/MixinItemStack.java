//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\aesthetical\Documents\Development\Tools\Minecraft-Clients\1.12.2 mappings"!

// 
// Decompiled by Procyon v0.6-prerelease
// 

package me.earth.earthhack.vanilla.mixins;

import me.earth.earthhack.api.cache.*;
import me.earth.earthhack.impl.modules.misc.truedurability.*;
import org.spongepowered.asm.mixin.*;
import net.minecraft.item.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import me.earth.earthhack.impl.modules.*;
import org.spongepowered.asm.mixin.injection.*;
import net.minecraft.nbt.*;

@Mixin({ ItemStack.class })
public abstract class MixinItemStack
{
    private static ModuleCache<TrueDurability> trueDurability;
    @Shadow
    int itemDamage;
    
    @Inject(method = { "<init>(Lnet/minecraft/item/Item;II)V" }, at = { @At("RETURN") })
    private void initHook(final Item itemIn, final int amount, final int meta, final CallbackInfo ci) {
        if (MixinItemStack.trueDurability == null) {
            MixinItemStack.trueDurability = Caches.getModule(TrueDurability.class);
        }
        this.itemDamage = this.checkDurability(this.itemDamage, meta);
    }
    
    @Inject(method = { "<init>(Lnet/minecraft/nbt/NBTTagCompound;)V" }, at = { @At("RETURN") })
    private void initHook1(final NBTTagCompound compound, final CallbackInfo info) {
        if (MixinItemStack.trueDurability == null) {
            MixinItemStack.trueDurability = Caches.getModule(TrueDurability.class);
        }
        this.itemDamage = this.checkDurability(this.itemDamage, compound.getShort("Damage"));
    }
    
    private int checkDurability(final int damage, final int meta) {
        int durability = damage;
        if (MixinItemStack.trueDurability != null && MixinItemStack.trueDurability.isEnabled() && meta < 0) {
            durability = meta;
        }
        return durability;
    }
}
