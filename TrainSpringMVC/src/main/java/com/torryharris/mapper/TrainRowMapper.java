package com.torryharris.mapper;

import com.torryharris.api.Train;
import org.springframework.jdbc.core.RowMapper;

import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TrainRowMapper implements RowMapper<Train> {


    @Override
    public Train mapRow(ResultSet resultSet, int i) throws SQLException {
        Train train=new Train();
        train.setTrainNo(resultSet.getInt(1));
        train.setTrainName(resultSet.getString(2));
        train.setSource(resultSet.getString(3));
        train.setDestination(resultSet.getString(4));
        train.setTicketPrice(resultSet.getDouble(5));


        return train;
    }
}
