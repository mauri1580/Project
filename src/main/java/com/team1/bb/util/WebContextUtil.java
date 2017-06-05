package com.team1.bb.util;

import com.team1.bb.core.employee.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * WebContext
 *
 * Will return current principal userId id
 *
 */
@Component
@Scope(value="request", proxyMode= ScopedProxyMode.TARGET_CLASS)
public class WebContextUtil {

	private final Logger logger = LoggerFactory.getLogger(WebContextUtil.class);

	private Optional<String> email = Optional.empty();

	public WebContextUtil(){
		Object principal = SecurityContextHolder.getContext().
				getAuthentication().getPrincipal();

		if (!(principal instanceof String)){
			this.email = Optional.of(((Employee) principal).getEmail());
		}
	}

	public Optional<String> getEmail() {
		return email;
	}

}
