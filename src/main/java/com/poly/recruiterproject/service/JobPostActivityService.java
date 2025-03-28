package com.poly.recruiterproject.service;

import com.poly.recruiterproject.entity.IRecruiterJobs;
import com.poly.recruiterproject.entity.JobCompany;
import com.poly.recruiterproject.entity.JobLocation;
import com.poly.recruiterproject.entity.JobPostActivity;
import com.poly.recruiterproject.repository.JobPostActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobPostActivityService {
    private JobPostActivityRepository jobPostActivityRepository;

    @Autowired
    public JobPostActivityService(JobPostActivityRepository jobPostActivityRepository) {
        this.jobPostActivityRepository = jobPostActivityRepository;
    }

    public JobPostActivity addNew(JobPostActivity jobPostActivity) {
        return jobPostActivityRepository.save(jobPostActivity);
    }

    public List<RecuiterJobsDto> getRecruiterJobs(int recruiter) {
        List<IRecruiterJobs> recruiterJobsDtos = jobPostActivityRepository.getRecruiterJobs(recruiter);
        List<RecuiterJobsDto> recuiterJobsDtoList = new ArrayList<>();
        for (IRecruiterJobs recruiterJobs : recruiterJobsDtos) {
            JobLocation jobLocation = new JobLocation(recruiterJobs.getLocationId(), recruiterJobs.getCity(), recruiterJobs.getState(), recruiterJobs.getCountry());
            JobCompany jobCompany = new JobCompany(recruiterJobs.getCompanyId(), recruiterJobs.getCompanyName(), "");
            recuiterJobsDtoList.add(new RecuiterJobsDto(recruiterJobs.getTotalCandidates(), recruiterJobs.getJob_post_id(), recruiterJobs.getJob_title(), jobLocation, jobCompany));
        }
        return recuiterJobsDtoList;
    }

}
