package com.egfbank.base;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @descritpion
 * @author lijunshi
 * @date 2018年7月9日
 */
@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(locations={"classpath*:/config/spring-context.xml"} )
public class BaseTest {

}
