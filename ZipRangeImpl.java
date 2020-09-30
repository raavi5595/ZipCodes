
// Object class with getters and setters.
public class ZipRangeImpl implements Comparable {

    private Integer lowerBound;
    private Integer upperBound;


    public ZipRangeImpl(Integer lowerBound, Integer upperBound) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    public Integer getLowerBound() {
        return lowerBound;
    }

    public void setLowerBound(Integer lowerBound) {
        this.lowerBound = lowerBound;
    }

    public Integer getUpperBound() {
        return upperBound;
    }

    public void setUpperBound(Integer upperBound) {
        this.upperBound = upperBound;
    }

//Comparable object, sorts the list on lowerBound intially and if they are equal then sort by upperBound
    public int compareTo(Object zr) {
        int retVal = 0;
        ZipRangeImpl range = (ZipRangeImpl) zr;
        if (this.getLowerBound().intValue() < range.getLowerBound().intValue()) {
            retVal = -1;
        } else if (this.getLowerBound().intValue() > range.getLowerBound().intValue()) {
            retVal = 1;
        } else {
            if (this.getUpperBound().intValue() < range.getUpperBound().intValue()) {
                retVal = -1;
            } else if (this.getUpperBound().intValue() > range.getUpperBound().intValue()) {
                retVal = 1;
            } else {
                retVal = 0;
            }
        }
        return retVal;
    }


}
