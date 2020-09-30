import java.util.ArrayList;
import java.util.Collections;

public class RangeManager {

    ArrayList<ZipRangeImpl> localRangeList = new ArrayList<>();


    //Public method to sort the zip codes
    public ArrayList<ZipRangeImpl> getSortedRanges(ArrayList<ZipRangeImpl> rangeList, ZipRangeImpl newRange) {
        rangeList.add(newRange);
        return getSortedRanges(rangeList);
    }

    //RangeList is the list of ranges where already sorted and stored in the DataBase, usually this is the case. But here We are having a local Variable.
    private ArrayList<ZipRangeImpl> getSortedRanges(ArrayList<ZipRangeImpl> rangeList) {
        if (rangeList == null || rangeList.isEmpty()) {
            rangeList = localRangeList;
        }

        Collections.sort(rangeList);
        ArrayList<ZipRangeImpl> cloneList = new ArrayList();
        cloneList.addAll(rangeList);// adding all the ranges into new arraylist (deepClone with same objects)
        Boolean reccur = false;
        ZipRangeImpl prevRange = null;
        for (ZipRangeImpl currRange : rangeList) {
            if (prevRange != null) {

                if (areZipRangesOverLapping(prevRange, currRange)) {
                    cloneList.remove(currRange);
                    cloneList.remove(prevRange);
                    cloneList.add(splitAndMerge(prevRange, currRange));// no changes to current range.
                    reccur = true;
                } else if (prevRange.getUpperBound().intValue() + 1 == currRange.getLowerBound()) {
                    cloneList.remove(currRange);
                    prevRange.setUpperBound(currRange.getUpperBound());
                    reccur = true;
                }
            }
            prevRange = currRange;
        }
        if (reccur) {
            cloneList = getSortedRanges(cloneList);
        }


        return cloneList;
    }

    //here the prevRange has the loweBound less than currRange's lowerBound(always)
    private ZipRangeImpl splitAndMerge(ZipRangeImpl prevRange, ZipRangeImpl currRange) {
        if (prevRange.getUpperBound() >= currRange.getUpperBound()) {
            return prevRange;//current range can be deleted as it is already inside the prevRange.
        } else {
            prevRange.setUpperBound(currRange.getUpperBound());
            return prevRange;
        }
    }

    private Boolean areZipRangesOverLapping(ZipRangeImpl range1, ZipRangeImpl range2) {
        if (range1.getUpperBound() < range2.getLowerBound()
                || range1.getLowerBound() > range1.getUpperBound()) {
            return false;
        }
        return true;
    }


    public void print(ArrayList<ZipRangeImpl> minimumRanges) {
        for (ZipRangeImpl range : minimumRanges) {
            System.out.println();
            StringBuffer buff = new StringBuffer();
            buff.append(range.getLowerBound().intValue());
            buff.append("    ");
            buff.append(range.getUpperBound().intValue());
            System.out.println(buff.toString());
        }
    }
}
