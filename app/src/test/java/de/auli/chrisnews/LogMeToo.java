package de.auli.chrisnews;

/**
 * Ein einfacher Logger, der das System.out.println vereinfacht.
 */
public class LogMeToo {
    public static void debug(String msg, Object value){
        System.out.println(String.format(msg, value));
    }
    public static void debug(String msg){
        System.out.println(msg);
    }
}
