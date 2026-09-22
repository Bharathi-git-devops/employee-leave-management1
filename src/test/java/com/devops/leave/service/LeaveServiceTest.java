package com.devops.leave.service;

import com.devops.leave.model.LeaveRequest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeaveServiceTest {

    @Test
    void shouldApproveValidLeaveRequest() {

        LeaveService service = new LeaveService();

        LeaveRequest request =
                new LeaveRequest(101, "CASUAL", 2);

        boolean result = service.applyLeave(request);

        assertTrue(result);
    }

    @Test
    void shouldRejectZeroDaysLeaveRequest() {

        LeaveService service = new LeaveService();

        LeaveRequest request =
                new LeaveRequest(101, "CASUAL", 0);

        boolean result = service.applyLeave(request);

        assertFalse(result);
    }

    @Test
    void shouldRejectLeaveMoreThanTenDays() {

        LeaveService service = new LeaveService();

        LeaveRequest request =
                new LeaveRequest(101, "CASUAL", 11);

        boolean result = service.applyLeave(request);

        assertFalse(result);
    }
}
