package com.webapi;

import cn.hutool.core.util.StrUtil;
import com.webapi.common.utils.LogUtil;
import io.github.cdimascio.dotenv.Dotenv;
import io.github.cdimascio.dotenv.DotenvException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;
import java.util.ResourceBundle;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        // 加载自定义jvm参数
        loadConfiguration();
        // 启动项目
        SpringApplication.run(App.class, args);
    }

    private static void loadConfiguration() {
        try {
            // 加载相应的.env文件
            var envName = System.getProperty("spring.profiles.active", "dev");
            var filepath = System.getProperty("env.filepath");
            if (StrUtil.isBlank(filepath)){
                filepath = System.getProperty("user.dir");
            }
            // 获取当前系统属性
            var currentEnv = System.getenv();
            var dotenv = Dotenv.configure()
                    .directory(filepath)
                    .filename(".env."+envName)
                    .load();
            dotenv.entries().forEach(entry -> {
                if (!currentEnv.containsKey(entry.getKey())) {
                    System.setProperty(entry.getKey(), entry.getValue());
                }
            });
        } catch (DotenvException e) {
            var errorMessage = e.getMessage();
            var locale = Locale.getDefault();
            if (errorMessage.contains("Could not find")) {
                var bundle = ResourceBundle.getBundle("i18n/warnings", locale);
                LogUtil.warn(bundle.getString("useDefaultAppConfig"));
            } else if (errorMessage.contains("Malformed entry")){
                var bundle = ResourceBundle.getBundle("i18n/errors", locale);
                var param = errorMessage.substring(errorMessage.indexOf('y')+2);
                LogUtil.warn(bundle.getString("appConfigMalformed"), param);
                throw e;
            } else {
                throw e;
            }
        }
    }
}
