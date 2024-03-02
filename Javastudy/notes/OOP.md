# 객체지향언어
---

## 특징
- 코드의 재사용성이 높다.
- 코드의 관리가 용이하다.
- 신뢰성이 높은 프로그래밍을 가능하게 한다. 
	-제어자와 메서드를 이용해서 데이터를 보호하고 올바른 값을 유지
	-코드의 중복을 제거하여 오동작 방지

### 클래스 = 객체를 정의해 놓은 것. 설계도
 - 객체를 생성하는데 사용
 
### 객체=실제로 존재하는 것. 사물 또는 개념
- 객체가 가지고 있는 기능과 속성에 따른 용도
		
### 객체 = 속성(변수) + 기능(메서드)
- 실제 하드웨어를 소프트웨어화 하기 위함

### 인스턴스 = 특정 크래스로부터 생성된 객체 
- ex) TV 인스턴스. 클래스를 '인스턴스화' 한다.

---

### 클래스의 작성
```
class Tv{
	String color; //색깔
	boolean power; //전원상태
	int channel; //채널

	void power() {power= !power;}
	void channelUp() {channel++;}
	void channelDown() {channel--;}
}
```
- 소스파일에 public class가 있는 경우, 소스 파일의 이름은 pulic class의 이름과 일치해야한다.
- 없는 경우, 클래스의 이름 중 하나여야 한다.
- 하나의 소스파일에 둘 이상의 public class가 존재해선 안된다.
<span style='color : red'><br>
- 하나의 소스파일에 둘 이상의 클래스를 작성할 수 있으나, 하나만 작성하는 것이 바람직하다.</span>

## 클래스 = 데이터 + 함수
- 변수 -> 배열 -> 구조체 -> 클래스
- 사용자 정의 타입 
```
class Time{
	int hour;
	int minute;
	int second;
}
```

### 객체의 생성
```
	클래스명 변수명; // 클래스의 객체를 참조하기 위한 참조형 변수를 선언
	변수명 = new 클래스명(); // 클래스의 객체를 생성 후, 객체의 '주소'를 참조변수에 저장

	Tv t; // 객체를 다루러면 참조변수가 필요하다 : 리모컨
	t = new TV(); // 

	Tv t = new Tv();
```
- new 연산자 : 메모리 공간을 할당받고 그 공간의 참조값을 객체에게 반환하여 준다.

### 객체의 사용 : 객체가 가진 변수와 메서드를 사용한다
```
	t.channel=7; // Tv인스턴스의 멤버변수 channel에 7을 저장
	t.channelDown(); // Tv인스턴스의 메서드 channelDown()을 호출
	System.out.println("현재 채널은 "+ t.channel +"입니다.");
```
```
	Tv t1 = new TV();
	Tv t2 = new TV();
	t1.chnnel = 7;
	
	t2=t1; // t2에 t1에 저장된 Tv인스턴스1의 주소 를 저장. 
	// 더이상 Tv인스턴스2는 사용불가. ->Garbage Collector가 메모리 정리
```

### 객체 배열 = 참조변수 배열
```
	Tv tv1, tv2, tv3;
	Tv tvArr = new Tv[3]; //길이가 3인 Tv타입의 참조변수 배열

	Tv[] tvArr = {new Tv(), new Tv(), new Tv()};
	// 객체를 채워 넣어야한다.
```

---

## 선언 위치에 따른 변수의 종류
- 클래스 영역 : iv, cv / 선언문만 가능
- 메서드 영역 : lv
```
class Variables{
	int iv; // 인스턴스 변수 - 클래스영역
	static int cv; // 클래스 변수(static 변수, 공유변수)

	void method()
	{
		int lv=0; //지역변수 - 메서드영역
	}
}
```
- 클래스 변수 : 클래스가 메모리에 올라갈 때 자동 생성 -> 언제나 사용가능
- 인스턴스 변수 : 인스턴스가 생성되었을 때 생성 ->객체생성시 사용가능 ,객체는 iv를 묶어놓은것. 
- 지역 변수 : 범위(scope)내에서 유효, 변수 선언문이 수행되었을 때 생성, 메서드 종료시 자동 제거

