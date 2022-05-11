/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

/**
 *
 * @author Fabio
 */
public class LoggerFormatter extends Formatter {

    private static final String PATTERN = "yyyy-MM-dd HH:mm:sss";

    @Override
    public String format(LogRecord record) {
        return String.format("%1$s %2$-7s:%3$s\n",
                new SimpleDateFormat(PATTERN).format(
                        new Date(record.getMillis())
                ),
                record.getLevel().getName(),
                formatMessage(record)
        );
    }

}
