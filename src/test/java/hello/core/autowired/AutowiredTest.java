package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    static class TestBean {

        @Autowired(required = false)    // true로 하면 예외가 터진다. Member가 spring bean으로 등록되는게 아니기 때문
        public void setNoBean1(Member noBean1) {
            System.out.println("noBean1 = " + noBean1); // false로 하면 이거 자체가 호출이 되지 않는다.
        }

        @Autowired
        public void setNoBean2(@Nullable Member noBean2) {  // Nullable로 하면 호출은 되지만, null로 들어옴
            System.out.println("noBean2 = " + noBean2);
        }
        @Autowired
        public void setNoBean3(Optional<Member> noBean3) {  // Optional.empty이렇게 출력됨
            System.out.println("noBean3 = " + noBean3);
        }

    }
}
