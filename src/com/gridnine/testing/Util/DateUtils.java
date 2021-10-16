package com.gridnine.testing.Util;

import java.time.LocalDateTime;
import java.time.ZoneId;

public final class DateUtils {

    public static long getLocalDateTimeDifference(LocalDateTime from, LocalDateTime to) {
        return (to.atZone(ZoneId.of("Europe/Moscow")).toInstant().toEpochMilli() 
            - from.atZone(ZoneId.of("Europe/Moscow")).toInstant().toEpochMilli()) / 1000;
    }
    
}
