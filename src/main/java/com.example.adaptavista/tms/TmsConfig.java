package com.example.adaptavista.tms;

import lombok.Data;

@Data
public class TmsConfig {

    private String rootUrl;
    private String user;
    private String pass;

    public static TmsConfig fromEnv() {
        var cfg = new TmsConfig();

        cfg.setRootUrl(getEnvOrDie("TMS_ROOT_URL"));
        cfg.setUser(getEnvOrDie("TMS_USER"));
        cfg.setPass(getEnvOrDie("TMS_PASS"));
        return cfg;
    }

    private static String getEnvOrDie(String envName) {
        var value = System.getenv(envName);
        if (null == value) {
            throw new IllegalStateException(envName + " environment variuable must be defined");
        }
        return value;
    }

}
