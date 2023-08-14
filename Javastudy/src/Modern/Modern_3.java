package Modern;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class Modern_3<T>{
    public Modern_3() throws IOException {
    }

    public String processFile(BufferedReaderProcessor p) throws IOException{
        try (BufferedReader br =
                new BufferedReader(new FileReader("data.txt"))){
            return p.process(br);
        }
    }
    String oneLine = processFile(BufferedReader::readLine);
    // 메소드 참조
    String twoLine = processFile((BufferedReader br) ->
            br.readLine() + br.readLine());
    // 람다 전달

    public <T> void forEach(List<T> list, Consumer<T> c){
        for(T t : list){
            c.accept(t);
        }
    }

    int portnumber = 1337;
    Runnable r = () -> System.out.println(portnumber);
    // capturing lambda
    // final 한 변수만 캡쳐가능

    Supplier<Apple> c1 = Apple::new;
    // () -> Apple 생성자
    Apple a1 = c1.get();

    Function<Integer, Apple> c2 = Apple::new;
    Apple a2 = c2.apply(110);

}


@FunctionalInterface
interface BufferedReaderProcessor{
    String process(BufferedReader b) throws IOException;
}

@FunctionalInterface
interface Consumer<T>{
    void accept(T t);
}