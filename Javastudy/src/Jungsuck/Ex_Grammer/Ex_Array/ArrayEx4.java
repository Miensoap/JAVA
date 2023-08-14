package Jungsuck.Ex_Grammer.Ex_Array;

public class ArrayEx4 {
    public static void main(String[] args) {
//        List<String> li = new ArrayList<>();
//        li.add("hi");
//        li.add("hello");
//        System.out.println("li = " + li);
        // 배열 abc와 num을 붙여서 하나의 배열 result로 만든다.
        char[] abc={'A','B','C','D'};
        char[] num={'0','1','2','3','4','5','6'};
        System.out.println(abc);
        System.out.println(num);
        char[] result = new char[abc.length+num.length];
        System.arraycopy(abc,0,result,0,abc.length); //abc의 0부터 length만큼 result 0부터에 복사
        System.arraycopy(num,0,result,abc.length,num.length);
        System.out.println(result);

        System.arraycopy(abc,0,num,0,abc.length);
        System.out.println(num);
        System.arraycopy(abc,0,num,4,3); //num의 index6위치에 abc0부터 3개복사
        System.out.println(num);

    }
}
//System.out.println("result = " + result); ->string + char.tostring() = string -> 주소값반환


