package aj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

/**
 * The entry point of the Spring Boot application.
 *
 * Use the @PWA annotation make the application installable on phones, tablets
 * and some desktop browsers.
 *
 */

@PWA(name = "Csv upload Demo App", shortName = "Csv")
@SpringBootApplication(scanBasePackageClasses = { })
@Theme("icecream")
public class Application extends SpringBootServletInitializer implements AppShellConfigurator {

	
	private static final long serialVersionUID = 3023573200826555096L;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
