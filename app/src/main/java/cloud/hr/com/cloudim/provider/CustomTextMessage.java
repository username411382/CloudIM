package cloud.hr.com.cloudim.provider;

import io.rong.imkit.model.ProviderTag;
import io.rong.imkit.widget.provider.TextMessageItemProvider;
import io.rong.message.TextMessage;

/**
 * Created by herui on 9/22/2015.
 */
@ProviderTag(messageContent = TextMessage.class,showPortrait = true,showSummaryWithName=true)
public class CustomTextMessage extends TextMessageItemProvider{
}
