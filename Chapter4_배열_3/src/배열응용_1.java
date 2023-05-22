import java.util.Arrays;

/*
 *   배열 : 같은 데이터를 모아서 관리
 *        ---------
 *   변수
 *      -----
 *        10 => a  ==> int a=10; (한개만 저장하는 공간)
 *      -----          --- 기본형 (자바에서 지원하는 데이터형)
 *   배열 => 연속적으로 메모리 배치 => 인덱스번호를 이용한다
 *       arr[0] arr[1] arr[2] arr[3] arr[4]
 *       -----------------------------------
 *          1  |   2  |   3  |   4  |   5  
 *      |-----------------------------------
 *     arr  
 *     int[] arr={1,2,3,4,5};
 *   *** 자바의 메모리 구조
 *   -----------------------------------------
 *     Method Area => method,static
 *   -----------------------------------------
 *     Stack => 메모리 관리 (지역변수, 매개변수)
 *                       ------
 *                       {}안에서만 사용이 가능
 *   -----------------------------------------
 *     Heap => 동적 메모리 할당(new) => 배열 / 클래스
 *   -----------------------------------------
 *   
 *   1. 배열선언
 *      데이터형[] 배열명;
 *      데이터형 배열명[];
 *   2. 배열할당 (연속적으로 몇개를 만들지 여부)
 *      데이터형[] 배열명 = new : 메모리 만들어주고 다음에 만든 메모리의 주소값을 넘겨준다 
 *                     ---- malloc(sizeof(10)) => 승격 연산자
 *                      delete
 *                           free() ---> 개발자가 사용을 잘 안함 => GC
 *                      GC => 사용하지 않거나 / null값일 경우 자동 회수
 *                      System.gc()
 *      데이터형 배열명[] = new 데이터형[크기결정];
 *      
 *      예)
 *         int[] arr=new int[5];
 *         --------- ----------
 *          Stack      Heap(실제 데이터가 저장)
 *         -----     -----------------------------
 *         arr
 *         -----     ---[0]--[1]--[2]--[3]--[4]---
 *         0x100 -->    0    0    0    0    0
 *         -----    |-----------------------------
 *           |    0x100
 *           |
 *          new
 *          실제 저장된 데이터의 메모리 주소를 이용해서 데이터 관리 (참조변수)
 *          ==> 배열 / 클래스
 *   ** 변수 (변수, 배열, 클래스) => 초기화 후에 사용
 *          클래스(많이 사용) ==> 영화정보, 회원정보, 게시물 ...
 *          ----------
 *            ------
 *              10
 *            ------
 *             10.5
 *            ------
 *            "홍길동"
 *            -------
 *          ---------  
 *   1. 인덱스를 이용하는 방법 => 초기화
 *      int[] arr=new int[3];
 *      arr[0]=10;
 *      arr[1]=20;
 *      arr[2]=30;
 *      
 *      ---[0]---[1]---[2]---
 *          0     0     0
 *         10    20    30
 *      ---------------------
 *      
 *   2. for문을 이용해서 초기화 ==> 인덱스번호가 필요하기 때문에 일반 for문
 *      for(int i=0;i<arr.length;i++
 *      {
 *         arr[i]=(i+i)*10
 *      }
 *      ---[0]---[1]---[2]---
 *          0     0     0
 *         10    20    30
 *      ---------------------
 *   3. 선언과 동시에 초기화 
 *      --------------
 *      영화 / 뮤직 ...(파일,오라클,크롤링)
 *      int[] arr={1,2,3,4,5}; => [1,2,3,4,5](javascript)
 *      연산자 : == != , === !== , = , EL
 *      -------------------------------
 *      char[] c={'A','B'...};
 *      String[] s={"","","",""...}; => 웹 (80%)
 *   4. 배열 => 고정
 *      배열 확장 ==> 새로운 배열을 만든다
 *      배열 복사
 *      ------
 *      얕은 복사 ==> 주소를 동일하게 만든다
 *      int[] arr={}
 *      int[] arr1=arr;
 *      깊은 복사 ==> 새로운 주소 만들기
 *      int[] arr={}
 *      ***int[] arr1=arr.clone() -> 같은 크기
 *      배열을 확장했을때↓
 *      ***=> arraycopy()         
 *      ***=> for을 이용해서 데이터값만 복사
 *      
 *   *** new를 이용하는 경우 => 기본 디폴트 값이 설정된다
 *   int[]    ===> 0
 *   char[]   ===> '\u0000'
 *   String[] ===> null (모든 클래스의 기본 디폴트는 null)
 *                                          ------ 메모리 주소가 없는 경우
 *                                          ------ NullPointerException
 *   double[] ===> 0.0
 *   boolean[]===> false
 */
public class 배열응용_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// char배열 선언 => 26 ==> 초기값 => A~Z
	    char[] alpha=new char[26];
	    // 초기화
	    char c='A';
	    for(int i=0;i<alpha.length;i++)
	    {
	    	alpha[i]=c++;
	    }
	    // 출력
	    for(char cc:alpha) // 배열, 컬렉션
	    {
	    	System.out.print(cc+" ");
	    }
	    System.out.println();
	    System.out.println(Arrays.toString(alpha));

	}

}
