package length;

public class LengthComparator {
    public int compare(Length length, Length target) {
        if(length.getValue() < target.getValue()) {
            return -1;
        } else if (length.getValue() == target.getValue()) {
            return 0;
        }
        return 1;
    }
}
