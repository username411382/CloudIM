package cloud.hr.com.cloudim;

import android.app.Application;

import cloud.hr.com.cloudim.provider.CustomTextMessage;
import io.rong.imkit.RongIM;


public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        /**
         * 初始化融云
         */
        RongIM.init(this);
        RongIM.getInstance().registerMessageTemplate(new CustomTextMessage());
    }

}
