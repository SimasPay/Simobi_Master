
package com.mfino.hsm.thales.core;

import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jdom.JDOMException;

import java.io.*;
import java.util.Iterator;
import java.util.Map;

/**
 * Thales Message construction class. Uses the HThalesMsg for constructing the message
 * we use already existing implementation of Thales FSD message construction 
 * @author POCHADRI
 *
 */
public class ThalesISOMsg extends ISOMsg implements Cloneable  {
    ThalesMsg fsd;
    public  ThalesISOMsg () {
        super();
    }
    public ThalesISOMsg (ThalesMsg fsd) {
        super();
        this.fsd = fsd;
    }
    public String getMTI() {
        return getString(0);
    }
    public byte[] pack() throws ISOException {
        try {
            return fsd.packToBytes();
        } catch (Exception e) {
            throw new ISOException (e);
        }
    }
    public int unpack(byte[] b) throws ISOException {
        try {
            fsd.unpack (b);
            return b.length;
        } catch (Exception e) {
            throw new ISOException (e);
        }
    }
    public void unpack (InputStream in) throws IOException, ISOException {
        synchronized (this) {
            try {
                fsd.unpack(in);
            } catch (JDOMException e) {
                throw new ISOException (e);
            }
        }
    }

    public ThalesMsg getFSDMsg() {
        return fsd;
    }
    public String getString (int fldno) {
        return fsd.get (Integer.toString(fldno));
    }
    public boolean hasField (int fldno) {
        return getString(fldno) != null;
    }
    public void dump (PrintStream p, String indent) {
        if (fsd != null)
            fsd.dump (p, indent);
    }
    public void writeExternal (ObjectOutput out) throws IOException {
        out.writeByte (0);  // reserved for future expansion (version id)
        out.writeUTF (fsd.getBasePath());
        out.writeUTF (fsd.getBaseSchema());
        out.writeObject (fsd.getMap());
    }
    public void readExternal  (ObjectInput in) 
        throws IOException, ClassNotFoundException
    {
        in.readByte();  // ignore version for now
        String basePath = in.readUTF();
        String baseSchema = in.readUTF();
        fsd = new ThalesMsg (basePath, baseSchema);
        Map map = (Map) in.readObject();
        Iterator iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            fsd.set ((String) entry.getKey(), (String) entry.getValue());
        }
    }
    public Object clone() {
        ThalesISOMsg m = (ThalesISOMsg) super.clone();
        m.fsd = (ThalesMsg) fsd.clone();
        return m;
    }
    public Object clone(int[] fields) {
        ThalesISOMsg m = (ThalesISOMsg) super.clone();
        m.fsd = new ThalesMsg(fsd.getBasePath(), fsd.getBaseSchema());
        for (int i=0; i<fields.length; i++) {
            String f = Integer.toString(fields[i]);
            m.fsd.set (f, fsd.get (f));
        }
        return m;
    }
    public void merge (ISOMsg m) {
        if (m instanceof ThalesISOMsg) {
            fsd.merge (((ThalesISOMsg)m).getFSDMsg());
        } else {
            for (int i=0; i<=m.getMaxField(); i++) {
                if (m.hasField(i))
                    fsd.set (Integer.toString(i), m.getString(i));
            }
        }
    }
    public void setResponseMTI() {
        try {
            super.setResponseMTI();
        } catch (ISOException ignored) { }               
    }
    private static final long serialVersionUID = 1L;
}