### 클래스 변수와 인스턴스 변수
```
class Card{
	//iv
	String kind; //무늬
	int number; //숫자
	//cv : 공통
	static int width = 100; //폭
	static int height = 250; //높이
}

	Card c = new Card();
	c.kind ="heart";
	c.number = 5;

	Card.width = 200; // cv는 클래스 이름으로 사용.
	Card.height = 300; //참조변수로도 사용할 수 있지만 권장하지 않음.
```
- iv는 객체마다 만들어지나,  cv는 다른 공간에 하나만 존재.

---

## 메서드 = 선언부 + 구현부
- 문장들을 작업단위로 이름붙여 묶어놓은 것.
- 값(입력)을 받아 처리하고, 결과를 반환(출력)
```
//반환타입 메서드이름(매개변수선언) = 선언부
int add(int x, int y){  
	int result = x+y; // 구현부
	return result; // 결과반환
}

void : 반환할 것이 없다
```
- 코드의 중복 제거, 관리 용이, 재사용 가능. main 메서드의 '구조화'.
- 서로 다른 메서드 내 지역변수는 이름이 같아도 겹치지 않는다.

<span style='color : red'>
- 하나의 메서드는 하나의 기능만 수행하도록 작성하는 것이 좋다.<br>
- 매개변수 유효성 검사를 반드시 넣는 것이 좋다.<br>
</span>
### JVM의 메모리 구조
- 메서드 영역(method area) : 클래스 데이터가 저장. cv 생성
- 힙(heap) : 인스턴스가 생성되는 공간. iv 생성
- 호출 스택(call stack) : 메서드의 작업에 필요한 메모리 공간. 메서드가 호출되면 메모리 할당.
	 lv 들과 연산의 중간결과 등을 저장.  작업을 마치면 반환된다.

## 메서드 호출
```
메서드명(값1, 값2, ...);
print99danAll(); // void print99danAll()을 호출
int result = add(3,5); // int add(int x, int y)를 호출하고, 결과를 result에 저장

// 1. main 메서드에서 메서드 add를 호출, 인수가 매개변수에 저장(대입) 
// 2. 메서드 add의 {}안의 문장들이 순서대로 수행
// 3. 메서드 add의 모든 문장이 실행되거나 return문을 만나면, 호출한 메서드로 되돌아와 실행
```
- 인수(argument, 원본)
- 매개변수(parameter, 복사본)
- 반환타입이 있는 경우, 사용하기 위해 작업결과를 저장할 변수가 필요.

### return 문
```
void printGugudan(int dan){
	if(!(2<= dan && dan <=9))
		return; //void 일때 생략가능, 컴파일러가 자동추가.
}
```
- 반환타입이 void 가 아닐 경우 return 문에 반환값을 작성. 
- 반환타입과 일치해야함. (자동형변환) 

### 호출 스택
- 메서드 수행에 필요한 메모리가 제공되는 공간
- 메서드가 호출되면 호출스택에 메모리 할당, 종료되면 해제
- 아래 있는 메서드가 위에 있는 메서드를 호출. first in last out
```
class Ex6_5{
	public static void main (String[] args){
		System.out.println("Hello");
	}
}
// main 실행-> println 호출 실행 -> main 실행 -> 종료
```

---

### 기본형 매개변수
- Read only
```
public class Ex6_6 {  
public static void main(String[] args) {  
Data d = new Data(); //객체생성 - 참조형변수 d에 주소 저장  
d.x=10;  
System.out.println("main() : x = " + d.x);  
  
change(d.x);  
System.out.println("After change(d.x)");  
System.out.println("main() : x = " + d.x);  
}  

static void change(int x){ //기본형 매개변수  
x=1000; //change 메서드 지역변수  
System.out.println("change() : x = " + x); //1000  
// 모두 수행한 후 호출스택에서 사라짐. main 메서드로 돌아감.  
}  
}
```

### 참조형 매개변수
- Read & Write
```
static void change(Data2 d){ //참조형 매개변수 - 주소를 복사  
	d.x=1000; // 객체주소.x 에 1000 저장  
	System.out.println("change() : x = " + d.x); //1000  
// 모두 수행한 후 호출스택에서 사라짐. main 메서드로 돌아감.  
}
```

