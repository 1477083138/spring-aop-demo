package hliu.demo.test.test1.bean;

import lombok.Getter;

@Getter
public enum LbStatus{

    /**
     * 正常
     * */
    normal(0),
    /**
     * 不可用
     * */
    unavailable(1);

    private Integer code;

    LbStatus(Integer code){
        this.code = code;
    }

}
