package sachin.comp.utils;
import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
public class CommonUtil {

    public static String generateUniqueId(String prefix ) {
        Snowflake snowflake = IdUtil.getSnowflake(1, 1);
        return prefix+String.valueOf(snowflake.nextId());

    }

}
