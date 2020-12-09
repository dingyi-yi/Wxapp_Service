package com.Wxapp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;


@SpringBootTest
class WxappServiceApplicationTests {

	@Autowired
	DataSource dataSource;

	@Test
	void contextLoads() {
		System.out.println(dataSource.getClass());
		try {
			System.out.println(dataSource.getConnection());
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}

}
