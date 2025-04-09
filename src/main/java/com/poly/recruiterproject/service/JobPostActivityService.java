package com.poly.recruiterproject.service;

import com.poly.recruiterproject.controller.JobPostActivityController;
import com.poly.recruiterproject.entity.*;
import com.poly.recruiterproject.repository.IRecruiterJobs;
import com.poly.recruiterproject.repository.JobPostActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

@Service
public class JobPostActivityService {
    private final JobPostActivityController jobPostActivityController;
    private JobPostActivityRepository jobPostActivityRepository;

    @Autowired
    public JobPostActivityService(JobPostActivityRepository jobPostActivityRepository, JobPostActivityController jobPostActivityController) {
        this.jobPostActivityRepository = jobPostActivityRepository;
        this.jobPostActivityController = jobPostActivityController;
    }

    public JobPostActivity addNew(JobPostActivity jobPostActivity) {
        return jobPostActivityRepository.save(jobPostActivity);
    }

    public List<RecuiterJobsDto> getRecruiterJobs(int recruiter) {
        List<IRecruiterJobs> recruiterJobsDtos = jobPostActivityRepository.getRecruiterJobs(recruiter);
        List<RecuiterJobsDto> recuiterJobsDtoList = new ArrayList<>();
        for (IRecruiterJobs recruiterJobs : recruiterJobsDtos) {
            JobLocation jobLocation = new JobLocation(recruiterJobs.getLocationId(), recruiterJobs.getCity(), recruiterJobs.getCountry(), recruiterJobs.getState());
            JobCompany jobCompany = new JobCompany(recruiterJobs.getCompanyId(), recruiterJobs.getCompanyName(), "");

            recuiterJobsDtoList.add(new RecuiterJobsDto(recruiterJobs.getTotalCandidates(), recruiterJobs.getJob_post_id(), recruiterJobs.getJob_title(), jobLocation, jobCompany));
        }
        return recuiterJobsDtoList;
    }

    public JobPostActivity getOne(int id) {
        return jobPostActivityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job not found")
                );
    }

    public List<JobPostActivity> getAll() {
        return jobPostActivityRepository.findAll();
    }


    public List<JobPostActivity> search(String job, String location, List<String> type, List<String> remote, LocalDate searchDate) {
        return Objects.isNull(searchDate) ? jobPostActivityRepository.searchWithoutDate(job, location, remote, type) : jobPostActivityRepository.search(job, location, remote, type, searchDate);
    }


}
