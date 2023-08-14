package Jungsuck.Ex_6_OOP;

class Ex6_1 {
    public static void main(String[] args) {
        Tv t1 = new Tv();
        t1.color="노랑";
        t1.channel=7;
        t1.channelDown();
        System.out.println("채널 = " + t1.channel);

        Tv t2 = new Tv();
        t2=t1; // 참조변수 t2가 가리키는 객체가 달라짐.
    }
}

class Tv{
    String color;
    boolean power;
    int channel;

    void power(){power= !power;}
    void channelUp(){++channel;}
    void channelDown(){--channel;}
}
