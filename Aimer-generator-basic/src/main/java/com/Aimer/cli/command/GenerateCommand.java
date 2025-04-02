package com.Aimer.cli.command;

import cn.hutool.core.bean.BeanUtil;
import com.Aimer.generator.MainGenerator;
import com.Aimer.model.MainTemplateConfig;
import lombok.Data;
import picocli.CommandLine.Option;
import picocli.CommandLine.Command;

import java.util.concurrent.Callable;
@Data
@Command(name = "generate",mixinStandardHelpOptions = true)
public class GenerateCommand implements Callable<Integer> {

    @Option(names = {"-l" , "--loop"} , arity = "0..1" , description = "是否循环" ,interactive = true ,echo = true)
    private boolean loop;

    @Option(names = {"-a" ,"--author"} ,arity = "0..1" , description = "作者" ,interactive = true ,echo = true)
    private String author;

    @Option(names = {"-o" ,"--outputText"} ,arity = "0..1" ,description = "输入文本" ,interactive = true ,echo = true)
    private String outputText;


    public Integer call() throws Exception {
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        BeanUtil.copyProperties(this,mainTemplateConfig);
        System.out.println("配置信息:" + mainTemplateConfig);
        MainGenerator.doGenerator(mainTemplateConfig);
        return 0;
    }
}
