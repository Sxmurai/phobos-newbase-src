// 
// Decompiled by Procyon v0.6-prerelease
// 

package org.spongepowered.asm.mixin;

import java.lang.annotation.*;

@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Shadow {
    String prefix() default "shadow$";
    
    boolean remap() default true;
    
    String[] aliases() default {};
}