### 참조형 반환타입
```
Data3 d2 = copy(d); // d2 = tmp에 저장된 새 객체의 주소  

static Data3 copy(Data3 d){  //참조형 반환타입 Data3
Data3 tmp = new Data3(); //새로운 객체 생성 tmp에 주소 저장  
tmp.x = d.x;  
return tmp; // 복사한 객체의 주소를 반환  
}  
```

---

## 재귀호출(recursive call)
- 메서드의 내부에서 메서드 자신을 다시 호출하는 것.
- 논리적 간결함을 위함.
```
	void method(){
		method(); //재귀호출
	}
```
- 반드시 종료 조건문과 함께 사용되어야 한다.
- 반복문보다 수행시간이 오래 걸린다. (매개변수 복사, 종료 후 복귀할 주소 저장 ... )

---

## static 메서드와 인스턴스 메서드
- 인스턴스 메서드
	- 인스턴스 생성 후, '참조변수.메서드명()'으로 호출
	- 인스턴스 멤버(iv, im)과 관련된 작업
	- 메서드 내에서 iv 사용 가능
- static 메서드
	- 객체 생성 없이 '클래스명.메서드명()'으로 호출가능
	- 인스턴스 멤버와 관련없는 작업
	- 메서드 내에서 iv사용 불가 , cv는 사용가능

- static 메서드는 항상 호출가능, 인스턴스 메서드는 인스턴스 생성 후에 호출가능.
```
class MyMath2{
	long a,b;
	long add(){ //인스턴스 메서드
		return a+b; // iv
	} 
	static long add(long a, long b){ // 클래스 메서드
		return a+b; // lv
	} 
}

class Test2{
	public static void main(String args[]){
		System.out.println(MyMath2.add(200L,100L)); // 객체생성 없이 클래스메서드 호출
		MyMath2 mm = new MyMath2(); //인스턴스 생성
		mm.a=200:;
		mm.b=100L;
		System.out.println(mm.add()); // 인스턴스메서드 호출
	}
}
```
- 속성(멤버 변수) 중에서 공통 속성에 static을 붙인다.
- 인스턴스 멤버(iv, im)을 사용하지 않는 메서드에 static을 붙일 것을 고려한다.

### 오버로딩(overloading)
- 한 클래스 안에 같은 이름의 메서드를 여러 개 정의하는 것
	1. 메서드 이름이 같아야 한다.
	2. 매개변수의 개수 또는 타입이 달라야 한다.
	3. 반환 타입은 영향없다.
- 매개변수는 다르지만 같은 의미의 기능 수행

---
## 가변인자(varargs)
- '타입 ... 변수명'  형식으로 선언
- 매개변수 중 가장 마지막에 선언해야한다.
- 내부적으로 배열을 이용 - 메서드를 호출할 때마다 배열이 새로 생성되는 비효율이 존재
```
public printStream printf(String format, Object... args){...}
```

<span style="color:red"> 
- 가변인자를 사용한 메서드는 가능한 한 오버로딩 하지 않는 것이 좋다.
</span>

---

## 생성자(constructor)
- 인스턴스가 생성될 때마다 호출되는 '인스턴스 초기화 메서드'
- 인스턴스 생성시 수행할 작업에 사용 (iv 초기화)
```
Time t = new Time(); // 기본생성자
t.hour = 12;/ /iv 초기화
t.minute = 34;
t.second = 56;

Time t = new Time(12,34,56); // 생성자 호출 : iv 초기화
```
- 이름이 클래스명과 같아야 한다.
- 리턴값이 없다. void 안붙인다.
- 모든 클래스는 반드시 하나이상의 생성자를 가져야 한다.
```
class Card{
	Card() {iv초기화작업} // 매개변수 없는 생성자.

	Card(Stirng kind, int number){ // 매개변수 있는 생성자.
		kind= kind;
		number = number;
	}
}
// 생성자 오버로딩.
	Card c = new Card() // 1. 참조변수선언 2. 객체생성 3. 객체초기화 4. 객체주소저장(연결)
```
### 기본생성자
- 매개변수가 없는 생성자
- 생성자가 클래스내에 하나도 없을 때만, 컴파일러가 자동 추가
- 기본 생성자 없이 생성자를 작성하면 -> 기본생성자 호출시 오류

