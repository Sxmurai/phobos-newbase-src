// 
// Decompiled by Procyon v0.6-prerelease
// 

package me.earth.earthhack.impl.modules.render.breadcrumbs.util;

import net.minecraft.util.math.*;
import java.util.*;
import net.minecraft.world.*;
import me.earth.earthhack.impl.util.math.*;

public class Trace
{
    private String name;
    private int index;
    private Vec3d pos;
    private List<TracePos> trace;
    private DimensionType type;
    
    public Trace(final int index, final String name, final DimensionType type, final Vec3d pos, final List<TracePos> trace) {
        this.index = index;
        this.name = name;
        this.type = type;
        this.pos = pos;
        this.trace = trace;
    }
    
    public int getIndex() {
        return this.index;
    }
    
    public DimensionType getType() {
        return this.type;
    }
    
    public List<TracePos> getTrace() {
        return this.trace;
    }
    
    public void setTrace(final List<TracePos> trace) {
        this.trace = trace;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(final String name) {
        this.name = name;
    }
    
    public void setPos(final Vec3d pos) {
        this.pos = pos;
    }
    
    public void setIndex(final int index) {
        this.index = index;
    }
    
    public Vec3d getPos() {
        return this.pos;
    }
    
    public void setType(final DimensionType type) {
        this.type = type;
    }
    
    public static class TracePos
    {
        private final Vec3d pos;
        private final StopWatch stopWatch;
        private long time;
        
        public TracePos(final Vec3d pos) {
            this.stopWatch = new StopWatch();
            this.pos = pos;
            this.stopWatch.reset();
        }
        
        public TracePos(final Vec3d pos, final long time) {
            this.stopWatch = new StopWatch();
            this.pos = pos;
            this.stopWatch.reset();
            this.time = time;
        }
        
        public Vec3d getPos() {
            return this.pos;
        }
        
        public boolean shouldRemoveTrace() {
            return this.stopWatch.passed(2000L);
        }
        
        public long getTime() {
            return this.time;
        }
    }
}
