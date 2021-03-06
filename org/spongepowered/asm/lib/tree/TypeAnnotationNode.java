// 
// Decompiled by Procyon v0.6-prerelease
// 

package org.spongepowered.asm.lib.tree;

import org.spongepowered.asm.lib.*;

public class TypeAnnotationNode extends AnnotationNode
{
    public int typeRef;
    public TypePath typePath;
    
    public TypeAnnotationNode(final int typeRef, final TypePath typePath, final String desc) {
        this(327680, typeRef, typePath, desc);
        if (this.getClass() != TypeAnnotationNode.class) {
            throw new IllegalStateException();
        }
    }
    
    public TypeAnnotationNode(final int api, final int typeRef, final TypePath typePath, final String desc) {
        super(api, desc);
        this.typeRef = typeRef;
        this.typePath = typePath;
    }
}
