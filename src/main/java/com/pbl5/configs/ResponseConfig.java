package com.pbl5.configs;

import javax.servlet.http.HttpServletResponse;

public class ResponseConfig {
    private static String urlFE = "127.0.0.1";
    public static void ConfigHeader(HttpServletResponse res) {

        res.addHeader("Access-Control-Allow-Origin", urlFE);
        res.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS, PUT,PATCH, DELETE, HEAD");
        res.addHeader("Access-Control-Allow-Headers", "X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept, x-api-key, Accept-Encoding, Accept-Language, Authorization,ACCESS_TOKEN,client_id");
        res.addHeader("Access-Control-Request-Headers", "X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept, x-api-key, Accept-Encoding, Accept-Language, Authorization,ACCESS_TOKEN,client_id");
        res.setHeader("Access-Control-Max-Age", "3600");
        res.setHeader("Access-Control-Allow-Credentials", "true");
        res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");
    }
}
