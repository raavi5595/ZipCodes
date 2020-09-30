import java.util.ArrayList;

public class RangeMain {
    public static void main(String args[]) {
RangeManager rMan = new RangeManager();

         ZipRangeImpl range1 =new ZipRangeImpl(94133,94133);
         ZipRangeImpl range2 =new ZipRangeImpl(94200,94299);
         ZipRangeImpl range3 =new ZipRangeImpl(94600,94699);
         ZipRangeImpl range4 =new ZipRangeImpl(94250,94650);// can be played with any numbers.
        ArrayList<ZipRangeImpl> zipList = new ArrayList<>();
        zipList.add(range1);
        zipList.add(range2);
        zipList.add(range3);
//         rMan.getMinimumRanges(zipList, range4);
         rMan.print(rMan.getSortedRanges(zipList, range4));
    }


}
