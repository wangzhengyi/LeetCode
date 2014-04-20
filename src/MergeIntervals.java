import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class MergeIntervals {
    static class Interval {
        int start;
        int end;

        public Interval() {
            start = 0;
            end = 0;
        }

        public Interval(int s, int e) {
            start = s;
            this.end = e;
        }
    }

    public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> result = new ArrayList<Interval>();

        // special case
        if (intervals == null || intervals.size() == 0) {
            return result;
        }

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
