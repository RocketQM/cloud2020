package com.henu.springcloud.entity;

/**
 * @author JinK
 * @date 2020/6/19
 */

/**
 * payment
 */
public class Payment {
    /**
     * id
     */
    private Integer id;

    /**
     * serial
     */
    private String serial;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }
}