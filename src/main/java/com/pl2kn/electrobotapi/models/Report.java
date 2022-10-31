package com.pl2kn.electrobotapi.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Report entity.
 */
@Entity
@Table(name = "reports")
public class Report {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "latitude")
  private Double latitude;

  @Column(name = "longitude")
  private Double longitude;

  @Column(name = "image_url")
  private String imageUrl;

  @Column(name = "report_timestamp")
  private Long reportTimestamp;

  @Column(name = "resolve_timestamp")
  private Long resolveTimestamp;

  public Report() {
    this.reportTimestamp = System.currentTimeMillis();
  }

  public Long getId() {
    return id;
  }

  public Double getLatitude() {
    return latitude;
  }

  public Double getLongitude() {
    return longitude;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public Long getReportTimestamp() {
    return reportTimestamp;
  }

  public Long getResolveTimestamp() {
    return resolveTimestamp;
  }

  public void setResolveTimestamp(Long resolveTimestamp) {
    this.resolveTimestamp = resolveTimestamp;
  }
}
