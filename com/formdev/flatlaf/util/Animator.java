// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.formdev.flatlaf.util;

import javax.swing.*;
import com.formdev.flatlaf.*;
import java.util.*;
import java.awt.event.*;

public class Animator
{
    private int duration;
    private int resolution;
    private Interpolator interpolator;
    private final ArrayList<TimingTarget> targets;
    private final Runnable endRunnable;
    private boolean running;
    private boolean hasBegun;
    private boolean timeToStop;
    private long startTime;
    private Timer timer;
    
    public static boolean useAnimation() {
        return FlatSystemProperties.getBoolean("flatlaf.animation", true);
    }
    
    public Animator(final int duration) {
        this(duration, null, null);
    }
    
    public Animator(final int duration, final TimingTarget target) {
        this(duration, target, null);
    }
    
    public Animator(final int duration, final TimingTarget target, final Runnable endRunnable) {
        this.resolution = 10;
        this.targets = new ArrayList<TimingTarget>();
        this.setDuration(duration);
        this.addTarget(target);
        this.endRunnable = endRunnable;
    }
    
    public int getDuration() {
        return this.duration;
    }
    
    public void setDuration(final int duration) {
        this.throwExceptionIfRunning();
        if (duration <= 0) {
            throw new IllegalArgumentException();
        }
        this.duration = duration;
    }
    
    public int getResolution() {
        return this.resolution;
    }
    
    public void setResolution(final int resolution) {
        this.throwExceptionIfRunning();
        if (resolution <= 0) {
            throw new IllegalArgumentException();
        }
        this.resolution = resolution;
    }
    
    public Interpolator getInterpolator() {
        return this.interpolator;
    }
    
    public void setInterpolator(final Interpolator interpolator) {
        this.throwExceptionIfRunning();
        this.interpolator = interpolator;
    }
    
    public void addTarget(final TimingTarget target) {
        if (target == null) {
            return;
        }
        synchronized (this.targets) {
            if (!this.targets.contains(target)) {
                this.targets.add(target);
            }
        }
    }
    
    public void removeTarget(final TimingTarget target) {
        synchronized (this.targets) {
            this.targets.remove(target);
        }
    }
    
    public void start() {
        this.throwExceptionIfRunning();
        this.running = true;
        this.hasBegun = false;
        this.timeToStop = false;
        this.startTime = System.nanoTime() / 1000000L;
        if (this.timer == null) {
            this.timer = new Timer(this.resolution, e -> {
                if (!this.hasBegun) {
                    this.begin();
                    this.hasBegun = true;
                }
                this.timingEvent(this.getTimingFraction());
                return;
            });
        }
        else {
            this.timer.setDelay(this.resolution);
        }
        this.timer.setInitialDelay(0);
        this.timer.start();
    }
    
    public void stop() {
        this.stop(false);
    }
    
    public void cancel() {
        this.stop(true);
    }
    
    private void stop(final boolean cancel) {
        if (!this.running) {
            return;
        }
        if (this.timer != null) {
            this.timer.stop();
        }
        if (!cancel) {
            this.end();
        }
        this.running = false;
        this.timeToStop = false;
    }
    
    public void restart() {
        this.cancel();
        this.start();
    }
    
    public boolean isRunning() {
        return this.running;
    }
    
    private float getTimingFraction() {
        final long currentTime = System.nanoTime() / 1000000L;
        final long elapsedTime = currentTime - this.startTime;
        this.timeToStop = (elapsedTime >= this.duration);
        float fraction = this.clampFraction(elapsedTime / (float)this.duration);
        if (this.interpolator != null) {
            fraction = this.clampFraction(this.interpolator.interpolate(fraction));
        }
        return fraction;
    }
    
    private float clampFraction(final float fraction) {
        if (fraction < 0.0f) {
            return 0.0f;
        }
        if (fraction > 1.0f) {
            return 1.0f;
        }
        return fraction;
    }
    
    private void timingEvent(final float fraction) {
        synchronized (this.targets) {
            for (final TimingTarget target : this.targets) {
                target.timingEvent(fraction);
            }
        }
        if (this.timeToStop) {
            this.stop();
        }
    }
    
    private void begin() {
        synchronized (this.targets) {
            for (final TimingTarget target : this.targets) {
                target.begin();
            }
        }
    }
    
    private void end() {
        synchronized (this.targets) {
            for (final TimingTarget target : this.targets) {
                target.end();
            }
        }
        if (this.endRunnable != null) {
            this.endRunnable.run();
        }
    }
    
    private void throwExceptionIfRunning() {
        if (this.isRunning()) {
            throw new IllegalStateException();
        }
    }
    
    @FunctionalInterface
    public interface TimingTarget
    {
        void timingEvent(final float p0);
        
        default void begin() {
        }
        
        default void end() {
        }
    }
    
    @FunctionalInterface
    public interface Interpolator
    {
        float interpolate(final float p0);
    }
}
