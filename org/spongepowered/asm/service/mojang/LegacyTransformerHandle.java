// 
// Decompiled by Procyon v0.6-prerelease
// 

package org.spongepowered.asm.service.mojang;

import org.spongepowered.asm.service.*;
import net.minecraft.launchwrapper.*;
import javax.annotation.*;

class LegacyTransformerHandle implements ILegacyClassTransformer
{
    private final IClassTransformer transformer;
    
    LegacyTransformerHandle(final IClassTransformer transformer) {
        this.transformer = transformer;
    }
    
    @Override
    public String getName() {
        return this.transformer.getClass().getName();
    }
    
    @Override
    public boolean isDelegationExcluded() {
        return this.transformer.getClass().getAnnotation(Resource.class) != null;
    }
    
    @Override
    public byte[] transformClassBytes(final String name, final String transformedName, final byte[] basicClass) {
        return this.transformer.transform(name, transformedName, basicClass);
    }
}
