package com.torryharris.DAO;

import com.torryharris.api.Passenger;
import com.torryharris.api.Train;

import java.sql.SQLException;
import java.util.List;

public interface TrainDAO {
    public List<Train> loadTrains();
    public List<Train> loadTrains(int trainNo);
    public Train getTrain(List<Train> trainList);

    }

