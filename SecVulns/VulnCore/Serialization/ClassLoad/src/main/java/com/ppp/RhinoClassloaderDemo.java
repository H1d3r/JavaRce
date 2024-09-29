package com.ppp;

import com.ppp.tools.encryption.B64;

/**
 * @author Whoopsunix
 */
public class RhinoClassloaderDemo {
    public static void main(String[] args) throws Exception {
        String b64Str = new B64().encodeJavaClass(Exec.class);
        defineClass_rhino(b64Str, "org.example.Exec");
    }

    // org.mozilla.javascript.DefiningClassLoader
    public static void defineClass_rhino(String calcBase64, String className) throws Exception {

        byte[] bytes = java.util.Base64.getDecoder().decode(calcBase64);
        System.out.println(bytes.length);

        org.mozilla.javascript.DefiningClassLoader definingClassLoader = new org.mozilla.javascript.DefiningClassLoader();
        Class clazz = definingClassLoader.defineClass(className, bytes);
        clazz.newInstance();
    }
}
