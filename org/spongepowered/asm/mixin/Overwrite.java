// 
// Decompiled by Procyon v0.6-prerelease
// 

package org.spongepowered.asm.mixin;

import java.lang.annotation.*;

@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Overwrite {
    String constraints() default "";
    
    String[] aliases() default {};
    
    boolean remap() default true;
}
