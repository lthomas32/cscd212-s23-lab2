package cscd212comparators.lab2;

import cscd212classes.lab2.Television;

import java.util.Comparator;

public class TelevisionScreenSizeComparator implements Comparator<Television> {
    @Override
    public int compare(final Television o1, final Television o2){
        if (o1 == null || o2 == null)
            throw new IllegalArgumentException("null parameter in TelevisionScreenSizeComparator");
        return o1.getScreenSize() - o2.getScreenSize();
    }
}
