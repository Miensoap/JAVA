package Jungsuck.Ex_6_OOP;

public class Ex6_3 {
    public static void main(String[] args) {
        System.out.println("Ex_OOP.Card.height = " + Card.height);
        System.out.println("Ex_OOP.Card.width = " + Card.width); // 객체생성 없이 cv 사용 가능
        Card c1 = new Card();
        c1.kind = "Heart";
        c1.number = 7;
        
        Card c2 =new Card();
        c2.kind = "Spade";
        c2.number = 4;

        System.out.println("c1.kind = " + c1.kind);
        System.out.println("c1.number = " + c1.number);
        System.out.println("c2.kind = " + c2.kind);
        System.out.println("c2.number = " + c2.number);

        c1.width = 50; // 가능하나 권장하지 않는다.
        System.out.println("c2.width = " + c2.width);
        Card.width = 80; // cv는 클래스명으로 사용.
        System.out.println("Ex_OOP.Card.width = " + Card.width);


    }
}

class Card{
    //iv
    String kind; //무늬
    int number; //숫자
    //cv : 공통
    static int width = 100; //폭
    static int height = 250; //높이
}