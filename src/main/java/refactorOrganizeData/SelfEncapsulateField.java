package refactorOrganizeData;

public class SelfEncapsulateField {
    int _low, _high;

    SelfEncapsulateField(int low, int high) {
        _low = low;
        _high = high;
    }

    boolean includes(int arg) {
        return arg >= _low && arg <= _high;
    }

}
