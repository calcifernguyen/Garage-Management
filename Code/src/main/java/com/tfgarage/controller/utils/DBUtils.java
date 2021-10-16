package com.tfgarage.controller.utils;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;

public class DBUtils implements Serializable {
    public static Connection makeConnection() throws NamingException, SQLException {
        Context context = new InitialContext();
        Context tomcatCtx = (Context) context.lookup("java:comp/env");
        DataSource ds = (DataSource) tomcatCtx.lookup("garagemanagementdb");
        if (ds != null) {
            Connection con = ds.getConnection();
            return con;
        }

        return null;
    }
}
