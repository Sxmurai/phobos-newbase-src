// 
// Decompiled by Procyon v0.6-prerelease
// 

package org.newdawn.slick.util.pathfinding.heuristics;

import org.newdawn.slick.util.pathfinding.*;

public class ManhattanHeuristic implements AStarHeuristic
{
    private int minimumCost;
    
    public ManhattanHeuristic(final int minimumCost) {
        this.minimumCost = minimumCost;
    }
    
    @Override
    public float getCost(final TileBasedMap map, final Mover mover, final int x, final int y, final int tx, final int ty) {
        return (float)(this.minimumCost * (Math.abs(x - tx) + Math.abs(y - ty)));
    }
}
