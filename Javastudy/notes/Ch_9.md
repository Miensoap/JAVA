## Object 클래스
-  모든 클래스의 최고 조상. 11개의 메서드를 가지고있다.

### protected Object clone()
- 객체 자신의 복사본 반환
- 값만 복사하는 얕은 복사. 참조형  iv는 완전히 복제 x
### boolean equals(Object obj)
- 객체 자신과 obj가 같은 객체인지 반환
- 객체의 주소를 비교 -> 값을 비교하도록 오버라이딩

### protected void finalize
- 거의 사용 x
### Class getClass()
- 객체 자신의 클래스정보를 담고 있는 Class 인스턴스를 반환

### int hashCode()
- 객체 자신의 해시코드 반환
- 객체의 주소를 int로 변환해서 반환
- equals()의 결과가  true인 두 객체의 해시코드는 같아야함 -> 오버라이딩

### String toString()
- 객체 자신의 정보를 문자열로 반환
- getClass().getName()+"@"+Integer.toHexString(hashCode());  해시코드 반환
- iv 값을 반환하도록 오버라이딩

### void notifiy()
- 객체 자신을 사용하려고 기다리는 쓰레드를 하나만 깨운다
### void nofiryAll()
- 모두 깨운다
### void wait()
- notify 호출시까지 무한히 또는 지정된 시간동안 기다리게한다
-  wait(long timeout)
- wait(long timeout, int nanos)

### 공변 반환타입
- JDK1.5부터 오버라이딩 시 조상타입의 반환타입을 자손타입으로 바꾸는 것이 허용

---

## String 클래스
- String클래스 = 데이터(char[ ])+메서드

- 내용을 변경할 수 없는 immutable 클래스
- 덧셈 연산자를 이용한 문자열 결합은 새 객체 생성. 성능이 떨어짐.
- 변경가능한 StringBuffer 클래스 사용

### 문자열의 비교
- 등가비교연산자 : 주소비교
- str.equals : 내용비교 (오버라이딩)

### 문자열 리터럴
- 프로그램 실행 시 자동으로 생성되어 constant pool 에 저장
- 같은 내용의 문자열 리터럴은 하나만 생성. 여러 참조변수가 공유.
- 코드 작성시 같은 내용이면 새 객체 생성 x 리터럴로 작성

### 빈 문자열("")
- 크기가 0인 char형 배열을 저장.

### String 생성자
- String(String S)
- String(char[] value)
- String(StringBuffer buf) : StringBuffer 인스턴스와 같은 내용의 String 인스턴스 생성

### String 메서드

- char charAt(int index) : 지정된 위치에 있는 문자 반환
- int compareTo(Stirng str) : str와 사전순서비교. 같으면 0, 이전이면 음수, 이후면 양수반환
- String concat(String str) : str을 뒤에 덧붙인다

- boolean contains(CharSequence s) : 문자열 s가 포함되었는지 검사
  - CharSequence : 인터페이스. 문자열을 다루는 클래스들을 관계맺어줌.

- boolean startsWith(String prefix) : 지정된 문자열로 시작하는지 검사
- boolean endsWith(String suffix) : 지정된 문자열로 끝나는지 검사

- boolean equals(Object obj) : 매개변수로 받은 문자열과 비교.
- boolean equalsIgnoreCase : 대소문자 구분없이 비교.

- int indexOf(int ch) : 주어진 문자의 위치 반환. 없으면 -1반환. 0부터찾음.
  - (int ch, int pos) : 지정된 위치부터 확인
  - (String str)
- int lastIndexOf(int ch) : 뒤에서부터찾음
  - (String str)
- int length() : 문자열의 길이 반환

- String[] split(String regex) : 지정된 분리자로 나누어 배열에 담아 반환
  - (String regex, int limit) : 분리자로 나누되, 지정된 수로 자름.

- String substring(int begin) : 시작위치부터 끝위치의 문자열 반환. (끝위치는 포함x)
  - (int begin, int end)
- String trim() : 양끝의 공백을 없앤 결과 반환

- String toLowerCase() : 소문자로
- String toUpperCase() : 대문자로

- String intern() : 문자열을 constant pool에 등록. 이미 같은 내용이 있으면 주소값 반환.

- static String valueOf(boolean b) : 지정된 값을 문자열로 변환하여 반환.
  - (char), (int), (long), ...
  - 참조변수의 경우, toString()을 호출

- String.format() : 형식화된 문자열 생성.  printf 와 동일.
```
	String.format("%d 더하기 %d는 %d입니다", 3, 5, 3+5);
```

### join( )
- 여러 문자열 사이에 구분자를 넣어 결합
```
String animals= "dog,cat,bear";
String[] arr = animals.split(",");
String str = String.join("-",arr);
System.out.println(str); // dog-cat-bear
```

### 문자열과 기본형 간의 변환
- 100 + "" = "100"
- String.valueOf(100); // 100을 "100"
- Integer.valueOf("100"); "100"을 100
  - 반환타입은 Integer 이나 int 가능

- Integer.parseInt("100",n); // n진수 100을 숫자로 변환

