package com.syxy.server;

import com.syxy.global.ExecutorServices;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.util.thread.ExecutorThreadPool;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 * Created by jiangshan on 15/3/24.
 */
public class WebServer {

    /**
     * 创建用于开发运行调试的Jetty Server, 以src/main/webapp为Web应用目录.
     */
    public static Server createServerInSource(int port, String contextPath, String webappRootPath, String webappPath) {

        Server server = new Server(new ExecutorThreadPool(ExecutorServices.createExecutorService("WebServer")));
        // 设置在JVM退出时关闭Jetty的钩子。
        server.setStopAtShutdown(false);

        //这是http的连接器
        ServerConnector connector = new ServerConnector(server);
        connector.setAcceptQueueSize(1024);
        connector.setPort(port);
//        // 解决Windows下重复启动Jetty居然不报告端口冲突的问题.
//        connector.setReuseAddress(false);
        server.setConnectors(new Connector[] { connector });

//        // Create a resource handler for static content.
//        ResourceHandler staticResourceHandler = new ResourceHandler();
////        staticResourceHandler.setResourceBase(webappRootPath + "/static");
//        staticResourceHandler.setResourceBase("/lesdo");
//        staticResourceHandler.setDirectoriesListed(false);

//        // Create context handler for static resource handler.
//        ContextHandler staticContextHandler = new ContextHandler();
////        staticContextHandler.setContextPath(webappRootPath + "/static");
//        staticContextHandler.setContextPath("/lesdo");
//        staticContextHandler.setHandler(staticResourceHandler);
//        staticContextHandler.setInitParameter("dirAllowed", "false");

//        WebAppContext webContext = new WebAppContext(webappRootPath, contextPath);
        WebAppContext webContext = new WebAppContext(webappRootPath + "/WEB-INF", contextPath);
        webContext.setInitParameter("org.eclipse.jetty.servlet.Default.dirAllowed", "false");
        webContext.setDescriptor(webappPath);
        // 设置webapp的位置
        webContext.setResourceBase(webappRootPath);
        webContext.setClassLoader(Thread.currentThread().getContextClassLoader());

        // Create a handler list to store our static and servlet context handlers.
        HandlerList handlers = new HandlerList();
//        handlers.setHandlers(new Handler[] { staticContextHandler, webContext });
        handlers.setHandlers(new Handler[] { webContext });

//        server.setHandler(webContext);
//        // Add the handlers to the server and start jetty.
        server.setHandler(handlers);

        return server;
    }
}

