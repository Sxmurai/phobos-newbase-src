// 
// Decompiled by Procyon v0.6-prerelease
// 

package me.earth.earthhack.impl.commands.packet.array;

import me.earth.earthhack.impl.commands.packet.*;
import me.earth.earthhack.impl.commands.packet.exception.*;
import me.earth.earthhack.api.command.*;
import me.earth.earthhack.impl.commands.packet.arguments.*;

public class ByteArrayArgument extends AbstractArgument<byte[]>
{
    private static final PacketArgument<Byte> PARSER;
    
    public ByteArrayArgument() {
        super(byte[].class);
    }
    
    @Override
    public byte[] fromString(final String argument) throws ArgParseException {
        final String[] split = argument.split("]");
        final byte[] array = new byte[split.length];
        for (int i = 0; i < split.length; ++i) {
            array[i] = ByteArrayArgument.PARSER.fromString(split[i]);
        }
        return array;
    }
    
    @Override
    public PossibleInputs getPossibleInputs(final String argument) {
        if (argument == null || argument.isEmpty()) {
            return PossibleInputs.empty().setRest("<Byte]Byte...>");
        }
        return PossibleInputs.empty();
    }
    
    static {
        PARSER = new ByteArgument();
    }
}
