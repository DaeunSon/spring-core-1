package cholog;

import cholog.scan.ComponentScanBean;
import cholog.scan.ContextConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.AutoConfigurationExcludeFilter;
import org.springframework.boot.context.TypeExcludeFilter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

import static cholog.utils.ContextUtils.getApplicationContext;
import static org.assertj.core.api.Assertions.assertThat;
@ComponentScan(excludeFilters = { @ComponentScan.Filter(type = FilterType.CUSTOM, classes = TypeExcludeFilter.class),
        @ComponentScan.Filter(type = FilterType.CUSTOM, classes = AutoConfigurationExcludeFilter.class) })
public class ComponentScanTest {

    @Test
    void scanComponent() {
        ApplicationContext context = getApplicationContext(ContextConfiguration.class);
        ComponentScanBean componentScanBean = context.getBean("componentScanBean", ComponentScanBean.class);
        assertThat(componentScanBean).isNotNull();
    }





}
