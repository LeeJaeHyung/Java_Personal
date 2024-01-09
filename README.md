#java_Personal

 ## 과제 소개

<aside>
내가 좋아하는 카페 또는 패스트푸드점의 키오스크를 만들어보자!

- 지금까지 배워온 Java 언어를 사용하여 **키오스크** 프로그램을 만들어봅시다.
- 내가 좋아하는 카페나 패스트푸드점의 메뉴판 데이터를 사용하면 더 재밌겠죠
</aside>

- 필수 요구사항
    
    > **Java 클래스 설계 시 필수 요구사항!**
    > 
    > - 메뉴 클래스는 이름, 설명 필드를 가지는 클래스로 만들어주세요.
    > - 상품 클래스는 이름, 가격, 설명 필드를 가지는 클래스로 만들어주세요.
    > - 상품 클래스의 이름, 설명 필드는 메뉴 클래스를 상속받아 사용하는 구조로 개발해주세요.
    > - 주문 클래스도 만들어서 상품 객체를 담을 수 있도록 해주세요.


    1. 메인 메뉴판 화면
        - 메인 메뉴판이 출력되며 메뉴판에는 상품 메뉴가 출력 됩니다.
        - 상품 메뉴는 간단한 설명과 함께 출력 되며 최소 3개 이상 출력 됩니다.
        - 상품 메뉴 아래에는 Order(주문)와 Cancel(주문 취소) 옵션을 출력해줍니다.
        ![image](https://github.com/LeeJaeHyung/Java_Personal/assets/69907023/a6b26e9f-4dfa-4fed-82c4-2936b1620a8c)



    2. 상품 메뉴판 화면
        - 상품 메뉴 선택 시 해당 카테고리의 메뉴판이 출력됩니다.
        - 메뉴판에는 각 메뉴의 이름과 가격과 간단한 설명이 표시됩니다.
        ![image](https://github.com/LeeJaeHyung/Java_Personal/assets/69907023/c349fb42-66f8-4a32-881b-e5c468060d1a)
        ![image](https://github.com/LeeJaeHyung/Java_Personal/assets/69907023/441cfa8a-6d4b-4509-ba00-b46c4c4b8c0d)





    3. 구매 화면
        - 상품 선택 시 해당 상품을 장바구니에 추가할지 확인하는 문구가 출력 됩니다.
        - `1.확인` 입력 시 장바구니에 추가되었다는 안내 문구와 함께 메인 메뉴로 다시 출력 됩니다.
        ![image](https://github.com/LeeJaeHyung/Java_Personal/assets/69907023/1583f87e-19f5-43ec-88f4-28ea33f76a23)
        ![image](https://github.com/LeeJaeHyung/Java_Personal/assets/69907023/455dd299-b9fe-4732-9eb7-4fefe7db62ed)
        ![image](https://github.com/LeeJaeHyung/Java_Personal/assets/69907023/8ec68f1d-a67f-43e0-a55d-eb7f0ec4209c)
        ![image](https://github.com/LeeJaeHyung/Java_Personal/assets/69907023/7f66ca2d-669d-4299-899f-8333f9449a34)

      


    4. 주문 화면
        - `5.Order` 입력 시 장바구니 목록을 출력해줍니다.
        - 장바구니에서는 추가된 메뉴들과 총 가격의 합을 출력해줍니다.
        - `1.주문` 입력 시 주문완료 화면으로 넘어가고, `2.메뉴판` 입력 시 다시 메인 메뉴로 돌아옵니다.
        ![image](https://github.com/LeeJaeHyung/Java_Personal/assets/69907023/f498ec7f-866f-49c8-bb04-5e4381a28d25)
       

        



    5. 주문완료 화면
        - `1.주문` 입력 시 대기번호를 발급해줍니다.
        - 장바구니는 초기화되고 3초 후에 메인 메뉴판으로 돌아갑니다.
        ![image](https://github.com/LeeJaeHyung/Java_Personal/assets/69907023/b0288647-7f22-4545-9fb4-9af936e237a0)


    6. 주문 취소 화면
        - 메뉴판에서 `6.Cancel` 입력시 주문을 취소할지 확인을 요청하는 문구가 출력 됩니다.
        - `1.확인` 을 입력하면 장바구니는 초기화되고 취소 완료 문구와 함께 메뉴판이 출력 됩니다.
        ![image](https://github.com/LeeJaeHyung/Java_Personal/assets/69907023/6b3be254-5014-4a3f-802a-e66a6b957572)


       
