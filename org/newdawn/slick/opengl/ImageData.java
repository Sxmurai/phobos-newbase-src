// 
// Decompiled by Procyon v0.6-prerelease
// 

package org.newdawn.slick.opengl;

import java.nio.*;

public interface ImageData
{
    int getDepth();
    
    int getWidth();
    
    int getHeight();
    
    int getTexWidth();
    
    int getTexHeight();
    
    ByteBuffer getImageBufferData();
}
