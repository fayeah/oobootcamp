package refactorOrganizeData;

public class SubSelfEncapsulateField extends SelfEncapsulateField {
    int _low;
    int _high;
    int _cap;

    SubSelfEncapsulateField(int low, int high, int cap) {
        super(low, high);
        _cap = cap;
    }

    int getHigh() {
        return Math.min(super._high, _cap);
    }
}
