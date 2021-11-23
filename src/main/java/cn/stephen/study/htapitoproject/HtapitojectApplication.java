package cn.stephen.study.htapitoproject;


import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class HtapitojectApplication {

	public static void main(String[] args) {
		// 设置Banner开启状态
		// LOG代表开启
		// OFF代表关闭
		SpringApplication app=new SpringApplication(HtapitojectApplication.class);
		app.setBannerMode(Banner.Mode.CONSOLE);
		app.setBannerMode(Banner.Mode.LOG);
		app.run( args);
	}

}
