package com.lesdo.standalone;

import com.lesdo.ext.spring.ServerFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by jiangshan on 15/3/23.
 */
public class Launched {

    public static void main(String[] args) {

        String webappRootPath = Launched.class.getClassLoader().getResource(".").getPath();
        System.setProperty("webappRootPath", webappRootPath);

        int port = 8080;
        String context = "/";
        String webappPath = "WEB-INF/web.xml";

        InputStream inputStream = null;
        try {
            inputStream = Launched.class.getClassLoader().getResource("run.properties").openStream();
            Properties properties = new Properties();
            properties.load(inputStream);
            port = Integer.valueOf(properties.getProperty("jetty.port"));
            context = properties.getProperty("jetty.context");

            webappPath = webappRootPath + "WEB-INF/web.xml";
            File file = new File(webappPath);

            if (!file.exists()) {//判断文件目录的存在
                throw new NullPointerException(webappPath + " not exist.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    System.out.println("========close==========");
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        ServerFactory.startJetty(port, context, webappRootPath, webappPath);

    }
}
