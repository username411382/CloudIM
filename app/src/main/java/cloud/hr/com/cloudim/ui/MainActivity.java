package cloud.hr.com.cloudim.ui;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import cloud.hr.com.cloudim.R;
import io.rong.imkit.RongIM;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.UserInfo;

//http://www.ucpaas.com/user/account
public class MainActivity extends Activity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {

        String token="aRNNrF0A/ZF5BkZ50WQ66aP054cEtMMKEIFFt5jE+nPr6qxPTdYck2pnaNIlqhsggjI++TCBKmw=";
        RongIM.connect(token, new RongIMClient.ConnectCallback() {
            @Override
            public void onTokenIncorrect() {
                Log.d("ruihe","----->");
            }

            @Override
            public void onSuccess(String s) {
                Log.d("ruihe","服务器连接成功----->"+s);
            }

            @Override
            public void onError(RongIMClient.ErrorCode errorCode) {
                Log.d("ruihe","服务器连接失败----->"+errorCode);

            }
        });

        /**
         * 设置用户信息的提供者，供 RongIM 调用获取用户名称和头像信息。
         *
         * @param userInfoProvider 用户信息提供者。
         * @param isCacheUserInfo  设置是否由 IMKit 来缓存用户信息。<br>
         *                         如果 App 提供的 UserInfoProvider。
         *                         每次都需要通过网络请求用户数据，而不是将用户数据缓存到本地内存，会影响用户信息的加载速度；<br>
         *                         此时最好将本参数设置为 true，由 IMKit 将用户信息缓存到本地内存中。
         * @see UserInfoProvider
         */
        RongIM.setUserInfoProvider(new RongIM.UserInfoProvider() {

            @Override
            public UserInfo getUserInfo(String userId) {

                return findUserById("321");//根据 userId 去你的用户系统里查询对应的用户信息返回给融云 SDK。
            }

        }, true);
        textView=(TextView)findViewById(R.id.test);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * 启动单聊
                 * context - 应用上下文。
                 * targetUserId - 要与之聊天的用户 Id。
                 * title - 聊天的标题，如果传入空值，则默认显示与之聊天的用户名称。
                 */
                if (RongIM.getInstance() != null) {
                    RongIM.getInstance().startPrivateChat(MainActivity.this, "456", "麻蛋");
                }
            }
        });
    }

    private UserInfo findUserById(String userId){
       return new UserInfo(userId,"ruiheheh", Uri.parse("http://img1.imgtn.bdimg.com/it/u=422406803,2584565336&fm=11&gp=0.jpg"));
    }

}
