package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

    /*@Bean
    OrderService orderService(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        return new OrderServiceImpl(memberRepository, discountPolicy);
    }*/

    /*@Bean(name = "memoryMemberRepository")
    MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }*/
}
