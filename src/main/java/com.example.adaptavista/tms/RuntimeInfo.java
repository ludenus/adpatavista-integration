package com.example.adaptavista.tms;

import lombok.extern.slf4j.Slf4j;

import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@Slf4j
public class RuntimeInfo {

    public String getInfo() {
        return getUser() + "@" + getHost() + "~" + getTimestamp();
    }

    private String getUser() {
        var user = "unknown-user";
        try {
            user = System.getProperty("user.name");
        } catch (Exception e) {
            log.warn("failed to resolve username {}", e.getMessage());
        }
        return user;
    }

    private String getHost() {
        var host = "unknown-host";
        try {
            host = InetAddress.getLocalHost().getHostName();
        } catch (Exception e) {
            log.warn("failed to resolve hostname {}", e.getMessage());
        }
        return host;
    }

    private String getTimestamp() {
        var timestamp = "unknown-time";
        try {
            timestamp = iso8601withMilliseconds(new Date());
        } catch (Exception e) {
            log.warn("failed to resolve hostname {}", e.getMessage());
        }
        return timestamp;
    }

    private static String iso8601withMilliseconds(Date date) {
        var sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        return sdf.format(date);
    }
}
