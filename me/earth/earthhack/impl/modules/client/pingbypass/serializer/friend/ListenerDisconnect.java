// 
// Decompiled by Procyon v0.6-prerelease
// 

package me.earth.earthhack.impl.modules.client.pingbypass.serializer.friend;

import me.earth.earthhack.api.event.bus.*;
import me.earth.earthhack.impl.event.events.network.*;

final class ListenerDisconnect extends EventListener<DisconnectEvent>
{
    private final FriendSerializer serializer;
    
    public ListenerDisconnect(final FriendSerializer serializer) {
        super(DisconnectEvent.class);
        this.serializer = serializer;
    }
    
    @Override
    public void invoke(final DisconnectEvent event) {
        this.serializer.clear();
    }
}
