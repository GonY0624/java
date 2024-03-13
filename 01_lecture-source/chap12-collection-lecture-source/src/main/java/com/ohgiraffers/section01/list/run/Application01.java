package com.ohgiraffers.section01.list.run;

import java.util.*;

public class Application01 {

    public static void main(String[] args) {

        /* 수업목표. 컬렉션 프레임워크에 대해 이해할 수 있다.  */
        /* 필기.
        *   컬렉션 프레임워크(Collection FrameWork)
        *   자바에서 컬렉션 프레임워크는 여러 개의 다양한 데이터들을 쉽고 효과적으로 처리할 수 있도록
        *   표준화 된 방법을 제공하는 클래스들의 집합을 의미한다.
        *   즉, 데이터는 효율적으로 저장하는 자료구조와 데이터를 처리하는 알고리즘을 미리
        *   인도, 미국 형들이 구현해두었다.
        *  */

        /* 필기.
        *   Collection Framework 는 크게 3 가지 인터페이스 중 한 가지를 상속 받아 구현해두었다.
        *   1. List 인터페이스
        *   2. Set 인터페이스
        *   3. Map 인터페이스
        *
        *  필기.
        *   List 인터페이스와 Set 인터페이스의 공통부분을 Collection 인터페이스레서 정의하고 있다.
        *   하지만 Map 은 구조 상의 차이로 Collection 인터페이스에서 정의하고 있찌 않다.
        *  */

        /* 필기.
        *   각 인터페이스 별 특징
        *   1. List 인터페이스
        *   - 순서 있는 데이터의 집합으로 데이터의 중복 저장을 허용한다.
        *   - Vector, ArrayList★★★, LinkedList, Stack, Queue 등이 있다.
        *   2. Set 인터페이스
        *   1. 순서 없는 데이터의 집합으로 데이터 중복을 허용하지 않는다.
        *   - HashSet★★★, TreeSet 등이 있다.
        *   3. Map 인터페이스
        *   - 키와 값 한 쌍으로 이루어지는 데이터 집합이가.
        *   - key 를 Set 방식으로 관리하기 떄문에 데이터의 순서를 관리하지 않고 중복된 key 를 허용하지 않는다.
        *   - HashMap★★★, TreeMap, HashMap, Properties★ 등이 있다.
        *  */

        /* 필기.
        *   ArrayList 가장 많이 사용되는 컬렉션 클래스이다.
        *   JDK 1.2 버전부터 제공
        *   내부적으로 배열을 이용하여 요소를 관리하며, 인덱스를 이용해 배열 요소에 빠르게 접근할 수 있다.
        *  */

        /* 필기.
        *   ArrayList 는 배열의 단점을 보완하기 위해 만들어졌다.
        *   배열의 단점 : 크기 변경 불가, 요소의 추가, 수정, 삭제, 정렬, 등이 복잡함.
        *   따라서 ArrayList 는 배열의 단점을 극복하고자
        *   크기 변경(새로운 더 큰 배열 만들고 옮기기), 요소의 추가, 수정, 삭제, 정렬 기능을
        *   미리 메소드로 구현하여 제공하고 있다.
        *  */

        ArrayList alist = new ArrayList();

        /* 필기.
        *   다형성을 적용하여 상위 레퍼런스로 ArrayList 객체를 만들 수 있다.
        *   List 인터페이스 하위의 다양한 구현체들로 타입 변경이 가능하기 떄문에
        *   레퍼런스 타입은 List 로 해두는 게 더 유연한 코드를 작성하는 것이다.
        *  */
        List list = new ArrayList<>();

        alist.add("정고은");
        alist.add(990624); // autoBoxing (값 -> 객체 / int -> Integer)
        alist.add(170.5);
        alist.add(new Date());

        System.out.println("alist = " + alist);

        /* 필기. arrayList 의 크기는 size() 로 확인할 수 있다.
        *       단, size() 는 배열의 크기가 아닌 요소의 갯수를 반환한다. */
        System.out.println("alist 의 size : " + alist.size());

        for (int i = 0; i < alist.size(); i++){
            System.out.println(i + " : " + alist.get(i));
        }
        
        /* 필기. 데이터의 중복 판단
        *       중복적인 데이터들도 넣을 수 있다는 특징*/
        alist.add("정고은");
        System.out.println("alist = " + alist);

        /* 필기. 원하는 인덱스 위치에 값을 추가할 수 있다.
        *       새로운 값이 들어가는 인덱스 위치에 값을 넣고 이후 인덱스는 하나씩 뒤로 밀리게 된다.
        *  */

        alist.add(1,"박용남");
        System.out.println("alist = " + alist);
        
        /* 필기. remove() 몇 번째 인덱스의 값을 삭제할 수 있다. */
        alist.remove(2);
        System.out.println("alist = " + alist);

        /* 필기. set() 몇 번째 인덱스의 값을 수정할 수 있다.   */
        alist.set(1, true);
        System.out.println("alist = " + alist);

        List<String> stringList = new ArrayList<>();
//        stringList.add(123);  // 지정한 타입 이외에 인스턴스는 저장하지 못한다.
        stringList.add("정고은");
        stringList.add("박용남");
        stringList.add("황규원");
        stringList.add("최수연");
        stringList.add("정하은");

        System.out.println("stringList = " + stringList);

        // 필기. sort() 는 순서대로 나열
        Collections.sort(stringList);

        System.out.println("stringList = " + stringList);

        stringList = new LinkedList<>(stringList);
        
        /* 필기. 
        *   Iterator 란?
        *   Collection 인터페이스의 iterator() 메소드를 이용해서 인스턴스를 생성할 수 있다. 
        *   hasNext() : 다음 요소를 가지고 있으면 true, 더이상 요소가 없으면 false 를 반환
        *   next() : 다음 요소(값)를 반환
        *  */
        
        Iterator<String> dIter = ((LinkedList<String>)stringList).descendingIterator();
        
        /* 필기. 역순으로 정렬 된 결과를 저장하기 위해 새로운 ArrayList 를 만들어서 저장 */
        List<String> desList = new ArrayList<>();
        
        while (dIter.hasNext()){
            desList.add(dIter.next());
        }
        System.out.println("desList = " + desList);

    }

}