package com.poly.recruiterproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "job_post_activity")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JobPostActivity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_post_id") // Giữ tên cột đúng với DB
    private int jobPostId;

    @Column(name = "description_of_job")
    private String descriptionOfJob; // Sửa lỗi chính tả

    @Column(name = "job_title")
    private String jobTitle;

    @Column(name = "job_type")
    private String jobType;

    @Column(name = "posted_date")
    @Temporal(TemporalType.TIMESTAMP) // Định dạng kiểu Date chính xác hơn
    private Date postedDate;

    @Column(name = "remote")
    private Boolean remote; // Chuyển từ String → Boolean

    @Column(name = "salary")
    private double salary;

    @ManyToOne
    @JoinColumn(name = "job_company_id")
    private JobCompany jobCompany;

    @ManyToOne
    @JoinColumn(name = "job_location_id")
    private JobLocation jobLocation;

    @ManyToOne
    @JoinColumn(name = "posted_by_id")
    private User postedBy; // Đổi tên biến để tránh hiểu nhầm
}
