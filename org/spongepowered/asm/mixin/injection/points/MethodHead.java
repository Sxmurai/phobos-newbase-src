// 
// Decompiled by Procyon v0.6-prerelease
// 

package org.spongepowered.asm.mixin.injection.points;

import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.struct.*;
import java.util.*;
import org.spongepowered.asm.lib.tree.*;

@AtCode("HEAD")
public class MethodHead extends InjectionPoint
{
    public MethodHead(final InjectionPointData data) {
        super(data);
    }
    
    @Override
    public boolean checkPriority(final int targetPriority, final int ownerPriority) {
        return true;
    }
    
    @Override
    public boolean find(final String desc, final InsnList insns, final Collection<AbstractInsnNode> nodes) {
        nodes.add(insns.getFirst());
        return true;
    }
}
