package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    //MemberService memberService = new MemberServiceImpl();

    MemberService memberService;

    @BeforeEach // 각 테스트 실행 전에 무조건 실행이 된다.
    public void beforeEach() {
        // 모든 테스트 실행 전에 AppConfig 만들고 memberService를 할당을 해준다.
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }


    @Test
    void join() {
        // given -> 이런 값이 주어졌을 때
        Member member = new Member(1L, "memberA", Grade.VIP);

        // when -> join을 했을 때
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        // then
        Assertions.assertThat(member).isEqualTo(findMember);
        // 내가 방금 join한거랑 찾은거랑 똑같냐
    }
}
