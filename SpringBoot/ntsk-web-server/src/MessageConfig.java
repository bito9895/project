import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

/**
 * メッセージ取得クラス
 */
@Component
public class MessageConfig {

    /**
     * メッセージリソース.
     */
    private static MessageSource msg;
    /**
     * メッセージリソースを設定する.
     * @param refMsg メッセージリソース
     */
    @Autowired
    public void setMsg(MessageSource refMsg) {
        msg = refMsg;
    }

    /**
     * メッセージを取得する.
     * @param msgId メッセージID
     */
    public static String getMsg(String msgId) {
        return getMsg(msgId, null);
    }
    /**
     * メッセージを取得する.
     * @param msgId メッセージID
     * @param msgArgs メッセージ引数
     */
    public static String getMsg(String msgId, String[] msgArgs) {
        return msg.getMessage(msgId, msgArgs, Locale.getDefault());
    }



}
