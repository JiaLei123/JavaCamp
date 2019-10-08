package com.jialei.myspringboot.util;

import org.slf4j.Logger;
import org.slf4j.MDC;

/**
 *
 * @author jialei
 * @version : LoggerUtil.java, v 0.1 2019年09月30日 16:24 jialei Exp $
 */
public class LoggerUtil {

    //private static final Logger logger = LoggerFactory.getLogger(LoggerUtil.class);

    public static void error(Logger logger, String msg) {
        handelMDC();
        if (logger.isErrorEnabled()) {
            logger.error(msg);
        }
    }

    private static void handelMDC(){
        MDC.put("UUID", "12134");
        MDC.put("ID", "12134");
    }
}