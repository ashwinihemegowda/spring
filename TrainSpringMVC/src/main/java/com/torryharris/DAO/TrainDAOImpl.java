package com.torryharris.DAO;

import com.torryharris.api.Passenger;
import com.torryharris.api.Train;
import com.torryharris.mapper.TrainRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;

import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class TrainDAOImpl implements TrainDAO{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    Train train;
    @Override
    public List<Train> loadTrains() {
        List<Train>trainList=new ArrayList<Train>();
            String sql="select * from trains";
            List<Train>trainList1=jdbcTemplate.query(sql,new TrainRowMapper());
            return trainList1;
        }

    @Override

        public List<Train>loadTrains(int trainNo)
        {
            List<Train>trainList=new ArrayList<Train>();
            String sql="select * from trains where train_no="+trainNo;
            List<Train> trainList1=jdbcTemplate.query(sql,new TrainRowMapper());

            return trainList1;



        }

    @Override
    public Train getTrain(List<Train> trainList) {
        for(Train t:trainList)
        {
            train.setTrainNo(t.getTrainNo());
            train.setTrainName(t.getTrainName());
            train.setSource(t.getSource());
            train.setDestination(t.getDestination());
            train.setTicketPrice(t.getTicketPrice());


        }
        return train;
    }


}


