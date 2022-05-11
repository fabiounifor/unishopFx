package util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class logutil {

    private static final String PATH_FILE = "C:\\UniShop\\dist\\Log\\";
    static Logger logger = Logger.getLogger("logutil");

    static FileHandler fh;
    static LoggerFormatter formatter = new LoggerFormatter();

    static {
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyy_MM_dd_HH_mm");
            final String filename = String.format("%s%s%s", PATH_FILE, df.format(new Date()), ".log");
            System.out.println("Arquivo de log: " + filename);

            fh = new FileHandler(filename);
            fh.setFormatter(formatter);
            logger.addHandler(fh);

            com.sun.jna.Native.setProtected(true);
            if (!com.sun.jna.Native.isProtected()) {
                //Sistema operacional não suportar proteção contra crash
                logger.warning("SISTEMA OPERACIONAL NÃO SUPORTA PROTEÇÃO A CRASH DE ERRO EM SISTEMA NATIVO");
            } else {
                logger.info("Sistema operacional suporta proteção a erro em codigo nativo");
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
