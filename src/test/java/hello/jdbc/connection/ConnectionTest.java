package hello.jdbc.connection;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static hello.jdbc.connection.ConnectionConst.*;

@Slf4j
public class ConnectionTest {

    @Test
    void  driverManager() throws SQLException {

        Connection connection1 = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        Connection connection2 = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        log.info("connection={}","class={}", connection1, connection1.getClass() );
        log.info("connection={}","class={}", connection2, connection2.getClass() );
    }

    @Test
    void dataSourceDriverManager() throws SQLException {
        //DriverManagerDataSource - 항상 새로운 커넥션을 획득

        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource(URL, USERNAME, PASSWORD);
        useDataSource(driverManagerDataSource);

    }

    private void useDataSource(DataSource dataSource) throws SQLException {
        Connection connection = dataSource.getConnection();
        Connection connection1 = dataSource.getConnection();

        log.info("connection={}","class={}", connection, connection.getClass() );
        log.info("connection={}","class={}", connection1, connection1.getClass() );
    }
}
