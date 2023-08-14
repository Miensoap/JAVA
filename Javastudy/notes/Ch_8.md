# 예외처리
---

### 프로그램 오류
- 컴파일 에러(compile-time error)
- 런타임 에러(runtime error)
- 논리적 에러(logical error) : 작성 의도와 다르게 동작

- 에러(error)  : 프로그램 코드에 의해 수습될 수 없는 심각한 오류
- 예외(exception) : 수습될 수 있는 다소 미약한 오류

- 예외처리(exception handling) : 프로그램의 비정상 종료를 막기 위해 예외에 대비한 코드 작성

### 예외 클래스의 계층 구조
- Object - Throwable - Exception - ...
    - Error - ...

- Exception과 그 자손들 : 외적인 요인에 의해 발생
    - IOException(입출력예외) , ClassNotFoundException
- RuntimeException과 그 자손들 : 프로그래머의 실수로 발생
    - ArithmeticException(산술계산예외), ClassCastException(형변환예외)
    - NullPointerException , IndexOutOfBoundsException

### try-catch 문
```
try{
	// 예외가 발생할 가능성이 있는 문장들
}catch(Exception1 e1){
	/// Exception1이 발생했을 경우, 이를 처리하기 위한 문장
}catch(Exception2 e2){
	/// ..
}catch(Exception ee){
	/// 모든 예외 처리
}
```
- try 블럭 내에서 예외가 발생하면, 일치하는 catch블럭을 위부터 instanceof 연산자로 찾음
- catch 블럭 내 문장 수행 후 try-catch문 전체를 나감
- 일치하는 catch블럭을 찾지 못하면 예외 처리 X

- Exception 이 선언된 catch블럭은 모든 예외를 처리 (마지막에 선언)

### printStackTrace(), getMessage()
- 예외 클래스의 메서드
- 예외가 발생하면 해당 예외 클래스의 객체가 생성, 해당 참조변수로 메서드 사용

- printStackTrace() : 예외발생 당시에 callStack에 있던 메서드의 정보와 예외 메시지를 출력
- getMessage() : 예외 인스턴스에 저장된 메시지를 반환
```
try{
	System.out.prinln(0/0); // ArithmeticException 발생
} catch (ArithmeticException ae){
	ae.printStackTrace();
	System.out.println("예외메시지 : "+ ae.getMessage());
}
// 참조변수 ae의 scope는 catch 블럭 내
```
```
	java.lang.ArithmeticException: / by zero
	at Jungsuck.Ex_8.Ex8_1.main(Ex8_1.java:6)
	예외메시지 : / by zero
```

### 멀티 catch블럭
- 내용이 같은 catch블럭을 하나로 합친 것(JDK1.7부터)
```
}catch (ExceptionA | ExceptionB e){
	e.printStackTrace();
}
```
- instanceof 연산자로 찾기 때문에 조장-자손 관계인 예외를 멀티catch 블럭으로 만들 필요X 에러.
- 한쪽 예외 클래스에만 있는 멤버(메서드)는 사용 불가.

### 예외 발생시키기
- 연산자 new를 이용해서 예외 클래스의 객체 생성 후 키워드 throw 이용해서 발생
```
try{
	Exception e = new Exception("예외발생") // 메시지
	throw e;
	} catch (Exception e){ ... }
	
	// throw - catch 
```

### checked / unchecked 예외
- checked 예외 : 컴파일러가 예외 처리 여부를 체크. 컴파일에러 (Exception과 그 자손)
- unchecked 예외 : 컴파일러가 예외 처리 여부 체크 안함 (RuntimeExceptoion과 그 자손)

### 예외 선언
- 메서드가 호출시 발생 가능한 예외를 호출하는 쪽에 알림.  'throws'
```
 void method() throws Exception { // 모든 종류의 예외가 발생 가능
 }
 stacic void startInstall() throws SpaceException, MemoryException{
	 if(!enoughSapce())
		 throw new SpaceException("설치할 공간이 부족합니다.") // 예외 발생
 }
```
- checked 예외만 throws로 선언

-  메서드 내에서 처리안된 예외는 호출한 메서드로 , main 메서드 다음은 JVM의 예외처리기
```
// 비정상 종료
Exception in thread "main" java.lang.Exception
	at Ex8.method2(Ex8.java:11)
	at Ex8.method1(Ex9.java:7)
	at Ex8.main(Ex8.java:3)
```

### finally 블럭
- 예외 발생 여부와 관계없이 수행되어야 하는 코드를 넣는다.
- try 블럭을 return 문으로 벗어날 때도 finally 블럭은 실행된다.

### 사용자 정의 예와
- Exception 이나 RuntimeException 을 조상으로 하는 예외 클래스를 직접 정의
```
class MyException extends Exception{
	MyException(String msg){  //String 매개변수가 있는 생성자.
		super(msg);
	}
}
```

### 예외 되던지기(re-throwing)
- 예외를 처리한 후에  다시 예외를 발생시키는 것
- 호출한 메서드와 호출된 메서드 양쪽 모두에서 예외처리하는 것. 분담처리.

### 연결된 예외(chained exception)
- 한 예외가 다른예외를 발생시킬 수 있다. 원인 예외(cause exception)
```
Throwable initCause(Trowable cause) // 지정한 예외를 원인 예외로 등록
Throwable getCause() // 원인 예외를 반환
```
- Throwable 클래스내에 cause 멤버.  this로 초기화되있음.
```
void install() throws InstallException{
	startInsatll(); // SpaceException 발생 
	catch(SpaceException e)
	InstallException ie = new InsatllException("설치중 예외발생"); // 예외생성
	ie.initCause(e); // InstallException의 원인 예외로 SpaceException 지정.
	throw ie; // InsatllException 발생시킴
} catch(...){ ... }
```
- 여러 예외를 하나로 묶어서 다루기 위함
- checked 예외를 unchecked예외로 변경할 때 사용
    - Exception을 RuntimeException의 원인 예외로 등록