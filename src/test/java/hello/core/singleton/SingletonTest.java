package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;
public class SingletonTest {

    @Test
    @DisplayName("스프링없는 순수한 DI 컨테이너")
    void pureContainer(){
        AppConfig appConfig = new AppConfig();
        //1.조회 호출할 때마다 객체를 생성(하는지 테스트)
        MemberService memberService1 = appConfig.memberService();

        //2.조회 호출할 때마다 객체를 생성(하는지 테스트)
        MemberService memberService2 = appConfig.memberService();

        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);
    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonServiceTest(){
        //new SingletonService();//프라이빗 생성자이기 때문에 생성 불가
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        System.out.println("singletonService1 = " + singletonService1);
        System.out.println("singletonService2 = " + singletonService2);

        Assertions.assertThat(singletonService1).isSameAs(singletonService2);
        //same = 객체 인스턴스 참조 비교
        //equal 같은 값인지 비교교
    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        //AppConfig appConfig = new AppConfig();
        //1.조회 호출할 때마다 객체를 생성(하는지 테스트)
        MemberService memberService1 = ac.getBean("memberService",MemberService.class);

        //2.조회 호출할 때마다 객체를 생성(하는지 테스트)
        MemberService memberService2 = ac.getBean("memberService",MemberService.class);

        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        Assertions.assertThat(memberService1).isSameAs(memberService2);
    }
}
