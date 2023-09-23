package com.example.movie.controller;

import com.example.movie.model.History;
import com.example.movie.service.IHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Component
public class Schedule {
    @Autowired
    private IHistoryService historyService;

    @Scheduled(cron = "0 0/5 * * * *")
    public void checkPacked() throws ParseException {
        List<History> getListHistory = historyService.findAll();
        Calendar calendar = Calendar.getInstance();
        Calendar calendar1 = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        for (History h : getListHistory) {
            if (Objects.nonNull(h.getDayEnd())) {
                calendar1.setTime(sdf.parse(h.getDayEnd()));
                if (calendar.getTime().getTime()-calendar1.getTime().getTime() >= 0&&h.isFlag()) {
                    h.setFlag(false);
                    historyService.saveHistory(h);
                }
            }
        }
    }
}
