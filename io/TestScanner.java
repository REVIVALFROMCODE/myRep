import java.util.Scanner;
public class TestScanner {
    public  void run() {
      //System.in is a InputStream type.
        var scanner = new Scanner(System.in);
        int curInt;
        while(scanner.hasNext()){
            try{
                curInt = scanner.nextInt();
                System.out.println(curInt);
            } catch (Exception e) {//next Int throw InputMismatchException, we catch it then program continue.
                System.out.println("Wrong input, continue.");
              //Consume invalid input, otherwise -> dead loop.
                scanner.next();
            }
        }
    }
}
