package cloud.hr.com.cloudim.ui;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.yzxtcp.UCSManager;
import com.yzxtcp.data.UcsReason;
import com.yzxtcp.listener.ILoginListener;

import cloud.hr.com.cloudim.App;
import cloud.hr.com.cloudim.R;

//http://www.ucpaas.com/user/account
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }

    private void init() {
        UCSManager.connect("7d92bd282337aee6a7315439df45cc3f", new ILoginListener() {
            @Override
            public void onLogin(UcsReason arg0) {
                if (arg0.getReason() == 0) {   //登入成功
                    Log.d("ruihe","--->成功");
                } else {   //登入失败
                    Log.d("ruihe","--->失败"+arg0.getReason());
                }
            }
        });

    }

}
