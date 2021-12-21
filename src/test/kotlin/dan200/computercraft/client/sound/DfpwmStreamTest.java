/*
 * This file is part of ComputerCraft - http://www.computercraft.info
 * Copyright Daniel Ratcliffe, 2011-2021. Do not distribute without permission.
 * Send enquiries to dratcliffe@gmail.com
 */
package dan200.computercraft.client.sound;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import org.junit.jupiter.api.Test;

import java.nio.ByteBuffer;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DfpwmStreamTest
{
    @Test
    public void testDecodesBytes()
    {
        DfpwmStream stream = new DfpwmStream();

        ByteBuf input = ByteBufAllocator.DEFAULT.buffer();
        input.writeBytes( new byte[] { 43, -31, 33, 44, 30, -16, -85, 23, -3, -55, 46, -70, 68, -67, 74, -96, -68, 16, 94, -87, -5, 87, 11, -16, 19, 92, 85, -71, 126, 5, -84, 64, 17, -6, 85, -11, -1, -87, -12, 1, 85, -56, 33, -80, 82, 104, -93, 17, 126, 23, 91, -30, 37, -32, 117, -72, -58, 11, -76, 19, -108, 86, -65, -10, -1, -68, -25, 10, -46, 85, 124, -54, 15, -24, 43, -94, 117, 63, -36, 15, -6, 88, 87, -26, -83, 106, 41, 13, -28, -113, -10, -66, 119, -87, -113, 68, -55, 40, -107, 62, 20, 72, 3, -96, 114, -87, -2, 39, -104, 30, 20, 42, 84, 24, 47, 64, 43, 61, -35, 95, -65, 42, 61, 42, -50, 4, -9, 81 } );
        stream.push( input );

        byte[] values = new byte[1024];
        ByteBuffer buffer = stream.read( 2048 );
        assertEquals( 1024, buffer.remaining(), "Must have read 1024 bytes" );
        buffer.get( values );
        assertEquals( 0, buffer.remaining() );

        assertArrayEquals(
            new byte[] { -127, -126, -126, -126, -126, -126, -126, -127, -127, -127, -128, 127, 126, 126, 127, -128, -127, -128, 127, 125, 123, 123, 123, 121, 119, 117, 117, 119, 119, 119, 119, 118, 116, 116, 118, 120, 122, 122, 120, 118, 116, 114, 112, 110, 111, 113, 116, 119, 122, 125, 126, 126, 126, 126, 126, 126, -128, -125, -122, -121, -121, -121, -124, -127, -127, -127, -127, -125, -123, -121, -119, -116, -113, -113, -116, -116, -116, -119, -119, -117, -116, -116, -114, -112, -111, -111, -111, -114, -117, -117, -117, -118, -116, -114, -114, -115, -115, -118, -119, -119, -121, -123, -124, -124, -124, -124, -124, -122, -120, -118, -118, -118, -118, -118, -118, -118, -119, -120, -120, -120, -121, -122, -124, -126, -128, -128, -128, -128, -128, 127, 127, -128, -127, -125, -125, -125, -125, -126, -128, 126, 126, 126, 125, 123, 121, 121, 123, 125, 127, 127, 127, 127, 127, 127, 126, 126, 127, 127, 127, 127, -128, -127, -127, -127, -126, -125, -124, -123, -122, -121, -119, -119, -119, -119, -119, -119, -119, -118, -118, -118, -118, -119, -120, -121, -122, -124, -126, -128, -128, -126, -124, -122, -120, -118, -118, -120, -121, -121, -123, -125, -127, 127, -128, -126, -124, -123, -123, -123, -124, -124, -124, -124, -124, -124, -124, -124, -124, -124, -125, -125, -124, -123, -123, -123, -123, -123, -122, -121, -120, -119, -118, -119, -119, -119, -119, -119, -120, -121, -122, -123, -125, -127, -127, -125, -125, -125, -125, -125, -125, -126, -127, -128, 127, 125, 125, 125, 125, 126, 125, 124, 124, 125, 124, 123, 122, 122, 123, 123, 124, 125, 126, -128, -126, -126, -126, -126, -126, -126, -126, -126, -126, -126, -126, -126, -126, -125, -124, -123, -122, -121, -120, -118, -116, -114, -112, -110, -108, -108, -111, -112, -112, -113, -113, -113, -113, -115, -115, -115, -115, -114, -113, -112, -110, -110, -112, -114, -116, -118, -120, -123, -123, -123, -124, -124, -124, -124, -124, -124, -126, -128, 126, 126, 126, 124, 124, 126, -128, -128, 126, 124, 122, 122, 122, 120, 118, 116, 114, 112, 113, 115, 116, 117, 117, 117, 117, 115, 115, 115, 115, 115, 114, 112, 110, 110, 110, 110, 112, 112, 112, 114, 115, 114, 113, 113, 114, 114, 116, 117, 116, 115, 115, 116, 115, 114, 113, 113, 115, 117, 119, 121, 123, 123, 123, 125, 127, 127, 127, 127, 125, 123, 123, 125, 125, 125, 127, 127, 127, 127, 125, 125, 125, 124, 122, 122, 124, 126, -128, -128, -128, -128, 126, 126, 126, 125, 123, 121, 119, 117, 115, 115, 117, 119, 121, 122, 122, 122, 122, 124, 126, 126, 124, 122, 120, 121, 123, 125, 126, 126, 126, 126, -128, -128, 126, 124, 124, 126, -128, -126, -126, -127, -127, 127, 125, 123, 121, 118, 118, 118, 118, 120, 121, 121, 123, 125, 126, 124, 124, 124, 122, 120, 118, 116, 116, 116, 116, 116, 114, 115, 115, 115, 117, 117, 117, 117, 117, 117, 117, 119, 121, 123, 125, 127, 127, 127, 127, 127, -127, -127, -127, -126, -124, -122, -120, -118, -116, -114, -112, -110, -108, -106, -106, -109, -110, -108, -106, -104, -105, -106, -104, -102, -100, -101, -104, -105, -103, -100, -100, -100, -101, -102, -102, -105, -108, -111, -114, -114, -114, -117, -117, -117, -117, -115, -113, -112, -112, -112, -113, -113, -114, -114, -116, -118, -119, -117, -115, -113, -111, -111, -114, -115, -115, -116, -116, -118, -119, -117, -115, -113, -111, -109, -109, -112, -115, -118, -121, -124, -127, -127, -126, -126, -124, -121, -118, -115, -115, -115, -116, -116, -116, -119, -122, -122, -122, -125, -128, -128, -128, -128, -126, -125, -125, -125, -125, -123, -121, -121, -121, -119, -117, -115, -113, -110, -110, -113, -116, -119, -120, -118, -115, -115, -115, -113, -110, -107, -104, -101, -101, -105, -109, -113, -117, -118, -119, -119, -116, -112, -109, -106, -105, -109, -114, -115, -112, -112, -113, -113, -114, -111, -108, -108, -109, -109, -110, -111, -114, -115, -113, -113, -116, -117, -115, -112, -109, -109, -110, -108, -108, -109, -110, -110, -111, -111, -112, -112, -112, -113, -111, -111, -112, -112, -115, -116, -116, -117, -117, -119, -119, -119, -119, -117, -117, -119, -121, -123, -125, -127, -127, -127, 127, 127, -127, -125, -123, -121, -119, -117, -116, -119, -122, -122, -122, -122, -120, -120, -121, -119, -117, -115, -115, -116, -114, -112, -110, -108, -108, -108, -106, -104, -102, -103, -103, -101, -99, -100, -101, -102, -105, -106, -106, -107, -107, -108, -106, -104, -102, -100, -101, -104, -107, -107, -107, -110, -111, -111, -114, -117, -117, -117, -118, -118, -121, -122, -122, -124, -125, -123, -123, -125, -127, -127, -127, -127, -127, 127, 127, 127, 127, 127, 127, -128, 127, 127, -128, -128, -127, -126, -125, -124, -125, -127, 127, 125, 125, 125, 125, 126, 125, 124, 122, 120, 118, 118, 118, 116, 116, 116, 116, 118, 118, 117, 116, 114, 112, 110, 108, 106, 104, 102, 100, 101, 101, 102, 102, 103, 103, 101, 102, 104, 106, 106, 106, 106, 104, 104, 104, 104, 105, 105, 106, 106, 107, 108, 109, 111, 113, 115, 117, 119, 121, 121, 119, 119, 119, 117, 115, 113, 111, 112, 114, 115, 113, 114, 114, 114, 116, 118, 120, 121, 119, 117, 115, 113, 114, 114, 115, 115, 113, 111, 109, 110, 110, 111, 111, 112, 112, 110, 108, 106, 107, 107, 107, 107, 107, 108, 107, 106, 104, 104, 106, 106, 104, 102, 103, 105, 107, 109, 110, 111, 111, 109, 107, 105, 103, 101, 99, 97, 98, 99, 100, 102, 103, 104, 104, 105, 105, 103, 104, 104, 104, 106, 108, 110, 110, 108, 108, 108, 108, 110, 112, 112, 112, 114, 116, 118, 120, 122, 124, 124, 124, 124, 124, 126, -128, -126, -124, -122, -122, -123, -123, -123, -123, -123, -123, -123, -123, -125, -125, -125, -125, -124, -123, -122, -123, -125, -127, -127, -127, -127, -127, -127, -127, -128, 127, 127, -128, -127, -127, -128, -128, -127, -127, -128, -128, -128, 127, 126, 125, 124, 124, 126, -128, -128, -128, -127, -125, -123, -121, -121, -123, -125, -125, -125, -125, -125 },
            values,
            "Decoded values must match."
        );
    }
}