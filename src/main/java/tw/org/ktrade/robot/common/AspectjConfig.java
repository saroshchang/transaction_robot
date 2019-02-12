package tw.org.ktrade.robot.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import tw.org.ktrade.robot.exception.ETCException;

@Component
@Aspect
public class AspectjConfig {

	private static final Logger log = LoggerFactory.getLogger(AspectjConfig.class);

	/**
	 * controller層異常處理切面
	 */
	@Around("execution(* tw.org.ktrade.robot.controller..*.*(..)) ")
	// 排除圖片訪問的接口和k線接口 用法如下
	// and !bean(uploadPicController) and !bean(tradingViewDataController)
	public Object controllerError(ProceedingJoinPoint jp) throws Throwable {
		//log.info("jp.getArgs() = > " + jp.getArgs());
		ResponseResult response = new ResponseResult();
		try {
			Object data = jp.proceed();
			response.setData(data);
			return response;
		} catch (ETCException e) { // 獲取自定義異常
			response.setStatus(0);
			response.setErrorCode(e.getErrorCode());
			log.info("【" + String.valueOf(e.getErrorCode()) + "】");
		} catch (Throwable e) { // 其他異常都返回系統異常
			response.setStatus(0);
			log.error("system error ", e);
			response.setErrorCode(4332);
			response.setResponseErrorMsg(e.toString());
		}
		return response;
	}

}
