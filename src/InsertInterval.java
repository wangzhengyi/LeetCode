import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class InsertInterval {
    static class Interval {
        int start;
        int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        Interval() {
            start = 0;
            end = 0;
        }
    }

    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> result = new ArrayList<Interval>();
        if (intervals == null || intervals.size() == 0) {
            result.add(newInterval);
            return result;
        }

        intervals.add(newInterval);

        // sort arraylist
        sortIntervals(intervals);

        // merge arraylist
        for (int i = 0; i < intervals.size() - 1; i++) {
            Interval first = intervals.get(i);
            Interval second = intervals.get(i + 1);
            if (first.end < second.start) {
                result.add(first);
            } else if (first.end >= second.start && first.end < second.end) {
                second.start = first.start;
            } else {
                second.start = first.start;
                second.end = first.end;
            }
        }
        result.add(intervals.get(intervals.size() - 1));

        return result;
    }

    private static void sortIntervals(ArrayList<Interval> intervals) {
        Collections.sort(intervals, new IntervalsComparator());
    }

    private static class IntervalsComparator implements Comparator<Interval> {

        @Override
        public int compare(Interval o1, Interval o2) {
            return o1.start - o2.start;
        }
    }
}
