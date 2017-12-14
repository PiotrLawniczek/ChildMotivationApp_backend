package pl.lodz.childmotivationapp.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by elawpio on 2017-12-11.
 */
public class Spring4Initializer extends AbstractAnnotationConfigDispatcherServletInitializer{

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {Spring4Configuration.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return  null;
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }
}
