// 
// Decompiled by Procyon v0.6-prerelease
// 

package org.spongepowered.asm.mixin.injection.throwables;

import org.spongepowered.asm.mixin.injection.struct.*;

public class InjectionValidationException extends Exception
{
    private static final long serialVersionUID = 1L;
    private final InjectorGroupInfo group;
    
    public InjectionValidationException(final InjectorGroupInfo group, final String message) {
        super(message);
        this.group = group;
    }
    
    public InjectorGroupInfo getGroup() {
        return this.group;
    }
}
