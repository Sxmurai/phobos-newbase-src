// 
// Decompiled by Procyon v0.6-prerelease
// 

package me.earth.earthhack.impl.modules.combat.autocrystal.util;

import java.util.*;

public class ForceData
{
    private final Set<ForcePosition> forceData;
    private boolean possibleHighDamage;
    private boolean possibleAntiTotem;
    
    public ForceData() {
        this.forceData = new TreeSet<ForcePosition>();
    }
    
    public boolean hasPossibleHighDamage() {
        return this.possibleHighDamage;
    }
    
    public void setPossibleHighDamage(final boolean possibleHighDamage) {
        this.possibleHighDamage = possibleHighDamage;
    }
    
    public boolean hasPossibleAntiTotem() {
        return this.possibleAntiTotem;
    }
    
    public void setPossibleAntiTotem(final boolean possibleAntiTotem) {
        this.possibleAntiTotem = possibleAntiTotem;
    }
    
    public Set<ForcePosition> getForceData() {
        return this.forceData;
    }
}
