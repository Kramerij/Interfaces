public class ShortWordFilter implements Filter{
    public static boolean checkWordLength(String word){
        if(word.length() <= 5){
            return true;
        } else {
            return false;
        }
    }
    @Override
    public boolean accept(Object x) {
        return checkWordLength(x.toString());
    }
    /*Provide a class ShortWordFilter which implements the Filter
    interface whose accept method accepts all strings of length < 5.
     */

}
