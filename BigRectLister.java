import java.util.ArrayList;
import java.util.Scanner;

public class BigRectLister {
    /*Then write a program BigRectLister.java that creates an ArrayList of 10 Rectangles
     making sure that you have several that are under and several that are over a perimeter of 10.
     Use the collectAll method as before to list the rectangles that have big perimeters.
     */



    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> Perimeter = new ArrayList<>();
        ArrayList<Integer> BigRectangle = new ArrayList<>();
        int length;
        int width;
        int permimeter;
        Boolean done = false;
        Boolean enteringDone = false;
        do {

            length = SafeInput.getInt(input, "length:");
            width = SafeInput.getInt(input, "width:");
            permimeter = length * width;
            System.out.println("Permimeter is " + permimeter);
            Perimeter.add(permimeter);


         done = SafeInput.getYNConfirm(input, "Are you done entering rectangles?");
     } while (!done);
        System.out.println(Perimeter);

        for(Object o : Perimeter) {
            boolean permBig10 = new BigRectangleFilter().accept(o);
            if (permBig10 == true){
                BigRectangle.add((Integer) o);
            }
        }
        System.out.println(BigRectangle);
    }
}
