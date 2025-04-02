package com.Aimer.cli.command;

import cn.hutool.core.util.ReflectUtil;
import com.Aimer.model.MainTemplateConfig;
import picocli.CommandLine;

import java.lang.reflect.Field;

@CommandLine.Command(name = "config" ,mixinStandardHelpOptions = true)
public class ConfigCommand implements Runnable{

    public void run() {
        System.out.println("查看参数信息");

        Field[] fields = ReflectUtil.getFields(MainTemplateConfig.class);
        for (Field field : fields) {
            System.out.println("字段类型:"+field.getType());
            System.out.println("字段名称:"+field.getName());
        }
    }
}
