public class BigRectangleFilter implements Filter {
    public static boolean LessThan10(int perm) {
        if(perm >= 10){
            return true;
        } else {
            return false;
        }
    }
    @Override
    public boolean accept(Object x) {
        return LessThan10((Integer) x);
    }
    /*Provide a class BigRectangleFilter which implements the Filter interface whose accept method
     accepts all java Rectangle objects that have a perimeter > 10.
     */

}