### 매개변수가 있는 생성자
- 인스턴스마다 각기 다른 값으로 초기화되어야 하는 경우, 생성과 동시에 원하는 값으로 초기화.

### 생성자 this()
- 생성자에서 다른 생성자 호출할 때 사용
- 다른 생성자 호출 시 첫 줄에서만 사용가능
- 코드의 중복을 피하기 위함
```
class Car2{  
	String color;  
	int door;  
  
	Car2(){  
	this("white",4);  
	}  
	Car2(String color){  
	this(color,4);  
	}  
	Car2(String color,int door){  
	this.color = color;  
	this.door = door;  
	}  
}
```

### 참조변수 this
- 인스턴스 자신을 가리키는 참조변수
- 인스턴스의 주소가 저장되어 있다.
- 인스턴스 메서드(생성자 포함)에서 사용가능
- lv 와 iv 구별할 때 사용
- 생성자 this와는 완전히 다름.
```
Car2(String color,int door){  
	// this.color는 iv, color는 lv
	this.color = color;  
	this.door = door;  
	}  
```
- 같은 클래스 내에서는 생략가능
- 모든 인스턴트 메서드에 숨겨진 채 존재한다.  같은 이름의 lv와 구별할 때 사용 
```
Car(String c,int d){  
	// color는 iv, c는 lv
	color = c;  // this.color가 진짜 이름
	door = dr;  
	}  
```
- static 메서드에서는 사용불가 : 객체가 없으므로

### 생성자를 이용한 인스턴스의 복사
```
// Car 클래스의 참조변수를 매개변수로 선언한 생성자.
Car(Car c){ 
	color = c.color;
	gearType = c.gearType;
	door = c.door;
}
```
---


## 변수의 초기화
- 지역변수는 수동으로 초기화 해야한다.
- iv는 0으로 자동 초기화된다.
```
class InitTest {
	int x; 
	int y=x;

	void method(){
		int i; //지역변수
		int j = i; // 에러. 지역변수를 초기화하지 않고 사용
	}
}
```
1. 명시적 초기화(=) : 간단한 초기화
```
class Car{
	int door = 4; // 기본형 변수 초기화
	Engine e = new Engine(); // 참조형 변수 초기화 : null or 객체주소
}
```
2. 초기화 블럭 : 복잡한 초기화에 사용
	- 인스턴스 초기화 블럭 : { 수행할 코드;} 
		- 언제나 생성자보다 먼저 실행된다
		- 인스턴스 변수의 초기화는 주로 생성자를 사용
		- 모든 생성자에서 공통 수행하는 코드를 작성하면 중복을 줄일 수 있다.

	- 클래스 초기화 블럭 : static { 수행할 코드; }
```
static { // 클래스 초기화 블럭 
	for(int i =0; i<arr.length;i++){ //  배열 arr을 난수로 채운다. 
		arr[i]=(int)(Math.random()*10)+1;
		}
	}
```
3.생성자 : 복잡한 초기화. iv초기화

### 초기화 시점 / 순서
- 클래스 변수 : 클래스가 처음 로딩될 때 한번 ( 메모리에 올라갈때)
	-기본값(자동) - 명시적초기화 - 클래스초기화블럭
- 인스턴스 변수 : 인스턴스가 생성될 때마다
	-기본값(자동)- 명시적초기화 - 인스턴스초기화블럭-생성자

---

## 상속(Inheritance)
- 기존의 클래스로 새로운 클래스를 작성하는 것.(코드의 재사용)
- 두 클래스를 부모와 자식으로 관계를 맺어주는 것.
```
class Parent{}
class Child extends Parent{} //상속. 확장.
```
- 자손은 조상의 모든 멤버를 상속받는다. (생성자, 초기화블럭 제외)
- 자손의 변경은 조상에 영향을 미치지 않는다.

## 포함(composite)
- 클래스의 멤버로 참조변수를 선언하는 것.
```
// Circle이 Point를 포함관계
class Circle{
	Point p = new Point(); // 중심점.  참조변수의 초기화 
	int r; // 반지름
}
	Circle1 c = new Circle1();  
	c.p.x=1;
```
- 작은 단위의 클래스들을 만들고, 이를 조합해서 클래스를 만든다.

