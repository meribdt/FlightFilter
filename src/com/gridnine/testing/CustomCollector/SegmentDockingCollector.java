package com.gridnine.testing.CustomCollector;

import java.util.stream.Collector;

import com.gridnine.testing.Model.Segment;
import com.gridnine.testing.Util.DateUtils;

public class SegmentDockingCollector {

    private int count = 0;
    private static long minDocking; 
    private static long maxDocking; 

    private Segment right;

    public void accept(Segment newSegment) {
        var left = right;
        right = newSegment;
        if (left == null) return;
        var diff =  DateUtils.getLocalDateTimeDifference(
            left.getArrivalDate(), 
            right.getDepartureDate()
        );
        if (diff > maxDocking || diff < minDocking) count++;
    }

    public SegmentDockingCollector combine(SegmentDockingCollector other) {
        throw new UnsupportedOperationException("Parallel Stream not supported");
    }

    public int finish() {
        return count;
    }

    public static Collector<Segment, ?, Integer> collector(long min, long max) {
        SegmentDockingCollector.minDocking = min;
        SegmentDockingCollector.maxDocking = max;
        return Collector.of(
            SegmentDockingCollector::new, 
            SegmentDockingCollector::accept, 
            SegmentDockingCollector::combine, 
            SegmentDockingCollector::finish
        );
    }

}