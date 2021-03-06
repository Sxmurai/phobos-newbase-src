// 
// Decompiled by Procyon v0.6-prerelease
// 

package org.newdawn.slick.muffin;

import java.net.*;
import org.newdawn.slick.util.*;
import javax.jnlp.*;
import java.util.*;
import java.io.*;

public class WebstartMuffin implements Muffin
{
    @Override
    public void saveFile(final HashMap scoreMap, final String fileName) throws IOException {
        PersistenceService ps;
        URL configURL;
        try {
            ps = (PersistenceService)ServiceManager.lookup("javax.jnlp.PersistenceService");
            final BasicService bs = (BasicService)ServiceManager.lookup("javax.jnlp.BasicService");
            final URL baseURL = bs.getCodeBase();
            configURL = new URL(baseURL, fileName);
        }
        catch (Exception e) {
            Log.error(e);
            throw new IOException("Failed to save state: ");
        }
        try {
            ps.delete(configURL);
        }
        catch (Exception e) {
            Log.info("No exisiting Muffin Found - First Save");
        }
        try {
            ps.create(configURL, 1024L);
            final FileContents fc = ps.get(configURL);
            final DataOutputStream oos = new DataOutputStream(fc.getOutputStream(false));
            final Set keys = scoreMap.keySet();
            for (final String key : keys) {
                oos.writeUTF(key);
                if (fileName.endsWith("Number")) {
                    final double value = scoreMap.get(key);
                    oos.writeDouble(value);
                }
                else {
                    final String value2 = scoreMap.get(key);
                    oos.writeUTF(value2);
                }
            }
            oos.flush();
            oos.close();
        }
        catch (Exception e) {
            Log.error(e);
            throw new IOException("Failed to store map of state data");
        }
    }
    
    @Override
    public HashMap loadFile(final String fileName) throws IOException {
        final HashMap hashMap = new HashMap();
        try {
            final PersistenceService ps = (PersistenceService)ServiceManager.lookup("javax.jnlp.PersistenceService");
            final BasicService bs = (BasicService)ServiceManager.lookup("javax.jnlp.BasicService");
            final URL baseURL = bs.getCodeBase();
            final URL configURL = new URL(baseURL, fileName);
            final FileContents fc = ps.get(configURL);
            final DataInputStream ois = new DataInputStream(fc.getInputStream());
            if (fileName.endsWith("Number")) {
                String key;
                while ((key = ois.readUTF()) != null) {
                    final double value = ois.readDouble();
                    hashMap.put(key, new Double(value));
                }
            }
            else {
                String key;
                while ((key = ois.readUTF()) != null) {
                    final String value2 = ois.readUTF();
                    hashMap.put(key, value2);
                }
            }
            ois.close();
        }
        catch (EOFException e) {}
        catch (IOException e2) {}
        catch (Exception e3) {
            Log.error(e3);
            throw new IOException("Failed to load state from webstart muffin");
        }
        return hashMap;
    }
}