## 단일 상속
- Java 는 단일상속만을 허용한다.
- 비중이 높은 클래스 하나만 상속관계로, 나머지는 포함관계로 한다.
```
class TvDVD enxtends Tv{ //상속
	Dvd dvd = new DVD(); //포함

	void play(){
		dvd.play(); // 메서드 호출
	}
}
```

### Object 클래스 = 모든 클래스의 조상
- 모든 클래스는 Object 클래스에 정의된 11개의 메서드를 상속받는다. (컴파일러가 자동추가)
	- toString(), equals(Object obj), hashCode(), ...

### 오버라이딩(overriding)
- 상속받은 조상의 메서드를 자신에 맞게 변경하는 것
```
class Mypoint3 extneds Object{
	int x;
	int y;
	//Object 클래스의 toString()을 오버라이딩
	public String toString(){
		return "x"+x+", y:"+y;
	}
}
	//같은 문장이다
	System.out.println(p);
	System.out.println(p.toString());
```

1. 선언부가 조상 클래스의 메서드와 일치해야 한다. (반환타입, 메서드이름, 매개변수목록)
2. 접근 제어자를 조상 메서드보다 좁은 범위로 변경할 수 없다. 
3. 예외는 조상 메서드보다 많이 선언할 수 없다.

---

### 참조변수 super
- 객체 자신을 가리키는 참조변수. 인스턴스 메서드(생성자) 내에만 존재
- 조상의 멤버를 자신의 멤버와 구별할 때 사용 super - this

### 생성자 super()
- 조상의 생성자를 호출할 때 사용
- 조상의 멤버는 조상의 생성자를 호출해서 초기화
	- 생성자, 초기화블럭은 상속 x
```
	Point3D(int x, int y, int z){
		super(x,y); // 조상클래스의 생성자 Point(int x, int y)를 호출
		this.z=z;
	}
```
- 모든 생성자는 첫 줄에 반드시 다른 생성자를 호출해야 한다.
	- 그렇지 않으면 컴파일러가 첫 줄에 super(); 를 삽입.
		-> 조상 클래스에 기본생성자가 없으면 에러

---

## 패키지(package)
- 서로 관련된 클래스의 묶음
- 클래스는 클래스 파일(.class), 패키지는 폴더. 하위 패키지는 하위 폴더
- 클래스의 실제 이름은 패키지를 포함(java.lang.String)

- 패키지는 소스파일의 첫 문장으로 단 한번 선언
- 만약 선언이 없으면 이름없는 패키지에 속하게 된다.
```
package com.code.book;
```
- bin : 패키지 루트 - 클래스파일이 위치한 곳

### 클래스 패스
- 클래스 파일의 위치를 알려주는 경로
- 환경변수 classpath 로 관리하며, 경로간의 구분자는 ';' 를 사용
- classpath 환경변수에 패키지의 루트를 등록해줘야 함

### import문
- 클래스를 사용할 때 패키지이름을 생략할 수 있게 해준다.
- 컴파일러에게 클래스가 속한 패키지를 알려준다.
- 패키지문과 클래스선언 사이에 선언한다.
```
import java.util.Date;
// import 패키지명.클래스명;
// import 패키지명.*;  '*' = 해당 패키지의 모든 '클래스' 


class ImportTest{
	Date today = new Date();
	// java.util. 생략
}
```
- java.lang 패키지의 클래스는 import하지 않고도 사용할 수 있다.
	- String, Object, System, Thread ...
- import문은 컴파일 시에 처리되므로 프로그램 성능에 영향이 없다.
### static import문
- static 멤버를 사용할 때 클래스 이름을 생략할 수 있게 해준다.
	- System.out -> out / Math.randam() -> ramdom()

---

## 제어자(modifier)
- 클래스와 클래스의 멤버(멤버 변수, 메서드)에 부가적인 의미 부여
- 접근 제어자 : public , protected, (default), private
- 그 외 : static, final, abstract ...

- 하나의 대상에 여러 제어자를 같이 사용가능, 접근 제어자는 하나만.
```
public class ModifierTest{
	public static final int WIDTH = 200;

	public static void main(String[] args){
	}
}
```

