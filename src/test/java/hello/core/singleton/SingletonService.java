package hello.core.singleton;

public class SingletonService {

    // 자기자신을 내부에 private으로 하나 가지고 있는데, static으로 가지고 있다 -> 클래스 레벨에 존재하기 때문에 딱 하나만 가지고 있다.
    private static final SingletonService instance = new SingletonService();

    // java가 뜰 때, 클래스 생성 시에 객체 생성한담에 자기자신을 instance생성해서 참조로 넣어둔다.
    // 이건 조회할 때. instance의 참조를 꺼낼 수 있는 방법은 이것 뿐이다.
    public static SingletonService getInstance() {
        return instance;
    }

    // 이렇게 private 생성자를 쓰면, 외부에서 new SingletonService()이렇게 별도로 만들려는 행동을하면 private이니까 막힘. 싱글톤을 해치는 경우를 막는 것
    private SingletonService() {

    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
