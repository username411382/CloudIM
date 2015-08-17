package cloud.hr.com.cloudim;

import android.app.Application;
import android.util.Log;

import com.yzxIM.IMManager;
import com.yzxtcp.UCSManager;


public class App extends Application {

    private static App mApp;

    @Override
    public void onCreate() {
        super.onCreate();
        UCSManager.init(this);//初始化核心服务
        IMManager.getInstance(this);//必须要加上
        Log.d("ruihe","---->start");
    }

    public static App getInstance() {
        if (null == mApp) {
            mApp = new App();
        }
        return mApp;
    }


}