### static
- 클래스의, 공통적인
- static 멤버변수 : 클래스 변수가 된다.
- static 메서드 : static 메서드가 된다.
### final
- 마지막의, 변경될 수 없는
- final 클래스 : 변경될 수 , 확장될 수 없는 클래스가 된다. - 상속될 수 없다.
- final 메서드 : 오버라이딩으로 재정의 될 수 없다.
- final 변수 : 상수가 된다.
### abstract
- 추상의, 미완성의
- abstract 클래스 : 클래스 내에 추상 메서드가 선언되어 있음을 의미한다.
	- 추상 클래스의 인스턴스 생성 불가, 상속으로 완전한 클래스를 만든 후에 객체 생성가능
- abstract 메서드 : 선언부만 작성하고 구현부는 작성하지 않은 추상 메서드.

### 접근 제어자
- 외부로부터 데이터를 보호하기 위해서 사용
- 외부에는 불필요한, 내부적으로만 사용되는 부분을 감추기 위해
	- 제어 범위는 좁을수록 좋다.

- private : 같은 클래스 내에서만 접근 가능
- (default) : 같은 패키지 내에서만 접근 가능
- protected : 같은 패키지 + 다른 패키지의 자손클래스 내에서 접근 가능
- public : 접근 제한이 전혀 없다.

- 클래스에는 public or (default) 2가지. 멤버에는 4가지.

### 캡슐화
-  직접 접근은 private로 차단, public 메서드를통한 간접 접근 허용.
	- 상속이 예상되는 클래스라면 protected를 사용
- 보통 멤버변수의 값을 읽는 메서드명을  get변수명, 변경하는 메서드는 set변수명 으로한다.
	- getter, setter라 부른다.

### 생성자의 접근 제어자
- 인스턴스의 생성을 제한.
	- private로 설정하고 인스턴스를 생성해서 반환해주는 public static 메서드 제공.
	- 생성자가 private인 클래스는 상속불가.  final 클래스로 표시
		- 자손클래스의 인스턴스를 생성할때 조상클래스의 생성자를 호출하기때문. 
		
	- Math클래스는 몇 개의 상수와 static 메서드로만 구성. 생성자가 private Math()

### 제어자의 조합
- static + abstract 불가 : static메서드는 몸통이 있는 메서드에만 사용가능
- 클래스에 abstract + final 불가 : 서로 모순.
- 메서드에 abstract + private 불가 : 자손클래스에서 구현해야 하는데 접근불가
- 메서드에 private + final 불필요 : private 메서드는 오버라이딩 불가. 둘중 하나로 충분.

---

## 다형성(polymorphism)
- 여러 가지 형태를 가질 수 있는 능력
- 조상 타입 참조 변수로 자손 타입 객체를 다루는 것
```
class Tv{
	boolean power;
	int channel;	
}
class SmartTv extends Tv{
	String text;
	void caption(){}
}
	Tv t = new SmartTv() // 타입 불일치 ok
	// tv 리모컨으로 스마트tv를 다룬다.
```
- 객체와 참조변수의 타입이 일치하지 않으면?
	- 참조변수 클래스의 멤버만 사용가능
- 자손 타입 참조변수로 조상 타입의 객체를 가리킬 수는 없다.

### 참조변수의 형변환
- 사용할 수 있는 멤버의 갯수를 조절하기 위함
- 조상-자손 관계의 참조변수는 서로 형변환 가능
- 실제 객체의 멤버 수보다 작거나 같아야함 (조상객체 -> 자손타입변환 불가)
	- ClassCastException
```
FireEngine f = new FireEngine();
Car c = (Car)f; //조상인 Car 로 형변환 (생략가능)
FireEngine f2 = (FireEngine)c; // 자손인 FireEngine 으로 형변환(생략불가)

//f c f2 모두 FireEngine 인스턴스를 가리킴.
```
- 객체가 없어도 형변환은 가능

### instanceof 연산자
- 참조변수의 형변환 가능여부 확인. 가능하면 ture 반환
- 실제 인스턴스의 타입을 확인
```
	void doWork(Car c){ // c는 Car 또는 Car의 모든 자손
		if (c instanceof FireEngine){ //1. 형변환 가능한지 확인 
		FireEngine fe = (FireEngine)c; //2.형변환
	}
```

