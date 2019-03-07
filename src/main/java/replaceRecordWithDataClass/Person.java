package replaceRecordWithDataClass;

//把数值换成一个类，编译器就可以对这个类进行类型检查
public class Person {
//    public static final int O = BloodGroup.O.getCode();
//    public static final int A = BloodGroup.A.getCode();
//    public static final int B = BloodGroup.B.getCode();
//    public static final int AB = BloodGroup.AB.getCode();

    private BloodGroup bloodGroup;

//    public Person(int bloodGroup) {
//        this.bloodGroup = BloodGroup.code(bloodGroup);
//    }

    public Person(BloodGroup bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

//    public int getBloodGroupCode() {
//        return this.bloodGroup.getCode();
//    }

    public void setBloodGroup(BloodGroup bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public void setBloodGroup(int arg) {
        this.bloodGroup = BloodGroup.code(arg);
    }

    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }
}
