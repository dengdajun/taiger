package support.startup;


import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Repository;

/**
 * Created by wx on 2016-02-16.
 */
@Repository
public class init implements ApplicationListener {




    boolean checked = false;

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {


    }

}
