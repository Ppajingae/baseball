# 숫자 야구 게임 구현

![사진1](https://github.com/Ppajingae/baseball/blob/dev/src/main/kotlin/img/1.png)

## 1. 큰 틀 에서의 구현

### 1-1 IO Interface 와 그 관계

- 이번 구현 에서 가장 헥심을 둔 부분은 큰 틀 에서의 구현 입니다 그동안 생각 나는 대로 코드를 작성 했다면 이번 에는 역할을 구상한 다음에 각자에 역할에 맞게끔 객체를 생각 했습니다 

- 최초에 의도 했을때는 여러 개의 Input이 필요 할 것 같아서 클래스를 직접 상속 받아 주입을 시켜주었지만 막상 처음에는 따로 쓸 일이 없어서 그냥 상속 구현을 해체 시켰습니다 그런데 2단계 부가기능 구현 아후에 필요성을 느껴 아래와 같이 관계를 구성했습니다 

![사진2](https://github.com/Ppajingae/baseball/blob/dev/src/main/kotlin/img/2.png)

### 1 - 2 Validator와 그 관계 구현

- validator 부분도 숫자 값 확인, 숫자 길이 확인, 숫자 중복 확인이 필요 하여 ValidatorInterface 라는 큰 인터페이스로 구현 했습니다

- IO와 달리 직접 값을 받아서 구현 하기 때문에 따로 자식 클래스를 컨트롤 하는 함수를 만들어서 업케스팅 하는 식으로 클래스 관계를 구성 했습니다

- 추가적으로 message를 매개변수로 받으면서 알림을 쉽게 고칠 수 있도록 설계했습니다


![사진3](https://github.com/Ppajingae/baseball/blob/dev/src/main/kotlin/img/3.png)

### 1 - 3 Game 클래스

- 게임 내부 로직 클래스 입니다 해당 클래스의 역할은 게임 정보를 받아와서 게임을 진행시키는 역할을 합니다

- ```run()``` 함수에서는 기존에 유저의 대답과 게임 기록을 저장하는 로그만은 매개변수로 받았었지만 0을 추가로 하는 룰이 추가되어서 동시에 rule이라는 매개변수도 받고 있습니다

- 사실 이 부분은 리펙터링 과정에서 복잡함이 느껴져서 다시 리펙터링을 고민하고 있는 부분이기도 합니다

- ```gameLogic()``` 부분은 특별할 거 없이 유저의 답이 일치 한지 안한지 확인 하는 함수지만 게임 로그 클래스를 받으면서 게임 로그의 값들을 저장하는 함수입니다

![사진4](https://github.com/Ppajingae/baseball/blob/dev/src/main/kotlin/img/4.png)

### 1 - 4 Answer 클래스

- 현재 제가 생각하고 있는 클래스 중에서 제일 애메한 클래스 입니다

- 처음에는 랜덤한 값을 전달만 하는 클래스 였는데 추가 구현 이후 0이 있는 게임 이냐 0이 없는 게임 이냐를 구분 하는 역할 까지 해서 해당 부분은 추가적 으로 리펙토링 예정 입니다

![사진5](https://github.com/Ppajingae/baseball/blob/dev/src/main/kotlin/img/5.png)

### 1 - 5 GameLog 클래스

- 게임의 로그를 담당 하는 클래스 입니다 게임의 로그 카운트를 해주고 결과를 세이브 및 제공 하는 역할을 합니다
- 사실 처음 에는 데이터 관리를 Interface 가 관리를 하고 그 Interface를 나머지 클래스 들이 상속을 받으면서 구현을 하려고 했지만 GameLog 클래스가 미묘하게 구성이 달라서 추상 클래스로 정의하고 save 함수를 open하여 재정의 하게끔 구현하였습니다

![사진6](https://github.com/Ppajingae/baseball/blob/dev/src/main/kotlin/img/6.png)

### 1 - 6 Menu 클래스

- 사실 이 2개 클래스는 리펙터링 시에 하나의 Interface를 상속 받아서 구현하는 게 좋을 것 같다는 생각이 들지만 현재는 우선 서로 다른 2가지 클래스로 존재합니다
- 정확히 말하면 menu에서 1을 클릭시에 subMenu로 넘어가는 식으로 구현을 하였습니다

![사진7](https://github.com/Ppajingae/baseball/blob/dev/src/main/kotlin/img/7.png)

## 게임 시작

- 1번을 입력할 경우 원하는 난이도를 설정할 수 있도록 구현 하였습니다

![사진8](https://github.com/Ppajingae/baseball/blob/dev/src/main/kotlin/img/8.png)

- 1번을 선택 하면 0을 추가 하고 2번을 선택 하면 0을 제외한 나머지 수만 가지고 게임을 합니다

![사진9](https://github.com/Ppajingae/baseball/blob/dev/src/main/kotlin/img/9.png)

- 위치와 숫자가 일치 하면 Strike 숫자만 맞으면 Ball 둘다 아니면 Nothing으로 구현 하였습니다

![사진10](https://github.com/Ppajingae/baseball/blob/dev/src/main/kotlin/img/10.png)

- 값에 이상한 글자가 들어갈 경우 검사 하여서 다시 입력 받을 수 있게끔 구현 하였습니다

![사진11](https://github.com/Ppajingae/baseball/blob/dev/src/main/kotlin/img/11.png)

- 2번을 입력하면 로그를 출력 할 수 있게끔 구현 하였습니다
  
![사진12](https://github.com/Ppajingae/baseball/blob/dev/src/main/kotlin/img/12.png)

- 3번을 클릭하면 게임이 종료가 되게끔 구현을 하였습니다 그외 나머지 값을 입력시 잘못된 값이라고 오류가 발생합니다

![사진13](https://github.com/Ppajingae/baseball/blob/dev/src/main/kotlin/img/13.png)

## 기타 버그 및 수정 사항

1. Strike와 Ball 그리고 Nothing 을 기존에 이중 반복문을 통해서 구현을 하였지만 이 부분을 개선을 하여 시간복잡도를 일부 해결했습니다

#### AS-IS
```
 computerAnswer.forEachIndexed{ index, it ->
            if(it == userAnswer[index]) {
                strikeCount++

            }else{
                userAnswer.forEachIndexed{ userIndex, userIt ->
                    if(it == userIt) {
                        ballCount++
                    }
                }
            }
 ... 이하 생략           
```
#### TO-BE

```
computerAnswer.forEachIndexed{ index, it ->
            if(it == userAnswer[index]) strikeCount++
            else if(it in userAnswer) ballCount++

            nothingCount = GameRule.LENGTH.number - (strikeCount + ballCount)
            
... 이하 생략   
```

2. 0을 추가 하는 게임을 만드는 과정 에서 로그가 기록이 안되는 버그가 발생 하여 수정 했습니다

#### AS-IS
- SubMenu 클래스를 만드는 과정 에서 Menu 클래스를 전부 복사 하고 미처 ```GameLog()``` 생성자를 삭제하지 못하여 발생한 현상입니다

#### TO-BE
- 문제가 되는 생성 부분을 삭제하고 Menu 클래스에서 주입을 받는 방법으로 수정 하였습니다

```
// 함수에 gameLog 매개변수 생성
fun get(gameLog: GameLog):Int{
        val str = subMenuInput.input(bufferedReader)
        try {
... 이하 생략     


//Menu에서 생성한 gameLog를 subMenu의 인자로 전달
class Menu {
    private val gameLog = GameLog()
    private val subMenu = SubMenu()

    fun main(str: String):Int{
        try {
            when(str){
                "1" -> {
                    return subMenu.get(gameLog)
... 이하 생략   

```

##### 버전 정보
- JVM.ver : temurin-18.0.2.1
- Kotlin.ver : 1.9.20
