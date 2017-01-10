package com.natasha.sourceit.game.drawing;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

/**
 * This is from the StackOverflow to make DOS output work on Windows
 */
public class DrawingUtils {
    static {
        ByteBuffer bb = ByteBuffer.wrap(new byte[]{(byte)186, (byte)205, (byte)201, (byte)187, (byte)188, (byte)200, (byte)219, (byte)197});
        CharBuffer cb = Charset.forName("Cp437").decode(bb);
        ASCII_205 = cb.get(1);
        ASCII_186 = cb.get(0);
        ASCII_201 = cb.get(2);
        ASCII_187 = cb.get(3);
        ASCII_188 = cb.get(4);
        ASCII_200 = cb.get(5);
        ASCII_219 = cb.get(6);
        ASCII_197 = cb.get(7);
    }

    public static final char ASCII_205;
    public static final char ASCII_186;
    public static final char ASCII_201;
    public static final char ASCII_187;
    public static final char ASCII_188;
    public static final char ASCII_200;
    public static final char ASCII_219;
    public static final char ASCII_197;


}
