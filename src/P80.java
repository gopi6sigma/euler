
/**
 * Created by govardhanreddy on 12/10/15.
 */
public class P80 {

  public static void main(String[] args) {
    MyBigInt a = new MyBigInt("1298");
    MyBigInt b = new MyBigInt("22");
    MyBigInt c = MyBigInt.add(a, b);
    System.out.println("c: " + c);
  }
}
