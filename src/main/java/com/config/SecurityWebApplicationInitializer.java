package com.config;

import org.springframework.core.annotation.Order;
import org.springframework.security.web.context.*;


@Order(2)
public class SecurityWebApplicationInitializer
    extends AbstractSecurityWebApplicationInitializer {
}