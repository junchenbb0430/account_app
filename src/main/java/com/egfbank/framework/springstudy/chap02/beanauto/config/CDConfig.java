package com.egfbank.framework.springstudy.chap02.beanauto.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.egfbank.framework.springstudy.chap02.beanauto.CompactDisc;
@Configuration
//@ComponentScan(basePackages={"com.egfbank.framework"})
@ComponentScan(basePackageClasses={CompactDisc.class})
public class CDConfig {
 /**
  * 类CDConfig通过java 代码定义了Srping 装配规则
  * @ComponentScan 如同配置文件中一样。
  * 属性basePackagess={"",""}支持数组模式，即多个基础包
  * 如下两种方式都可以
  * @ComponentScan(basePackages="com.egfbank.framework"),推荐使用
  * @ComponentScan(basePackageClasses={CompactDisc.class}),
  */
}
