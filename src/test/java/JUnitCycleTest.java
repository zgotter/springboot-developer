import org.junit.jupiter.api.*;

public class JUnitCycleTest {
    @BeforeAll // 전체 테스트를 시작하기 전에 1회 실행하므로 메서드는 static으로 선언
    static void beforeAll() {
        System.out.println("@BeforeAll");
        // 활용 예시
        // - 데이터베이스 연결
        // - 테스트 환경 초기화
    }

    @BeforeEach // 테스트 케이스를 시작하기 전마다 실행
    public void beforeEach() {
        System.out.println("@BeforeEach");
        // 활용 예시
        // - 테스트 메서드에서 사용하는 객체 초기화
        // - 테스트에 필요한 값 미리 넣기
    }

    @Test
    public void test1() {
        System.out.println("test1");
    }

    @Test
    public void test2() {
        System.out.println("test2");
    }

    @Test
    public void test3() {
        System.out.println("test3");
    }

    @AfterAll // 전체 테스트를 종료하기 전에 1회 실행하므로 메서드는 static으로 선언
    static void afterAll() {
        System.out.println("@AfterAll");
        // 활용 예시
        // - 데이터베이스 연결 종료
        // - 공통적으로 사용하는 자원 해제
    }

    @AfterEach // 테스트 케이스를 종료하기 전마다 실행
    public void afterEach() {
        System.out.println("@AfterEach");
        // 활용 예시
        // - 테스트 이후 특정 데이터 삭제
    }
}
