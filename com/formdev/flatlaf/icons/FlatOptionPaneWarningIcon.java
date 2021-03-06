// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.formdev.flatlaf.icons;

import java.awt.*;
import com.formdev.flatlaf.ui.*;
import java.awt.geom.*;

public class FlatOptionPaneWarningIcon extends FlatOptionPaneAbstractIcon
{
    public FlatOptionPaneWarningIcon() {
        super("OptionPane.icon.warningColor", "Actions.Yellow");
    }
    
    @Override
    protected Shape createOutside() {
        return FlatUIUtils.createPath(16.0, 2.0, 31.0, 28.0, 1.0, 28.0);
    }
    
    @Override
    protected Shape createInside() {
        final Path2D inside = new Path2D.Float(0);
        inside.append(new Rectangle2D.Float(14.0f, 10.0f, 4.0f, 8.0f), false);
        inside.append(new Rectangle2D.Float(14.0f, 21.0f, 4.0f, 4.0f), false);
        return inside;
    }
}
