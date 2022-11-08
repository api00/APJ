package com.repository;

import com.TaxCal.TaxCal;
import com.domain.User;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import javax.validation.Valid;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Random;
import com.TaxCal.TaxCal;

@Repository
public class TaxRepository {

    private DataSource dataSource;

    private static final String ALL = "select id, name, created_on from departments";

    private static final String SELECT_ONE = "select name, desig, g_sal, gender from user_details where u_id = ?";

    private static final String CREATE = "insert into user_details (u_id, name, desig, g_sal, gender) values (?, ?, ?, ?, ?)";

    private static final String CREATEBreakdown = "insert into s_breakdown (u_id, b_sal, h_rent, c_allowence, m_allowence, others, total ) values (?, ?, ?, ?, ?, ?, ?)";

    private static final String Tax = "insert into tax_cal (u_id, b_sal, h_rent, c_allowence, m_allowence, others, total ) values (?, ?, ?, ?, ?, ?, ?)";

    public TaxRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    int min = 50;
    int max = 1000;
    int id = (int)Math.floor(Math.random()*(max-min+1)+min);
/*    public List<Department> list() throws SQLException {
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(ALL);
        return mapper(resultSet);
    }*/
/*
    public User taxLiability() throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ONE);
        ResultSet resultSet = preparedStatement.executeQuery();
        User department = new User();
        while (resultSet.next()) {

            department.setName(resultSet.getString(2));
        }
        return department;
    }*/

 /*   public int taxLiability() throws SQLException {
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from taxliability");

        while(resultSet.next()) {
            System.out.println(resultSet.getLong(1));
            System.out.println(resultSet.getString(2));
            System.out.println(resultSet.getString(3));


        }
        return  resultSet.getInt(2);
    }*/


    public boolean create(@Valid User user) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(CREATE);

        preparedStatement.setInt(1,id);
        preparedStatement.setString(2, user.getName());
        preparedStatement.setString(3,user.getDesignation());
        preparedStatement.setInt(4,user.getGSal());
        preparedStatement.setString(5,user.getGender());
        return preparedStatement.execute();
    }
    public boolean createBreakdown(@Valid User user) throws SQLException {

        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(CREATEBreakdown);

        int total = user.getBSal() + user.getCAllowance() + user.getH_rent() + user.getMAllowance() + user.getOthers();

        preparedStatement.setInt(1,id);
        preparedStatement.setInt(2, user.getBSal());
        preparedStatement.setInt(3,user.getH_rent());
        preparedStatement.setInt(4,user.getCAllowance());
        preparedStatement.setInt(5,user.getMAllowance());
        preparedStatement.setInt(6,user.getOthers());
        preparedStatement.setInt(7,total);


        return preparedStatement.execute();
    }

    public boolean TaxCalculation(@Valid User user) throws SQLException {
        ;
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(Tax);
        TaxCal taxCal = new TaxCal();

        int Bsal = taxCal.BasicSal(user);
        int HRent = taxCal.HouseRent(user);
        int ConveyCAllownce = taxCal.ConveyCAllownce(user);
        int MedicalAllownce =taxCal.MedicalAllownce(user);
        int others = taxCal.other(user);
        int total = taxCal.Total(user);



        preparedStatement.setInt(1,id);
        preparedStatement.setInt(2,Bsal);
        preparedStatement.setInt(3,HRent);
        preparedStatement.setInt(4,ConveyCAllownce);
        preparedStatement.setInt(5,MedicalAllownce);
        preparedStatement.setInt(6,others);
        preparedStatement.setInt(7,total);


        return preparedStatement.execute();
    }

    public User get() throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ONE);
        preparedStatement.setInt(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<User> departments = new ArrayList<>();
        User user = new User();
        while (resultSet.next()) {
            user.setName(resultSet.getString(1));
            user.setDesignation(resultSet.getString(2));
            user.setGSal(resultSet.getInt(3));
            user.setGender(resultSet.getString(4));
            departments.add(user);


        }
        return user;
    }


    /*public boolean update(Department department) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
        preparedStatement.setString(1, department.getName());
        preparedStatement.setLong(2, department.getId());
        return preparedStatement.execute();
    }
*/
  /*  public boolean delete(Long id) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
        preparedStatement.setLong(1, id);
        return preparedStatement.execute();
    }*/

/*    private List<Department> mapper(ResultSet resultSet) throws SQLException {
        List<Department> departments = new ArrayList<>();
        while(resultSet.next()) {
            Department department = new Department();
            department.setId(resultSet.getLong(1));
            department.setName(resultSet.getString(2));
            departments.add(department);
        }
        return departments;
    }*/
}
