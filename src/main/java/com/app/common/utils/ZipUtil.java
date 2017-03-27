package com.app.common.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * 压缩工具类
 * User: mark.zhu
 * Date: 5/16/14
 * Time: 5:18 PM
 */
public class ZipUtil {

    /**
     * 压缩
     *
     * @param src
     * @param out
     * @throws java.io.IOException
     */
    public static void compress(String src, OutputStream out) throws IOException {
        if (src == null) {
            return;
        }
        compress(src.getBytes(), out);
    }

    /**
     * 压缩
     *
     * @param src
     * @param out
     * @throws java.io.IOException
     */
    public static void compress(byte[] src, OutputStream out) throws IOException {
        if (src == null || src.length == 0 || out == null) {
            return;
        }
        ZipOutputStream zout = new ZipOutputStream(out);
        try {
            zout.putNextEntry(new ZipEntry("0"));
            zout.write(src);
            zout.closeEntry();
        } finally {
            close(zout);
        }
    }

    /**
     * 压缩
     *
     * @param src
     * @return
     * @throws java.io.IOException
     */
    public static byte[] compress(String src) throws IOException {
        if (src == null) {
            return null;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            compress(src, out);
            return out.toByteArray();
        } finally {
            close(out);
        }
    }

    /**
     * 压缩
     *
     * @param src
     * @return
     * @throws java.io.IOException
     */
    public static byte[] compress(byte[] src) throws IOException {
        if (src == null) {
            return null;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            compress(src, out);
            return out.toByteArray();
        } finally {
            close(out);
        }
    }

    /**
     * 解压缩
     *
     * @param buf
     * @param charSetName
     * @return
     * @throws IOException
     */
    public static String decompress(byte[] buf, String charSetName) throws IOException {
        if (buf == null || buf.length == 0) {
            return null;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ZipInputStream zin = new ZipInputStream(new ByteArrayInputStream(buf));
        try {
            zin.getNextEntry();
            byte[] buffer = new byte[1024];
            int offset = -1;
            while ((offset = zin.read(buffer)) != -1) {
                out.write(buffer, 0, offset);
            }
            return out.toString(charSetName);
        } finally {
            close(zin);
            close(out);
        }
    }

/*    public static String decompress(byte[] buf) throws IOException {
        return decompress(buf, ContextConstants.SYSTEM_DEFAULT_CHARSET);
    }
*/
    private static void close(Closeable v) {
        if (v != null) {
            try {
                v.close();
            } catch (Exception e) {
            }
        }
    }

}