package push;

import com.xiaomi.xmpush.server.*;
import org.apache.commons.logging.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by long on 2017/5/3.
 */
public class PushManagerInstance {
    private static PushManagerInstance instance;

    private PushManagerInstance() {

    }

    public static PushManagerInstance getInstance() {
        if (instance == null) {
            synchronized (PushManagerInstance.class) {
                if (instance == null) {
                    instance = new PushManagerInstance();
                }
            }
        }
        return instance;
    }

    public Message buildMessage() throws Exception {
        String PACKAGENAME = "com.xiaomaoqiu.pet";
        String messagePayload = "this is a message";
        String title = "notification title";
        String description = "notification description";
        Message message = new Message.Builder()
                .title(title)
                .description(description).payload(messagePayload)
                .restrictedPackageName(PACKAGENAME)
                .passThrough(0)  //1表示透传消息，0表示通知栏消息。
                .notifyType(1)     // 使用默认提示音提示
                .extra("flow_control", "4000")     // 设置平滑推送, 推送速度4000每秒(qps=4000)
                .build();
        return message;
    }

    public List<TargetedMessage> buildTargetedMessage() throws Exception {
        List<TargetedMessage> messages = new ArrayList<TargetedMessage>();

        TargetedMessage message1 = new TargetedMessage();
        message1.setTarget(TargetedMessage.TARGET_TYPE_ALIAS, "1493785488");
        message1.setMessage(buildMessage());
        messages.add(message1);
        return messages;
    }
    public void sendMessage() throws Exception {
        Constants.useOfficial();
        Sender sender = new Sender("aQLLX8h129sPKm3NeY9lcA==");
        Result result=sender.send(buildTargetedMessage(), 0); //根据regID，发送消息到指定设备上，不重试。
        System.out.println(("Server response: "+"MessageId: " + result.getMessageId()
                + " ErrorCode: " + result.getErrorCode().toString()
                + " Reason: " + result.getReason()));


    }
}
