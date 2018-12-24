package length;

public class LengthComparator {
    public int compare(Length length, Length target) {
        if(length.getMeterValue() < target.getMeterValue()) {
            return -1;
        } else if (length.getMeterValue() == target.getMeterValue()) {
            return 0;
        }
        return 1;
    }
}