### 참조변수와 인스턴스의 연결
- 멤버변수가 조상-자손 클래스에 중복 정의된 경우, 참조변수의 타입에 따라 다른 멤버변수 사용
- 캡슐화로 직접접근을 차단한다

### 매개변수 다형성
- 참조형 매개변수는 메서드 호출시, 자신과 같은 타입 또는 자손타입의 인스턴스를 넘겨줄 수 있다.
- 다형성의 장점 1
```
class Product{
	int price;
	int point;
}
class Tv extends Product{}
class Computer extends Product{} 

class Buyer{
	int money=1000;
	int point=0;

	void buy(Tv t){ // Tv 사는 메서드. : 상품마다 다 오버로딩해야됨.
		money -=t.price;
		point += t.point;
	}
	void buy(Product p){ //Product 참조변수를 다형적 매개변수로 사용. -> 모든상품 가능
		...
	}
}
```


## 여러 종류의 객체를 배열로 다루기
- 조상 타입의 배열에 자손들의 객체를 담을 수 있다.
- 다형성의 장점 2
```
Product[] cart = new Product[3]; //장바구니 배열
p[0] = new Tv();
p[1] = new Computer();
p[2] = new Audio();

// 가변배열기능 Vector 클래스는 object 배열을 가지고있음. add 메서드로 추가.
// Object[] : 모든 종류의 객체 저장가능 
```

---

## 추상 클래스
- 추상 메서드를 포함하는 클래스. 
- 여러 클래스에 공통적으로 사용 될 수 있는, 기존 클래스의 공통 부분을 뽑아서 작성.
- 코드의 관리가 용이. 변경에 유리
```
GregorianCalendar cal = new GregorianCalendar(); // 구체적
Calendar cal  = Calendar.getInstance(); //추상적. 뭘 반활할지 불분명. Calendar + 자손 가능
```

### 추상 메서드
- 구현부가 없는 메서드. 미완성.
- 상속을 통해 완성
- 상속을 통해 완성된 후 호출되면, 참조변수 타입 상관없이 완성된 메서드가 호출.
	- 추상클래스 타입 참조변수로 자손의 완성된 메서드 호출가능.

---

## 인터페이스
- 추상 메서드의 집합
- 구현된 것이 전혀 없는 설계도. (모든 멤버가 public + static final / abstract)
```
interface 'name' {
	public static final 'type' 'name' = '0' ; // 상수만 가질수 있음
	public abstract 'methodname'('parameters'); 
	
	// 변수는 항상 public staticc final 생갹가능.
	// 메서드는 항상 public abstract  생갹가능. 
}
```
- 인터페이스의 조상은 인터페이스만 가능. (Object가 최고 조상이 아니다.)
- 다중 상속이 가능 (추상메서드는 충돌해도 문제 x )

- 추상클래스로 클래스의 구분을 해결, 기능을 인터페이스로 구현
![[추상클래스인터페이스.png]]
### 인터페이스의 구현
- implements 사용
```
class 클래스이름 implements 인터페이스이름 {
	// 인터페이스에 정의된 추상메서드를 모두 구현해야함
}
```

