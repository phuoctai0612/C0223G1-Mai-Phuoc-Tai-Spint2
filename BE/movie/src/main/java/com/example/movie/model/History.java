package com.example.movie.model;

import javax.persistence.*;

@Entity
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dayStart;
    private String dayEnd;
    private boolean flag;
    @ManyToOne
    private Account account;
    @ManyToOne
    private PackedMovie packedMovie;

    public History(Long id, String dayStart, String dayEnd, Account account, PackedMovie packedMovie) {
        this.id = id;
        this.dayStart = dayStart;
        this.dayEnd = dayEnd;
        this.account = account;
        this.packedMovie = packedMovie;
    }

    public History(String dayStart, String dayEnd, Account account, PackedMovie packedMovie) {
        this.dayStart = dayStart;
        this.dayEnd = dayEnd;
        this.account = account;
        this.packedMovie = packedMovie;
    }

    public History( String dayStart, String dayEnd, boolean flag, Account account, PackedMovie packedMovie) {

        this.dayStart = dayStart;
        this.dayEnd = dayEnd;
        this.flag = flag;
        this.account = account;
        this.packedMovie = packedMovie;
    }

    public History() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDayStart() {
        return dayStart;
    }

    public void setDayStart(String dayStart) {
        this.dayStart = dayStart;
    }

    public String getDayEnd() {
        return dayEnd;
    }

    public void setDayEnd(String dayEnd) {
        this.dayEnd = dayEnd;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public PackedMovie getPackedMovie() {
        return packedMovie;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public void setPackedMovie(PackedMovie packedMovie) {
        this.packedMovie = packedMovie;
    }
}

