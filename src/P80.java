
/**
 * Created by govardhanreddy on 12/10/15.
 */
public class P80 {

  public static void main(String[] args) {
    MyBigInt a = new MyBigInt("999999999999999999999999999999");
    MyBigInt b = new MyBigInt("22");
    MyBigInt c = MyBigInt.add(a, b);
    System.out.println(" a " + a + " b " + b + "c: " + c);
  }
}
