package com.jdbc;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.sql.*;

public class CompanyDataJDBC {

    Connection connection = null;

    @Parameters({"getCall_jdbc"})
    @Test
    public void getCall_CompanyData(String jdbcURL){

        Response response = RestAssured.get(jdbcURL);

        int statuscode = response.getStatusCode();
        String responseBody = response.getBody().asPrettyString();

        System.out.println(statuscode);
        System.out.println(responseBody);

    }

    @Test
    public void jdbcConnectionCreateDatabase(){

        try{

            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306","root","Akshu@8147");
            if (connection != null){
                System.out.println("Database server is connected");
            }

            Statement statement = connection.createStatement();
            statement.execute("create database companyData");
            System.out.println("Database created successfully");

        }catch (Exception e){
            System.out.println(e);
        }

    }

    @Test
    public void jdbcConnectionCreateTable() {
        try {
            //add the url, userid and password
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306", "root", "Akshu@8147");
            if (connection != null) {
                System.out.println("Database server is connected");
            }
            Statement statement = connection.createStatement();
            statement.execute("use companyData");
            statement.execute("CREATE TABLE Companies_data (\n" +
                    "    id INT,\n" +
                    "    name VARCHAR(255),\n" +
                    "    address VARCHAR(255),\n" +
                    "    zip VARCHAR(10),\n" +
                    "    country VARCHAR(100),\n" +
                    "    employeeCount INT,\n" +
                    "    industry VARCHAR(100),\n" +
                    "    marketCap BIGINT,\n" +
                    "    domain VARCHAR(255),\n" +
                    "    logo VARCHAR(255),\n" +
                    "    ceoName VARCHAR(255)\n" +
                    ");");


        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
