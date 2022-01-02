package hello.core.singleton;

public class SingletonService {

    // 자기자신으로 생성함
    // static == 하나만
    // private으로 막았다
    // 가장 쉽고 편하다~ DIP 위반한다!
    // OCP를 위반할 수도 있다
    // 유연성이 떨어지고, 안티패턴으로 불린다
    private static final SingletonService instance = new SingletonService();

    // JVM 뜰때 자기자신을 생성해서 참조해서 넣어둠
    public static SingletonService getInstance() {
        return instance;
    }

    // 생성하지 못하도록 막음
    private SingletonService() {
    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }

}
