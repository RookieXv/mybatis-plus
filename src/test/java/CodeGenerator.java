

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Copyright (C), 2016-2019, Mobius-Vision
 * FileName: CodeGeneratorDefault
 * Author: liuwenxu
 * Date: 2019/08/08 11:27
 * Description: mybatis-plus 代码生成
 */
public class CodeGenerator {
    /**
     * 读取控制台内容
     *
     * @param tip
     * @return
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        String projectPath = System.getProperty("user.dir");
        GlobalConfig gc = new GlobalConfig()
                .setOutputDir(projectPath + "/src/main/java")
                .setAuthor("liuwenxu")
                .setOpen(false)
                .setSwagger2(true); // 实体属性 Swagger2 注解

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig()
                .setUrl("jdbc:mysql://localhost:3306/shiro?serverTimezone=UTC&characterEncoding=utf-8&useSSL=false")
                // dsc.setSchemaName("public")
                .setDriverName("com.mysql.cj.jdbc.Driver")
                .setUsername("root")
                .setPassword("admin");

        // 包配置
        PackageConfig pc = new PackageConfig()
                .setModuleName(scanner("模块名"))
                .setParent("com.example");

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        List<FileOutConfig> focList = new ArrayList<>();
        focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return projectPath + "/src/main/resources/mapper/" + pc.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);

        // 配置模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        TemplateConfig templateConfig = new TemplateConfig()
                .setEntity("templates/entity-mine.java")
                .setMapper("templates/mapper-mine.java")
                .setService("templates/service-mine.java")
                .setServiceImpl("templates/serviceImpl-mine.java")
                .setController("templates/controller-mine.java")
                .setXml(null);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig()
                .setNaming(NamingStrategy.underline_to_camel)
                .setColumnNaming(NamingStrategy.underline_to_camel)
                //.setSuperEntityClass("com.baomidou.ant.common.BaseEntity")
                .setEntityLombokModel(true)
                .setRestControllerStyle(true)
                //strategy.setSuperControllerClass("com.baomidou.ant.common.BaseController");
                .setInclude(scanner("表名"))
                //strategy.setSuperEntityColumns("id");
                .setControllerMappingHyphenStyle(true)
                .setTablePrefix("_");

        mpg.setGlobalConfig(gc);
        mpg.setDataSource(dsc);
        mpg.setPackageInfo(pc);
        mpg.setCfg(cfg);
        mpg.setTemplate(new TemplateConfig().setXml(null));
        mpg.setTemplate(templateConfig);
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }
}
