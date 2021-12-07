// 
// Decompiled by Procyon v0.6-prerelease
// 

package org.newdawn.slick.opengl;

import org.newdawn.slick.opengl.renderer.*;

public final class GLUtils
{
    public static void checkGLContext() {
        try {
            Renderer.get().glGetError();
        }
        catch (NullPointerException e) {
            throw new RuntimeException("OpenGL based resources (images, fonts, sprites etc) must be loaded as part of init() or the game loop. They cannot be loaded before initialisation.");
        }
    }
}
