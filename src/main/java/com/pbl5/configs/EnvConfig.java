package com.pbl5.configs;

import io.github.cdimascio.dotenv.Dotenv;

public class EnvConfig {
    public static Dotenv load() {
        return Dotenv.configure().directory("C:\\Users\\minhd\\OneDrive\\Desktop\\PBL5\\test\\pbl5\\assets").filename("env").load();
    }
}
