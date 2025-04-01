package com.Aimer.model;

import lombok.Data;

/**
 * 动态模板配置
 */
@Data
public class MainTemplateConfig {

    /**
     * 作者(字符串，填充值)
     */
    private String author = "Aimer";

    /**
     * 输出信息
     */
    private String outputText = "sum";

    /**
     * 是否循环(开关)
     */
    private boolean loop;
}
