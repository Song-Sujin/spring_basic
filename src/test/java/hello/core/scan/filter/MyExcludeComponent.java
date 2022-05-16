package hello.core.scan.filter;

import java.lang.annotation.*;

@Target(ElementType.TYPE)   // TYPE이면 class레벨에 붙는 것
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyExcludeComponent {  // MyExcludeComponent이게 붙은거는 componentScan에서 제외할거야
}
