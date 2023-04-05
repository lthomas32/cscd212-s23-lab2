package cscd212comparators.lab2;

import cscd212classes.lab2.Television;

import java.util.Comparator;

public class TelevisionModelScreenSizeComparator implements Comparator<Television> {
    @Override
    public int compare(final Television o1, final Television o2){
        if (o1 == null || o2 == null)
            throw new IllegalArgumentException("null parameter in TelevisionModelScreenSizeComparator");

        int res = o1.getModel().compareTo(o2.getModel());
        if (res != 0)
            return res;
        return o1.getScreenSize() - o2.getScreenSize();
    }
}
