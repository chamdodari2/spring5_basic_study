package spring5_basic_study;

import java.lang.annotation.Annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		
		Greeter gc1 = new Greeter();
		Greeter gc2 = new Greeter();
		System.out.printf("(gc1==gc2 = %s%n", gc1==gc2);
		
		try(AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class)){ //자동으로 close 호출해줘서 적어주는거임
			Greeter g = ctx.getBean("greeter",Greeter.class);  //Greeter타입이라고 알려주기
			Greeter g2 = ctx.getBean("greeter",Greeter.class);  //Greeter타입이라고 알려주기
			
			System.out.println(g==g2); //true가 나오면 싱글턴이다
			String msg = g.greet("스프링5");
			System.out.println(msg);
		}
	}

}
