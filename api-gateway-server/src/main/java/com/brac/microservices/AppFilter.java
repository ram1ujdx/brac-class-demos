package com.brac.microservices;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class AppFilter extends ZuulFilter{

	Logger log=LoggerFactory.getLogger(AppFilter.class);
	
	@Override
	public boolean shouldFilter() {
		
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext context=RequestContext.getCurrentContext();
		HttpServletRequest request=context.getRequest();
		
		String header=request.getHeader("username");
		if(header==null) {
			log.error("Header Missing or Invalid Value");
			context.setSendZuulResponse(false);
			context.setResponseStatusCode(400);
			context.setResponseBody("Bad Request");
			return null;
		}
		
		if(!header.equals("ramanuj")) {
			log.error("Header Missing or Invalid Value");
			context.setSendZuulResponse(false);
			context.setResponseStatusCode(401);
			context.setResponseBody("Unauthorized");
			return null;
		}
		
		return null;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre";
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 1;
	}

}
