package cn.lee.study.Jnapitoproject;


import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
@EnableScheduling
public class JnapitojectApplication {

	public static void main(String[] args) {
		// 设置Banner开启状态
		// LOG代表开启
		// OFF代表关闭
		SpringApplication app=new SpringApplication(JnapitojectApplication.class);
		app.setBannerMode(Banner.Mode.CONSOLE);
		app.setBannerMode(Banner.Mode.LOG);
		app.run( args);
	}

	/**
	 *  解决通过 new Date()获取时间不一致问题，解决发送审批时间早8八个小时问题
	 * @PostConstruct 是java的注解，被用来修饰一个非静态非静态的void()方法，
	 *                是一种JSR-250的规范，当bean创建完成的时候，会后置执行@PostConstruct修
	饰的方法
	 *  spring中@PostConstruct 在Bean初始化中的执行顺序
	 *                Constructor(构造方法) -> @Autowired(依赖注入) -> @PostConstruct(注释
	的方法)
	 */
	@PostConstruct
	void started() {
		TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
	}
}
