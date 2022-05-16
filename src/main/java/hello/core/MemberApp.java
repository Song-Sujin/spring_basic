package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
        //AppConfig appConfig = new AppConfig();
        //MemberService memberService = appConfig.memberService();

        // AppConfig에 있는 환경설정 정보를 가지고 @Bean 붙은거를 찾아서 스프링 컨테이너에 객체를 집어 넣어서 관리해준다.
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        // 원래는 내가 new로 직접 찾아왔다면, 이제는 스프링 컨테이너를 통해서 찾아와야한다.
        // 첫번째 매개변수는 이름이다. @Bean으로 등록했다면 컨테이너에는 기본적으로 메소드 이름으로 등록되기 때문에 memberService로 가져올 수 있다.
        // 두번째 매개변수는 타입니다.
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        // 기존에는 아래처럼 직접 main메소드에서 MemberServiceImpl를 생성을 해주었다.
        // MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());         // 위에서 새로 만든 member
        System.out.println("find Member = " + findMember.getName());    // 새로 만든 member의 id인 1L로 member 찾기
        // 동일한 memberA가 나온다.
        // 이건 그냥 순수한 java 코드
    }
}
