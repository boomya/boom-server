package com.lesdo.standalone;

import com.lesdo.standalone.server.WebServer;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.webapp.WebAppContext;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by jiangshan on 15/3/23.
 */
public class Launched {
    private static Server server;
    private static ServerConnector connector;
    private static WebAppContext webContext;

    /**
     * 创建用于开发运行调试的Jetty Server, 以src/main/webapp为Web应用目录.
     */
    private static Server createServerInSource(int port, String contextPath, String webappRootPath, String webappPath) {

        server = new Server(9999);

        // 设置在JVM退出时关闭Jetty的钩子。
        server.setStopAtShutdown(true);

        //这是http的连接器
        connector = (ServerConnector) server.getConnectors()[0];
//        connector = new ServerConnector(server);
//        connector.setPort(9999);
//        connector.setStopTimeout(1000L);
//        // 解决Windows下重复启动Jetty居然不报告端口冲突的问题.
//        connector.setReuseAddress(false);
//        server.setConnectors(new Connector[] { connector });
        webContext = new WebAppContext(webappRootPath, contextPath);
        //webContext.setContextPath("/");
//        webContext.setDescriptor("/Users/jiangshan/develop/workspace/sxyx-web-sample/src/main/webapp/WEB-INF/web.xml");
        webContext.setDescriptor(webappPath);
        // 设置webapp的位置
        webContext.setResourceBase(webappRootPath);
        webContext.setClassLoader(Thread.currentThread().getContextClassLoader());
        server.setHandler(webContext);
        return server;
    }



    /**
     * 启动jetty服务
     */
    public static void startJetty(int port, String contextPath, String webappRootPath, String webappPath) {
        server = WebServer.createServerInSource(port, contextPath, webappRootPath, webappPath);

        try {
            server.stop();
            server.start();
            server.join();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

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

        startJetty(port, context, webappRootPath, webappPath);
    }
}
