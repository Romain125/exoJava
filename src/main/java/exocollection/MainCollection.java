package exocollection;

import sun.applet.resources.MsgAppletViewer_sv;

import java.util.*;

public class MainCollection {

    public static void main(String[] args) {
        ObjectHashCode o = new ObjectHashCode("toto", 0);
        ObjectHashCode o2 = new ObjectHashCode("toto", 0);
        System.out.println(o.equals(o2));
        o2.hashCode();

    }

}
