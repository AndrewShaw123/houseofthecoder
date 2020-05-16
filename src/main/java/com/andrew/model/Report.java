package com.andrew.model;

import java.io.Serializable;

/**
 * Class
 *
 * @author andrew
 * @date 2020/1/7
 */
public class Report implements Serializable {

    private Integer reportId;
    private Integer whoReportId;
    private Integer beReportId;
    private String reason;

    public Report(){

    }

    public Report(Integer reportId, Integer whoReportId, Integer beReportId, String reason) {
        this.reportId = reportId;
        this.whoReportId = whoReportId;
        this.beReportId = beReportId;
        this.reason = reason;
    }

    public Integer getReportId() {
        return reportId;
    }

    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }

    public Integer getWhoReportId() {
        return whoReportId;
    }

    public void setWhoReportId(Integer whoReportId) {
        this.whoReportId = whoReportId;
    }

    public Integer getBeReportId() {
        return beReportId;
    }

    public void setBeReportId(Integer beReportId) {
        this.beReportId = beReportId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "Report{" +
                "reportId=" + reportId +
                ", whoReportId=" + whoReportId +
                ", beReportId=" + beReportId +
                ", reason='" + reason + '\'' +
                '}';
    }
}
