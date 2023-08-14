package Jungsuck.EX_13;

import javax.swing.*;

public class Ex13_7 {
    public static void main(String[] args) throws Exception{
        Ex13_7_1 th1 = new Ex13_7_1();
        th1.start();
        String input = JOptionPane.showInputDialog("아무 값이나 입력하세요.");
        System.out.println("입력하신 값은 "+ input +"입니다.");
    }
}

class Ex13_7_1 extends Thread{
    public void run(){
        for(int i=10; i>0; i--){
            System.out.println(i);
            try{
                Thread.sleep(1000); //1초 지연
            }catch (Exception e){}
        }
    }
}