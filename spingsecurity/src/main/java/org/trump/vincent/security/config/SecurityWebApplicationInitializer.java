package org.trump.vincent.security.config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.web.context.AbstractContextLoaderInitializer;

/**
 * Created by Vincent on 2017/12/14 0014.
 */
public class SecurityWebApplicationInitializer
//            extends AbstractContextLoaderInitializer {
        extends AbstractSecurityWebApplicationInitializer {

        public SecurityWebApplicationInitializer(){
            super(SecurityConfig.class);
        }
}
