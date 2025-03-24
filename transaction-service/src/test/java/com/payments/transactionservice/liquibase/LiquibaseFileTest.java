package com.payments.transactionservice.liquibase;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LiquibaseFileTest {

    @Test
    void testLiquibaseFileExists() {
        ClassLoader classLoader = getClass().getClassLoader();
        classLoader.getResource("db/changelog/db.changelog-master.yaml");
    }
}
