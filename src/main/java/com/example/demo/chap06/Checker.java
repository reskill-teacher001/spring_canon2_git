package com.example.demo.chap06;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Checker {
	//この中にコントローラで行われたメソッドの処理の
	//前後に呼び出されるメソッドを定義する
	
	@Autowired
	User user;
	
	@Around("execution(* com.example.demo.chap06.CanonController.test*(..))")
	public Object check05(ProceedingJoinPoint jp) throws Throwable {
		//アドバイスを記述
		//Object result = jp.proceed();
		
		Object result = jp.proceed();
		String name = user.getName();
		
		if (name == null) {
			result = "redirect:/canon/logout";
		}

		return result;
		
//		System.out.println("----------------------------");
//		System.out.println("呼び出されました。");
//		System.out.println("対象：" + jp.getSignature());
//		System.out.println("結果：" + result);
//		System.out.println("----------------------------");
//		System.out.println();
	}

	
//	@Before("execution(* com.example.demo.chap06.CanonController.*(..))")
//	public void check01(JoinPoint jp) {
//		//アドバイスを記述
//		System.out.println("----------------------------");
//		System.out.println("事前に呼び出されました。");
//		System.out.println("対象：" + jp.getSignature());
//		System.out.println("----------------------------");
//		System.out.println();
//	}
//	
//	@After("execution(* com.example.demo.chap06.CanonController.*(..))")
//	public void check02(JoinPoint jp) {
//		//アドバイスを記述
//		System.out.println("----------------------------");
//		System.out.println("事後に呼び出されました。");
//		System.out.println("対象：" + jp.getSignature());
//		System.out.println("----------------------------");
//		System.out.println();
//	}
//	
//	@AfterReturning("execution(* com.example.demo.chap06.CanonController.*(..))")
//	public void check03(JoinPoint jp) {
//		//アドバイスを記述
//		System.out.println("----------------------------");
//		System.out.println("正常時に呼び出されました。");
//		System.out.println("対象：" + jp.getSignature());
//		System.out.println("----------------------------");
//		System.out.println();
//	}
//	
//	@AfterThrowing(
//			value="execution(* com.example.demo.chap06.CanonController.*(..))",
//			throwing="e"
//	)
//	public void check04(JoinPoint jp, Exception e) {
//		//アドバイスを記述
//		System.out.println("----------------------------");
//		System.out.println("異常時に呼び出されました。");
//		System.out.println("対象：" + jp.getSignature());
//		System.out.println("エラー：" + e.getMessage());
//		System.out.println("----------------------------");
//		System.out.println();
//	}
}
