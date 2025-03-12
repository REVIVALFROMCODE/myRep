import java.util.Scanner;
import java.util.InputMismatchException;

public class TestScanner {
    public  void run() {
      //System.in is a InputStream type.
        var scanner = new Scanner(System.in);
        int curInt;
        while(scanner.hasNext()){
            try{
                curInt = scanner.nextInt();
                System.out.println(curInt);
            } catch (InputMismatchException e) {
                //next Int throw InputMismatchException, we catch it then program continue.
                System.out.println("Wrong input, continue.");
              //Consume invalid input, otherwise -> dead loop.
                scanner.next();
            }
        }
    }
}
//If it were a checked exception, like IOException, then the method would need to declare throw explicitly on signature if doesn't catch, enforced by the compiler.
//If you use Exception which too general and close to the top of throwable hierarchy. Causing other exception details be 
