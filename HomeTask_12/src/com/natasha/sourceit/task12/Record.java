package com.natasha.sourceit.task12;

import java.io.*;

/**
 * Created by Stas on 13.11.2016.
 */
public class Record {
    public static void recordToFile(String fname)throws IOException{
        OutputStream os = null;
        try {
            os = new BufferedOutputStream(new FileOutputStream(fname), 256);
            byte[] array = new byte[]{12, 0, -8, 52, 54, -20, 100, -50};
            os.write(array);
            os.write("\nnew line: ".getBytes());
            os.write(2000);
            os.flush();
        } finally {
            if (os != null) os.close();
        }
    }

    public static final void recordIntToFile(int v, String fname) throws IOException {
        ObjectOutputStream os = null;
        try {
            os = new ObjectOutputStream(new FileOutputStream(fname));
            os.writeInt(v);
        } finally {
            os.close();
        }
    }

}
