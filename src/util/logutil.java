package util;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class logutil {

    static Logger logger = Logger.getLogger("logutil");
//    static final String logFilePath = "C:/temp/logutil.log";
    static final String logFilePath = "C:\\UniShop\\dist\\Log\\logutil.log";

    static FileHandler fh;

    static {
        try {
            fh = new FileHandler(logFilePath);
            fh.setFormatter(new SimpleFormatter());
            logger.addHandler(fh);

            com.sun.jna.Native.setProtected(true);
            if (!com.sun.jna.Native.isProtected()) {
                //Sistema operacional não suportar proteção contra crash
                logger.warning("SISTEMA OPERACIONAL NÃO SUPORTA PROTEÇÃO A CRASH DE ERRO EM SISTEMA NATIVO");
            } else {
                logger.info("Sistem operacional suporta proteção a erro em codigo nativo");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Log está desligado, erro: " + e.getMessage());
        }
    }

    public static void info(String info) {
        log(Level.INFO, info);
    }

    public static void error(String strErro, Throwable e) {
        logger.log(Level.WARNING, strErro, e);
    }

    public static void error(Throwable e) {
        log(Level.WARNING, "", e);
    }

    public static void log(Level level, String msg) {
        try {
            logger.log(level, msg);
        } catch (Exception e) {

        }
    }

    public static void log(Level level, String msg, Throwable ex) {
        try {
            logger.log(level, msg, ex);
        } catch (Exception e) {

        }
    }
}
