// 
// Decompiled by Procyon v0.6-prerelease
// 

package org.newdawn.slick.gui;

import org.newdawn.slick.*;
import org.newdawn.slick.opengl.*;
import org.lwjgl.input.*;

public interface GUIContext
{
    Input getInput();
    
    long getTime();
    
    int getScreenWidth();
    
    int getScreenHeight();
    
    int getWidth();
    
    int getHeight();
    
    Font getDefaultFont();
    
    void setMouseCursor(final String p0, final int p1, final int p2) throws SlickException;
    
    void setMouseCursor(final ImageData p0, final int p1, final int p2) throws SlickException;
    
    void setMouseCursor(final Cursor p0, final int p1, final int p2) throws SlickException;
    
    void setDefaultMouseCursor();
}