### StringBuffer 클래스
- String 과 달리 내용 변경 가능
- sb.append("123") : 지정된 내용을 추가 후, 자신의 참조를 반환.
- 배열은 길이 변경불가. 저장할 문자열 길이 고려해서 적절한 크기로 생성해야
```
	public StringBuffer(int length){ //기본은 16
		value  = new char[length];
		shared = false;
	}
```
- equals() 가 오버라이딩 되어있지 않음. = 주소비교. -> String으로 변환 후에 equals로 내용비교

### StringBuffer 메서드

- StringBuffer( ) : 16문자를 담을 수 있는 버퍼를 가진 인스턴스 생성
- StringBuffer(int length) : 지정된 길이
- StringBuffer(String str) : str값을 갖는 StringBuffer 인스턴스 생성

- StringBuffer append( ... ) : 매개변수로 입력된 값을 문자열로 변환하여 뒤에 덧붙임
- StringBuffer delete(int start, int end) : 시작위치부터 끝위치 사이 문자 제거. (끝위치제외)
- StringBuffer deleteCharAt(int index) : 위치의 문자 제거
- StringBuffer insert(int pos, ... ) : 두번째 매개변수값을 문자열로 변환하여 지정위치에 추가.
- StringBuffer replace(int start, int end, String str) : 위치의 문자를 받은 문자열로 대체
- StringBuffer reverse( ) : 거꾸로 나열
- void setCharAt(int index, char ch) : 위치의 문자를 ch로 대체
- void setLength(int newLength) : 지정 길이로 변경. 빈공간은 null로 채움
- String toString() : 문자열을 String 으로 변환
- String substring(int begin) : 시작위치부터 끝위치의 문자열 반환. (끝위치는 포함x)
  - (int begin, int end)
- String trim() : 양끝의 공백을 없앤 결과 반환
- int capacity() : 인스턴스의 버퍼크기를 반환
- int length() : 문자열의 길이 반환

### StringBuilder
- StringBuffer는 동기화 O 멀티쓰레드에 안전. (thread-safe) Builder는 동기화 X
- 멀티쓰레드 프로그램이 아닌경우, 동기화는 불필요한 성능저하
  - 이때 Buffer 대신 Builder 사용

---

## Math 클래스
- 수학관련 static 메서드의 집합. +상수

### Math 클래스 메서드
- double abs(double a) : 절댓값 반환
  - (float), (int), (long)
- double ceil(double a) : 올림하여 반환
- double floor(double a) : 버림하여 반환
- double max(double a, double b) : 더 큰 쪽 반환
  - float int long
- double min(double a, double b) : 더 작은 쪽 반환
  - float int long
- double random() : 0.0~1.0미만 임의의 값 반환
- double rint(double a) : 가장 가까운 정수값을 double 형으로 반환, 정가운데면 짝수
- long round(double a) : 소수점 첫째자리에서 반올림한 정수값 반환

-

---

## Wrapper 클래스
- 8개 기본형을 객체로 다뤄야할 때 사용하는 클래스
```
	public final class Integer extends Number impelments Comparable{
		private int value; // 기본형 int를 포함.
	}
```
- boolean - Boolean
- char - Character
- byte - Byte
- short - Short
- int - Integer
- long - Long
- float - Float
- double - Double

### Number 클래스
- 모든 숫자 래퍼 클래스의 조상

### 오토박싱 & 언박싱
- 박싱=래핑 : int(기본형) - Integer(객체) 컴파일러가 자동으로 변환하는 것
  - 참조형과 기본형간의 연산 가능, 형변환 생략가능

---

## java.util.Objects 클래스
- 모든 메서드가 static인 Object의 보조 클래스
- 객체의 비교, null check 에 유용
```
	boolean isNull(Object obj)
	boolean nonNull(Object obj)

	static <T> T requireNonNull(T obj) //객체가 null이면 NullPointerException 발생
	static int compare(Object a, Object b, Comparator c) // Comparator : 비교기준
	
	Objects.equals() // null검사를 내장
	Objects.deepEquals() // 배열 비교 가능

	Objects.toString() // null검사 내장
	Objects.toString(Object o, String nullDefault)  /null 일때 사용할 값 지정
	
	
```

## java.util.Random 클래스
```
	int randNum = (int)(Math.random() * 6)+1*;
	int randNum = new Random().nextInt(6)+1; // 동일

	// nextDouble nextFloat...
	
```

## 정규식 - java.util.regex 패키지
- 미리 정의된 기호와 문자를 이용해 작성한 문자열
```
	Pattern p = Pattern.compile("c[a-z]*"); //c로 시작하는 소문자영단어

	1. 정규식을 매개변수로 Pattern클래스의 Pattern compile(String regex) 메서드 호출
	2. 정규식으로 비교할 대상을 매개변수로 Matcher matcher(CharSequence input) 메서드 호출
	3. if(m.matches()) // Matcher인스턴스에 boolean matches() 호출해서 확인
```

## java.util.Scanner 클래스

## java.util.StringTokenizer 클래스

## java.math.BigInteger 클래스

### BigDecimal 클래스

