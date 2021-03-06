// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.formdev.flatlaf.ui;

import java.awt.*;
import javax.swing.*;

public class FlatListCellBorder extends FlatLineBorder
{
    final boolean showCellFocusIndicator;
    
    protected FlatListCellBorder() {
        super(UIManager.getInsets("List.cellMargins"), UIManager.getColor("List.cellFocusColor"));
        this.showCellFocusIndicator = UIManager.getBoolean("List.showCellFocusIndicator");
    }
    
    public static class Default extends FlatListCellBorder
    {
        @Override
        public void paintBorder(final Component c, final Graphics g, final int x, final int y, final int width, final int height) {
        }
    }
    
    public static class Focused extends FlatListCellBorder
    {
    }
    
    public static class Selected extends FlatListCellBorder
    {
        @Override
        public void paintBorder(final Component c, final Graphics g, final int x, final int y, final int width, final int height) {
            if (!this.showCellFocusIndicator) {
                return;
            }
            final JList<?> list = (JList<?>)SwingUtilities.getAncestorOfClass(JList.class, c);
            if (list != null && list.getMinSelectionIndex() == list.getMaxSelectionIndex()) {
                return;
            }
            super.paintBorder(c, g, x, y, width, height);
        }
    }
}
