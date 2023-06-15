package com.pawm.project.rasp1Project40.repository;

import  com.pawm.project.rasp1Project40.model.raspModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface raspRepo extends CrudRepository<raspModel, Integer> {

    @Query("SELECT h from raspModel h where h.id_temp_humi_press=17+?1")
    List<raspModel> findLastMeasure(int var);

    @Query("SELECT h from raspModel h where h.temp<10 OR h.temp>35 OR h.humi>99 OR h.humi<20")
    List<raspModel> findAlerts();

    @Query("SELECT h from raspModel h where h.press>0")
    List<raspModel> fetchAll();

}