### 인터페이스와 다형성
- 인터페이스 타입 참조변수로 자손 타입 객체를 다룰 수 있다.
``` 
class Fighter extends Unit implements Fightable{
	public void move(int x, int y){ }
	public void attack(Fightable f){ }
}
	Unit u = new Fighter();
	Fightable f = new Fighter(); //ok
```
- 인터페이스 타입 매개변수에는 인터페이스를 구현한 클래스의 객체만 들어올 수 있다.
```
interfave Fightable{
	void move(int x, int y);
	void attack(Fighterble f);
}
```
- 인터페이스를 메서드의 리턴타입으로 지정할 수 있다.
- 인터페이스를 구현한 인스턴스를 반환.
```
	Fighterble method(){  // method는 Fighterble 인터페이스를 구현한 클래스의 인스턴스 반환
		Fighter f = new Fighter();
		return f;
		// return new Fighter(); 로 바꿀 수 있다.
	}
		Fighterble f = method(); //Fighter는 Fighterble 로 자동 형변환 가능.
```
### 인터페이스의 장점
- 두 대상(객체)간의 연결을 돕는 중간역할
- 선언(설계)와 구현을 분리시킬 수 있게 한다. 느슨한 결합. ->변경에 용이. 
```
public class Ex7_8 {  
	public static void main(String[] args) {  
		A a = new A();  
		a.method(new B()); //A가 B를 사용(의존)  
		// C를 사용하는것으로 변경하려면 A method의 선언부도 변경해야함.  
		// B C 둘다 인터페이스 I를 구현하면 C로바꿔도 A에 변화 없다.  
	}  
}  
  
class A{  
	// public void method(B b){  
	public void method(I i){ //인터페이스 I를 구현한 인스턴스만 들어온다.  
		b.method();  
	}  
}
```
- 개발 시간을 단축할 수 있다.
- 변경에 유리한 설계가 가능하다.
- 표준화가 가능하다.
	- JDBC인터페이스를 이용해서 표준화. -> DB변경에 어플리케이션 변경 필요 X
- 서로 관계없는 클래스들을 관계 맺어줄 수 있다.
	- 같은 기능을 인터페이스로 구현
```
void repair(Tank t) {}
void repair(Dropship d){} // 조상인 GroundUnit으로 묶으면 문제.

// Repairable 인터페이스를 구현해서 관계.
```

### default 메서드와 static 메서드
- JDK1.8 부터 인터페이스에 default 메서드, static 메서드 추가 가능

- 인터페이스에 새로운 메서드(추상 메서드)를 추가하기 어려움
	- 추상메서드를 새로 추가하면 인터페이스를 구현한 모든 클래스들에 변경이 필요.
	- -> 구현부를 가진 default메서드를 추가할 수 있게한다. (인스턴스 메서드)
	- -> 충돌문제 발생 : 오버라이딩으로 해결.

- static 메서드는 인스턴스와 관계 없는 독립적인 메서드이기 때문에 추가 못할 이유가 없음.

---

## 내부 클래스(inner class)
- 클래스 내에 선언된 클래스
- 내부 클래스에서 외부 클래스의 멤버들에 쉽게 접근 가능
- 캡슐화를 통해 코드 간결화
```
class Outer{
	class InstanceInner{}
	static class StacicInner{}

	void myMethod(){
		class LocalInner{}	
	}
}
```

- instance 클래스 : 외부 클래스의 인스턴스 멤버처럼 다루어짐. instance멤버와 관련된 작업에 사용
- static 클래스 : 외부 클래스의 static 멤버처럼 다루어짐. static 메서드에서 사용될 목적으로 선언.
- local 클래스 : 선언된 영역 내부에서만 사용가능.
- anonymous 클래스 : 클래스의 선언과 객체의 생성을 동시에 하는 일회용 클래스

### 내부 클래스의 제어자
- 내부 클래스는 외부 클래스의 멤버변수와 같은 성질을 가진다. 
- 클래스이기 때문에 abstract나 final 제어자 사용 가능.
- private protected 등 접근 제어자 사용 가능

- satic 클래스만 static 멤버를 가질 수 있다. (final+static은 상수이므로 모든 클래스에서 가능)

- 인스턴스클래스는 같은 클래스의 인스턴스멤버와  static 멤버 모두 객체생성 없이 사용가능
- 스태틱클래스는 인스턴스클래스의 멤버들을 객체생성 없이 사용불가. (멤버와 같음)

- 외부 클래스와 내부 클래스에 선언된 변수의 이름이 같으면  this. / 외부클래스명.this.  사용

### 익명 클래스(anonymous class)
- 이름이 없기 때문에 생성자 x 조상클래스나 인터페이스의 이름 사용.
	- 따라서 상속+구현이나 둘 이상 구현 불가.
```
new 조상/인터페이스이름(){
	//멤버선언
}

Button b = new Button("Start");
b.addActionLisetener(new ActionListener(){ 
		public void actionPerformed(ActionEvent e){ //멤버(메서드)
			System.out.plintln("ActionEvent occured!!!");	
		}
	} // 익명 클래스의 끝 
);
```




