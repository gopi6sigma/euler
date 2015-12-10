/*
 * Only for positive numbers.
 */
public class MyBigInt {
  char[] digits;
  public MyBigInt() {
  }

  public MyBigInt(String integer) {
    digits = new char[integer.length()];
    for(int i = 0; i < integer.length(); i++) digits[i] = integer.charAt(i);
  }

  public static boolean isEmpty(MyBigInt myBigInt) {
    return null == myBigInt || null == myBigInt.digits || 0 == myBigInt.digits.length;
  }

  public static MyBigInt removeLeadingZeroes(MyBigInt myBigInt) {
    if (isEmpty(myBigInt)) return myBigInt;
    StringBuffer result = new StringBuffer();
    for (int i = 0; i < myBigInt.digits.length; i++) {
      if (0 == result.length() && myBigInt.digits[i] == '0') continue;
      result.append(myBigInt.digits[i]);
    }
    return new MyBigInt(result.toString());
  }

  public static int compare(MyBigInt m, MyBigInt n) {
    if (m == n) return 0;
    // if any of these are null or empty, NPE should be thrown
    MyBigInt mNorm = removeLeadingZeroes(m);
    MyBigInt nNorm = removeLeadingZeroes(n);
    int i = m.digits.length - 1;
    int j = n.digits.length - 1;
    while (i >= 0 && j >= 0) {
      int sum = int1.digits[i] - '0' + int2.digits[j] - '0' + carry;
      result.append((sum % 10));
      carry = sum / 10;
      System.out.println("i: " + i + " j " + j + " carry " + carry + " sum " + sum + " result " + result.toString());
      i--;
      j--;
    }

    while (i >= 0) {
      int sum = int1.digits[i] - '0' + carry;
      result.append((sum % 10));
      carry = sum / 10;
      i--;
    }

    while (j >= 0) {
      int sum = int2.digits[j] - '0' + carry;
      result.append((sum % 10));
      carry = sum / 10;
      j--;
    }

    if (carry > 0) {
      result.append(carry);
    }

  }

  public static MyBigInt add(MyBigInt int1, MyBigInt int2) {
    if (isEmpty(int1) && isEmpty(int2)) return null;
    if (isEmpty(int1)) return int2;
    if (isEmpty(int2)) return int1;

    StringBuffer result = new StringBuffer();
    int i = int1.digits.length - 1;
    int j = int2.digits.length - 1;
    int carry = 0;
    while (i >= 0 && j >= 0) {
      int sum = int1.digits[i] - '0' + int2.digits[j] - '0' + carry;
      result.append((sum % 10));
      carry = sum / 10;
      System.out.println("i: " + i + " j " + j + " carry " + carry + " sum " + sum + " result " + result.toString());
      i--;
      j--;
    }

    while (i >= 0) {
      int sum = int1.digits[i] - '0' + carry;
      result.append((sum % 10));
      carry = sum / 10;
      i--;
    }

    while (j >= 0) {
      int sum = int2.digits[j] - '0' + carry;
      result.append((sum % 10));
      carry = sum / 10;
      j--;
    }

    if (carry > 0) {
      result.append(carry);
    }
    return new MyBigInt(result.reverse().toString());
  }

  @Override
  public String toString() {
    if (isEmpty(this)) return null;
    StringBuffer result = new StringBuffer(digits.length);
    for (char ch : digits) result.append(ch);
    return result.toString();
  }
}
