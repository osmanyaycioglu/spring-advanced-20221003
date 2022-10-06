package com.training.spring.advanced.encrypt;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
@EnableEncryptableProperties
public class EncryptDecryptServ {

    @Bean
    public StringEncryptor jasyptStringEncryptor() {
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword("SpringTrainingInnova20221003");
        config.setAlgorithm("PBEWITHHMACSHA512ANDAES_256");
        config.setKeyObtentionIterations("1000");
        config.setPoolSize("1");
        config.setProviderName("SunJCE");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setIvGeneratorClassName("org.jasypt.iv.RandomIvGenerator");
        config.setStringOutputType("base64");
        encryptor.setConfig(config);
        return encryptor;
    }

    public static void main(String[] args) {
        EncryptDecryptServ encryptDecryptServ = new EncryptDecryptServ();
        StringEncryptor stringEncryptor = encryptDecryptServ.jasyptStringEncryptor();
        try (Scanner scanner = new Scanner(System.in)) {
            String password = "";
            while (!"quit".equals(password)) {
                System.out.println("password giriniz : ");
                password = scanner.nextLine();
                System.out.println(stringEncryptor.encrypt("Given : " + password + "--> " + password));
            }
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }
}
