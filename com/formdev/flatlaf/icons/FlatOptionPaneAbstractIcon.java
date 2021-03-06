// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.formdev.flatlaf.icons;

import com.formdev.flatlaf.ui.*;
import javax.swing.*;
import java.awt.geom.*;
import java.awt.*;

public abstract class FlatOptionPaneAbstractIcon extends FlatAbstractIcon
{
    protected final Color foreground;
    
    protected FlatOptionPaneAbstractIcon(final String colorKey, final String defaultColorKey) {
        super(32, 32, FlatUIUtils.getUIColor(colorKey, defaultColorKey));
        this.foreground = UIManager.getColor("OptionPane.icon.foreground");
    }
    
    @Override
    protected void paintIcon(final Component c, final Graphics2D g) {
        if (this.foreground != null) {
            g.fill(this.createOutside());
            g.setColor(this.foreground);
            g.fill(this.createInside());
        }
        else {
            final Path2D path = new Path2D.Float(0);
            path.append(this.createOutside(), false);
            path.append(this.createInside(), false);
            g.fill(path);
        }
    }
    
    protected abstract Shape createOutside();
    
    protected abstract Shape createInside();
}
