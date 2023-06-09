package com.sist.temp2;
/*
 *    자바 정리 => 웹 관련
 *    ----------------
 *    1) 변수 (25page)
 *       --------------------------------------------------------
 *                      메모리에 저장되는 시점             사용범위
 *                      초기화되는 시점 
 *       --------------------------------------------------------
 *        멤버변수                                     프로그램 종료시
 *        (인스턴스 변수)   메모리 할당 
 *                      new를 사용 
 *                      Class.forName()
 *        class ClassName
 *        {
 *        	[접근지정어] 데이터형 변수명
 *          --------- 데이터 보호를 목적으로
 *                    은닉화
 *                    접근지정어는 보통  private
 *                    
 *        }
 *        변수 => 메모리에 저장 / 메모리에서 읽기
 *              ----------  ------------
 *                쓰기         읽기
 *                ---------------
 *                getter  /  setter
 *        => 사용법
 *           클래스 객체명=new 클래스명();
 *           객체명.변수명
 *           ----------
 *           객체=인스턴스 => 동일 개념 
 *       --------------------------------------------------------
 *        정적변수             컴파일러가 컴파일을 했을 때     프로그램 종료시까지
 *        (공유변수,           JVM이 클래스 읽기
 *         클래스변수)          => 메모리 할당이 자동
 *         
 *         => 메모리 할당없이 사용이 가능
 *         => 클래스명.변수명
 *         => 여러명이 같은 변수를 이용할 때 주로 사용
 *            -----------------------------
 *            웹 => 로고, 이미지 크기 ...
 *            서버 => 클라이언트 정보 (IP)
 *            오라클(MySQL => 데이터베이스) ==> 공유 (저장된 데이터는 static)
 *       --------------------------------------------------------
 *        지역변수(25page)   ==> 메소드가 호출될때 메소드안에서만 사용이 가능
 *        변수 : 한개의 데이터를 저장하는 공간
 *        우선 => 변수명이 동일할때 우선순위
 *        => 지역변수, 매개변수
 *           ------ 반드시 초기화 후에 사용 
 *                       -------
 *                       1) 명시적인 초기화 int a=10;
 *                       2) 입력값을 받는 경우
 *                          => getParameter() (웹)
 *                       3) 난수 발생 (임의로)
 *       --------------------------------------------------------
 *       메모리 공간에 저장 => 종류 (데이터형)
 *       => 변수 (70%) => 제어문, 연산자
 *       ----------------------------------------
 *        정수형
 *           byte : 네트워크 통신, 파일 입출력, 웹
 *                     -----------------------
 *                     ASC코드를 주로 사용 (char:1byte)
 *                     한글 => 멀티바이트 (char:2byte) => Unicode
 *                            => UTF-8 
 *                     => 사용범위 => -128~127
 *              => 웹프로그래머 : 자바(80%), 오라클(20%)
 *              웹브라우저   <===>   오라클
 *                       연결이 안됨
 *                 |               |
 *              사용자 화면 출력     화면 출력 데이터 저장
 *              
 *              웹브라우저 <===> 프로그램 언어 (자바) , C# , C/C++ , 파이썬
 *                       연결  ---------------
 *              오라클 <=====> 자바
 *                     연결 
 *                     
 *              자격조건 : 스프링 가능자 , 오라클 가능자 
 *                      ---------- 자바 포함 (스프링은 자바의 라이브러리)
 *                      => 어노데이션, 디자인 패턴, XML파싱
 *                      => 스프링 (5, 6 => 프레임워크 / 부트)
 *                      
 *           int : default => 컴퓨터에서 인식 숫자 (int 인식)
 *              => 가장 많이 사용되는 정수형
 *              => 웹/윈도우는 정수를 인식하지 못한다 (문자열)
 *                 => 정수 변환 : Integer.parseInt("10")
 *              => 사용범위 : -21억 4천~21억 4천
 *              
 *           long : 빅데이터, 금융권, 회계권(국세청) 
 *              => -2^63 ~ 2^63-1
 *           ==> byte / int / long   
 *       ----------------------------------------
 *        실수형 : 
 *           double : 소수점 15자리 이상 사용
 *           => 컴퓨터 인식은 실수일 경우 (default)
 *       ----------------------------------------
 *        논리형 : true/flase 저장 => 조건문, 제어문에 많이 사용
 *           boolean
 *       ----------------------------------------
 *        문자형 : char(2byte) ==> Unicode
 *               문자 표현이 많다 => 각국의 언어 사용이 가능
 *               *** 한글은 1글자당 2byte를 가지고 있다
 *               리눅스/맥/윈도우 => 호환이 가능
 *               => 문자열을 여러개 모아서 저장 => String
 *       ----------------------------------------
 *        참조형 : 주소를 이용해서 데이터를 관리
 *           배열 => 같은 데이터형만 저장이 가능 (1차원까지 공부)
 *           클래스  => 다른 데이터형을 저장이 가능
 *       ----------------------------------------
 *       
 *       기본형의 크기
 *         byte < int < long < double => 형변환
 *         (boolean은 제외)
 *         => 수 표현에 따라 크기가 달라진다
 *       ------------------------------------- 30page
 *       
 *       변수 생성 방법 (식별자) => 같은 메소드상에서는 같은 변수가 존재하지 않는다
 *       = 식별자
 *         1) 알파벳/한글 사용 가능 (대소문자 구분)
 *         2) 숫자 사용이 가능 (앞에 사용 금지)
 *         3) 특수문자 사용 (_ , $)
 *         4) 키워드는 사용 불가 (메소드명, 클래스명은 키워드가 아니다)
 *         5) 변수에 공백이 없다
 *         -------------------------- 오라클 , 자바스크립트에서도 동일
 *            오라클 (변수 => 컬럼) , 자바스크립트는 자동지정변수
 *                                ES6 => let, const
 *                                let a=10 => a:int
 *                                let a=10.5 => a:double
 *                                const => final
 *        => 약속 사항
 *           1) 클래스명은 대문자로 시작
 *              ----- 인터페이스 포함
 *           2) 메소드명, 변수명은 소문자로 시작
 *           3) 두개 이상의 단어로 만드는 경우
 *              ------------ 두번째 단어는 첫자를 대문자로 한다 
 *                           (헝가리언식 표현법)
 *              예) FileName
 *                 File_Name
 *              => _로 시작하는 클래스,변수,메소드는 임시변수
 *                 temp 
 *        ---------------------------- 25~37page
 *        
 *        데이터 저장   ======> 데이터 처리   ======> 데이터 출력
 *        --------
 *          변수              연산처리(연산자)
 *          배열 /클래스        제어처리(제어문)
 *                          ------------
 *                           + => 메소드
 *        ----------------------------------------------  
 *        38page 연산자, 메소드
 *        ------------------
 *        자바에서 지원하는 연산자 (피연산자 / 연산자)
 *        단항연산자
 *          => 피연산자가 한개일때
 *          => 증감연산자 (++ , --)
 *             1) 전위연산
 *                ++a
 *             2) 후위연산
 *                a++
 *             --------- 연산 순서
 *             int a=10;
 *             int b=++a;
 *                   --
 *                    1
 *                  =
 *                  2  ===> 증가후에 대입
 *                              
 *             int a=10;
 *             int b=a++;
 *                  --
 *                   1
 *                   --
 *                    2 ==> 대입후에 증가
 *             *** ++a , a++ => 한개를 증가하는 것은 같다
 *                 ---------- 제어문 (반복문)
 *                 ---------- 오라클은 ++ , -- 는 존재하지 않는다 
 *          => 부정연산자 : ! => boolean으로 표현
 *                       => 조건문 , 반복문에서 주로 사용
 *                       => 오라클 : NOT, <>
 *          => 형변환연산자 : (데이터형) => 변수앞에 설정한다
 *             => boolean은 사용이 불가능
 *             => 클래스의 형변환 
 *             => 모든 데이터형을 통합이 가능 : Object
 *        이항연산자
 *          => 산술연산자 : 가장 많이 사용되는 연산자
 *             +, - , * , / , %
 *             1) + : 실제 산술 (덧셈) ,  문자열 결합 ( "" )
 *             2) / : 0으로 나눌 수 없다
 *                정수/정수=정수
 *                ----------
 *             3) % : 왼쪽편의 부호를 따라간다
 *          => 비교연산자 : 조건문 => 계산 결과 : boolean
 *             == , != , < , > , <= , >=
 *             --------
 *             오라클 : = , <> , ^=
 *             자바스크립트 : ===, !==
 *          => 논리연산자 : &&(직렬) => 두개가 true일때 true,
 *                       ||(병렬) => 둘중에 1개 이상 true일때 true
 *                       *** 효율적인 연산
 *                       && => 앞에 조건 false => 뒤에 조건은 수행하지 않는다
 *                       ---- 포함
 *                       || => 앞에 조건 true => 뒤에 조건은 수행하지 않는다
 *                       ---- 포함이 안된 경우
 *          => 대입연산자 : 결과값 대입
 *                       = , += , -=
 *                       int a=10;
 *                       a+=10 ======> a=a+10
 *          => 학원 지원 업체 (2600~2800)
 *          => 전기수 업체 (기본 3000~3600) => VueJS/ReactJS
 *          --------------------------------------------
 *          
 *        삼항연산자 : 웹에서 자주 사용 => if~else를 줄여서 사용
 *                  => 웹, 게임
 *        예) JSP+HTML
 *           <%
 *              if(curpage>1)
 *              {
 *                 curpage--;
 *           %>
 *                <a href="list.jsp?page=<%=curpage%>">이전</a>
 *           <%
 *              }
 *              else
 *              {
 *           %>
 *                <a href="list.jsp?page=<%=curpage%>">이전</a>
 *              }
 *           %>
 *        
 *       =>  <a href="list.jsp?page=<%=curpage%>1?curpage-1:curpage">이전</a>
 *       -------------------------------------------------------------------
 *       37~53page => 연산자
 *       ----------
 *       
 *       제어문 : 54page
 *       --------------
 *       
 *       자바에서 제공하는 제어문
 *       -----------------
 *       => 프로그램에 따라
 *          소스를 건너뛸 수도 있고 => 반복 수행 => 제어
 *       => 
 *          조건문 
 *            단일 조건문 : 독립적 수행문장 (조건마다 따로 수행)
 *            --------
 *            형식)
 *                if(조건문) => 조건문에 사용되는 연산자
 *                {           부정연산자/비교연산자/논리연산자만 사용이 가능
 *                   조건 => true일 경우 수행하는 문장
 *                }
 *            선택 조건문 : true/false를 나눠서 처리 
 *                if(조건문)
 *                {
 *                   조건 => true일때 처리
 *                }
 *                else 
 *                {
 *                   조건 => false일때 처리
 *                }
 *                --------------- 한줄로 줄여서 사용 : 삼항연산자 이용
 *                --------------- 가장 많이 사용되는 조건문
 *            다중 조건문 : 한문장으로 되어있다
 *                       해당 조건만 수행
 *               if(조건문)
 *               { 
 *                  조건 : true일때 수행 ==> 종료
 *                  조건 : false일땐 아래 조건으로 이동
 *               }
 *               else if(조건문)
 *               {
 *                  조건 : true일때 수행 ==> 종료
 *                  조건 : false일땐 아래 조건으로 이동
 *               }
 *               else if(조건문)
 *               {
 *                  조건 : true일때 수행 ==> 종료
 *                  조건 : false일땐 아래 조건으로 이동
 *               }
 *               else 
 *               {
 *                  해당 조건이 없는 경우 수행되는 문장 
 *               }
 *          반복문 : 
 *                 반복횟수가 지정된 경우 : for
 *                    => 화면 출력시에 주로 사용 (HTML) => Front
 *                    
 *                    형식)
 *                             1    2    4
 *                        for(초기값;조건식;증가식)
 *                        { 
 *                           반복 수행문 3
 *                        }
 *                        1-2-3-4
 *                          2-3-4
 *                          2-3-4 ==> 2번 false면 종료
 *                      -------------------------------------------    
 *                        for(데이터형 변수:배열/컬렉션)
 *                        {   --------- 일반변수/클래스일수도 있다
 *                           => 향상된 for , for-each => 웹에서 출력
 *                        }
 *                        주의점 => 데이터형 변수는 형변환이 불가능
 *                      -------------------------------------------    
 *                 반복횟수가 지정이 안된 경우 : while
 *                    => 파일 읽기 / 데이터베이스(오라클) 읽기 
 *                    형식)
 *                        초기값 --------- 1
 *                        while(조건식) -- 2
 *                        {
 *                           반복수행문장 -- 3
 *                           증가식     -- 4
 *                        }
 *                        => 순차적으로 수행
 *                        => 1-2-3-4
 *                             2-3-4
 *                             2-3-4 ==> 2번 false면 종료
 *                        while은 무한루프에서 많이 사용
 *                        => 파일 읽기
 *                           while((i=in.read())!=-1)
 *                           {
 *                              => 파일 읽기
 *                           }
 *                           
 *                           while(rs.next())
 *                           {
 *                              => 오라클 데이터 읽기
 *                           }
 *                           
 *                           while(st.hasMoreTokens())
 *                           {
 *                              => 단어별 구분
 *                           }
 *          반복제어문 : break => 반복문을 중단할때 사용
 *                    ** 자신의 반복문만 중단이 가능
 *                    for() ===> 1차 for문
 *                    {  
 *                       for() ===> 2차 for문
 *                       {
 *                          break; ==> 2차 for문만 종료
 *                       }
 *                       
 *                          break; ==> 1차 for문 제어
 *                    }
 *        =========================================================
 *        메소드
 *         => 한가지 기능만 수행이 가능 (재사용 목적)
 *         => 반복 수행을 제거
 *         => 구조적인 프로그램을 만들대 사용
 *            ------------ 단락을 나눠서 처리
 *            ------------ 에러 처리
 *            ------------ 수정시에 
 *         형식)
 *              [접근지정어] [옵션] 리턴형 메소드형(매개변수 목록) : 선언문
 *              {
 *                 구현부
 *              }
 *              접근지정어는 다른 클래스와 통신을 담당 => 공개(public)
 *              옵션 => static / abstract (선언부만 사용)
 *                   
 *              예)
 *                 리턴형 : 결과값(처리) ==> 1개만 사용이 가능
 *                        *** 결과값이 없는 경우에는 void를 사용한다
 *                        *** 리턴형으로 사용
 *                            1) 기본 데이터형
 *                            2) 클래스 
 *                            3) 배열 
 *                 매개변수: 사용자 요청값 ==> 여러개 사용이 가능
 *                        *** 3개 이상이면 배열/클래스로 받는다
 *                 ***** 매개변수는 많이 사용하면 처리하기 어렵다 (최소화)
 *                 
 *                 리턴형 메소드명(매개변수)
 *                 {
 *                    return => void일때는 생략이 가능
 *                    return 값 => 값은 리턴형 데이터와 동일하게 만든다
 *                                 리턴형이 더 클 수 있다
 *                 }
 *                 
 *         --------------------------------------------------
 *         메소드 유형
 *         ------------------------------
 *                  리턴형      매개변수
 *         ------------------------------
 *                   O          O  => 오라클 : SELECT => 클래스/컬렉션
 *                     *** => page구분
 *         ------------------------------
 *                   O          X  => 오라클 : SELECT
 *         ------------------------------ 
 *                   X          O  => 오라클 : INSERT/UPDATE/DELETE
 *                                    오라클 자체에서 수행
 *                     *** => 추가할 데이터 첨부
 *         ------------------------------
 *                   X          X
 *         ------------------------------
 *         
 *         소스가 많기 때문에 나눠서 처리 할 경우에 주로 사용
 *         -------------------------------------
 *         => 사용자 입력 처리
 *         => 사용자 요청 처리 ==> 여러개를 나눠서 처리가 가능
 *         => 사용자 출력 처리
 *         ---------------
 *         
 *         변수 / 메소드 => 모아서 처리(클래스)
 *         ----------
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
