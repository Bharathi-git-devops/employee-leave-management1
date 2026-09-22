package com.devops.leave.service;

import com.devops.leave.model.LeaveRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LeaveService {

    private static final Logger logger =
            LoggerFactory.getLogger(LeaveService.class);

    public boolean applyLeave(LeaveRequest request) {

        logger.info(
                "Processing leave request for employee ID: {}",
                request.getEmployeeId()
        );

        if (request.getDays() <= 0) {
            logger.warn("Leave days must be greater than zero");
            return false;
        }

        if (request.getDays() > 10) {
            logger.warn("Leave request exceeds maximum allowed days");
            return false;
        }

        logger.info("Leave request approved");

        return true;
    }
}
