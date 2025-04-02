package com.Aimer.generator;

import com.Aimer.model.MainTemplateConfig;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

public class MainGenerator {
    public static void main(String[] args) throws TemplateException, IOException {
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("Aimer");
        mainTemplateConfig.setLoop(true);
        mainTemplateConfig.setOutputText("求和结果：");
        doGenerator(mainTemplateConfig);
    }

    public static void doGenerator(Object model) throws TemplateException, IOException {
        //1.静态文件生成
        String propertyPath = System.getProperty("user.dir");
        System.out.println("propertyPath:" + propertyPath);

        File parentFile = new File(propertyPath).getParentFile();
        System.out.println("parentFile:" + parentFile);

        //输入路径
        String inputPath = parentFile + File.separator + "Aimer-generator-demo-project" + File.separator + "acm-template";
        //输出路径
        String outPath = propertyPath;
        //复制
        StaticGenerator.copyFilesByRecursive(inputPath,outPath);

        //2.动态文件生成
        String dynamicInputPath = propertyPath + File.separator + "src/main/resources/templates/MainTemplate.java.ftl";
        System.out.println("dynamicInputPath:" + dynamicInputPath);

        String dynamicOutputPath = outPath + File.separator + "acm-template/src/com/yupi/acm/MainTemplate.java";
        System.out.println("dynamicOutputPath:" + dynamicOutputPath);

        DynamicGenerator.doGenerate(dynamicInputPath, dynamicOutputPath, model);
    }
}
