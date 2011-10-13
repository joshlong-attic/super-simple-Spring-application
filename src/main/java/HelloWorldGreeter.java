import org.springframework.beans.factory.InitializingBean;

import java.util.Locale;
import java.util.Map;

/**
 * Simple bean.
 */
public class HelloWorldGreeter implements InitializingBean {

    private Map<String, String> salutations;

    public HelloWorldGreeter(Map<String, String> sals) {
        this.salutations = sals;
    }

    public String greet(Locale lo) {
        String language = lo.getLanguage().toLowerCase();
        for (String k : this.salutations.keySet()) {
            if (language.contains(k)) {
                return (this.salutations.get(k));
            }
        }
        return null;
    }

    public String greet() {
        Locale locale = Locale.getDefault();
        return greet(locale);
    }


    public void afterPropertiesSet() throws Exception {
        Locale[] locales = {new Locale("IT"), new Locale("FR"), new Locale("ES"), new Locale("EN")};
        for (Locale l : locales) {
            System.out.println(l.toString() + " : " + greet(l));
        }
    }
}
