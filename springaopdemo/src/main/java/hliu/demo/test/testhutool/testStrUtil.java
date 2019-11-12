package hliu.demo.test.testhutool;

import cn.hutool.core.lang.Dict;
import cn.hutool.core.util.StrUtil;

public class testStrUtil {
    public static void main(String args[]){
        /**
         * format
         * */
        String str = StrUtil.format("你是个{},{}","kk","ss");
        System.out.println(str);

        String table = "user";
        Object[] values = new Object[1];
        values[0] = 123;

        Dict dict = Dict.create()
                .set("table",table)
                .set("values",values);

        String sql = StrUtil.format("Insert into {table} ({values})",dict);

        System.out.println(sql);

    }
}
