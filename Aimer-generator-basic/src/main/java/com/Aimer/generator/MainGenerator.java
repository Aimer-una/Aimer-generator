package com.Aimer.generator;

import com.Aimer.model.MainTemplateConfig;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

public class MainGenerator {
    public static void main(String[] args) throws TemplateException, IOException {

        //1.静态文件生成
        String propertyPath = System.getProperty("user.dir");
        System.out.println(propertyPath);
        //输入路径
        String inputPath = propertyPath + File.separator + "Aimer-generator-demo-project" + File.separator + "acm-template";
        //输出路径
        String outPath = propertyPath;
        //复制
        StaticGenerator.copyFilesByRecursive(inputPath,outPath);

        //2.动态文件生成
        String dynamicInputPath = propertyPath + File.separator + "Aimer-generator-basic" + File.separator + "src/main/resources/templates/MainTemplate.java.ftl";
        String dynamicOutputPath = propertyPath + File.separator + "acm-template/src/com/yupi/acm/MainTemplate.java";

        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("Aimer");
        mainTemplateConfig.setLoop(true);
        mainTemplateConfig.setOutputText("求和结果：");
        DynamicGenerator.doGenerate(dynamicInputPath, dynamicOutputPath, mainTemplateConfig);

    }
}
