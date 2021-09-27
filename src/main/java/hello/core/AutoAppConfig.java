package hello.core;

import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        //basePackages = "hello.core",
        //basePackageClasses = AutoAppConfig.class,
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

    /*최근 스프링 부트는 수동빈 등록과 자동 빈 등록이 충돌이 나면 에러를 내보낸다.
    @Bean(name = "memoryMemberRepository")// 수동 빈 등록이 우선권을 가진다.
    MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }*/

}
