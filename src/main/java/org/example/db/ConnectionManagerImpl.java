package org.example.db;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionManagerImpl implements ConnectionManager {

    @Override
    public Connection getConnection() throws SQLException {
        return DataSource.ds.getConnection();
    }
}
