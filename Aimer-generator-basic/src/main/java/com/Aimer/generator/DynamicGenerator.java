package com.Aimer.generator;

import com.Aimer.model.MainTemplateConfig;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class DynamicGenerator {
    public static void main(String[] args) throws IOException, TemplateException {
        String projectPath = System.getProperty("user.dir");  // + File.separator + "Aimer-generator-basic";
        System.out.println("projectPath:" + projectPath);
        String inputPath = projectPath + File.separator + "src/main/resources/templates/MainTemplate.java.ftl";
        System.out.println("inputPut:" + inputPath);
        String outputPath = projectPath + File.separator + "MainTemplate.java";
        System.out.println("outputPath:" + outputPath);
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("Aimer2");
        mainTemplateConfig.setLoop(false);
        mainTemplateConfig.setOutputText("求和结果：");
        doGenerate(inputPath, outputPath, mainTemplateConfig);
    }


    /**
     * 生成文件
     * @param inputPath 模板文件输入路径
     * @param outputPath 输出路径
     * @param model 数据模型
     * @throws IOException
     * @throws TemplateException
     */
    public static void doGenerate(String inputPath, String outputPath, Object model) throws IOException, TemplateException {
        // new 出 Configuration 对象，参数为 FreeMarker 版本号
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);

        // 指定模板文件所在的路径
        File templateDir = new File(inputPath).getParentFile();
        System.out.println("templateDir:" + templateDir);
        configuration.setDirectoryForTemplateLoading(templateDir);

        // 设置模板文件使用的字符集
        configuration.setDefaultEncoding("utf-8");

        configuration.setNumberFormat("0.######");

        // 获取文件名
        String templateName = new File(inputPath).getName();
        System.out.println("templateName" + templateName);

        // 创建模板对象加载指定模板
        Template template = configuration.getTemplate(templateName);

        // 指定生成文件的路径和名称
        Writer out = new FileWriter(outputPath);

        template.process(model, out);

        // 生成文件后别忘了关闭哦
        out.close();
    }
}
