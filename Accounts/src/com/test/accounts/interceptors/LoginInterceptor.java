package com.test.accounts.interceptors;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.test.accounts.LoginAction;


public class LoginInterceptor extends AbstractInterceptor {
	private static final long serialVersionUID = 3875962846607742004L;

	@Override
    public String intercept(final ActionInvocation invocation) throws Exception {
		
		final ActionContext context = invocation.getInvocationContext();        
	    HttpServletRequest request = (HttpServletRequest)context.get(StrutsStatics.HTTP_REQUEST);

	    String url = request.getRequestURL().toString();
		System.out.println("Interceptor called : " + url);
        Map<String, Object> session = ActionContext.getContext().getSession();

        String user = (String) session.get("user");

		System.out.println("Interceptor user " + user);

        // sb: if the user is already signed-in, then let the request through.
        if (user != null && !user.isEmpty()) {
    		System.out.println("Interceptor 2");
            return invocation.invoke();
        }

        Object action = invocation.getAction();

        // sb: if the action doesn't require sign-in, then let it through.
        if (action instanceof LoginAction ) {
    		System.out.println("Interceptor 3");
            return invocation.invoke();
        }


		System.out.println("Interceptor 4");
        return "loginRedirect";
    }
}