package tw.org.ktrade.robot.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class CommonInterceptor extends HandlerInterceptorAdapter  {

    private final static  Logger logger = Logger.getLogger(CommonInterceptor.class);
    
    @Override
    public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {
        logger.info("添加跨域訪問頭配置，Access-Control-Allow-Origin:*");
        //跨域訪問CORS
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "POST,GET,OPTIONS,PUT,DELETE,HEAD");
        response.addHeader("Access-Control-Allow-Headers", "S_ID,content-type");
        response.addHeader("Access-Control-Max-Age", "3600000");
        response.addHeader("Access-Control-Allow-Credentials", "true");
        
        //讓請求，不被緩存，
        response.setHeader("Cache-Control", "no-cache");  
        response.setHeader("Cache-Control", "no-store");  
        response.setHeader("Pragma", "no-cache");  
        response.setDateHeader("Expires", 0); 
        
        logger.debug("==================================preHandle");
        return true;
    }
    
    @Override
    public void postHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        logger.debug("==================================postHandle");
    }
    
    
    @Override
    public void afterCompletion(HttpServletRequest request,
            HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        logger.debug("==================================afterCompletion");
    }
}
