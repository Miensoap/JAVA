package Jungsuck.Ex_Grammer.Ex_Operator;

public class OperatorEx18 {
    public static void main(String[] args) {
        double pi = 3.141592;
        double shortPi=Math.round(pi*1000) / 1000.0; //int / double -> double /double = double
    }
}
/* \\or < &&and !논리부정연산자
    p121 5.2 비트연산자 \or &and ^xor ~비트전환연산자 -> 피연산자의 1의보수
    x<<n : x의 2진수를 왼쪽으로 n자리 이동한다. 벗어난 값들은 버리고, 빈자리는 0으로 채운다. = x*2^n
    >> : 오른쪽으로 이동시킨다. 왼쪽 빈칸을 0, 음수면 부호유지를위해 1로 채운다. = x/2^n
    -> 빠르지만 가독성이 떨어진다.

    조건연산자 ? : 조건식이 true면 식1, false면 식2 반환.
    result= (x>y) ? x: y ; absX = x >=0 ? x : -x ;

    대입연산자 = : 복합대입연산자 +=...
 */

