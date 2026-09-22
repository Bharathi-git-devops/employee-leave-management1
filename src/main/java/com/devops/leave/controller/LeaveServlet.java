package com.devops.leave.controller;

import com.devops.leave.model.LeaveRequest;
import com.devops.leave.service.LeaveService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/apply-leave")
public class LeaveServlet extends HttpServlet {

    private final LeaveService leaveService = new LeaveService();

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        response.getWriter().println("""
                <html>
                <head>
                    <title>Employee Leave Management</title>
                </head>
                <body>
                    <h1>Employee Leave Management</h1>

                    <h2>Apply Leave</h2>

                    <form method="post">

                        Employee ID:
                        <input type="number"
                               name="employeeId"
                               required>
                        <br><br>

                        Leave Type:
                        <select name="leaveType">
                            <option value="CASUAL">Casual</option>
                            <option value="SICK">Sick</option>
                            <option value="ANNUAL">Annual</option>
                        </select>

                        <br><br>

                        Number of Days:
                        <input type="number"
                               name="days"
                               min="1"
                               required>

                        <br><br>

                        <button type="submit">
                            Apply Leave
                        </button>

                    </form>
                </body>
                </html>
                """);
    }

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int employeeId =
                Integer.parseInt(request.getParameter("employeeId"));

        String leaveType =
                request.getParameter("leaveType");

        int days =
                Integer.parseInt(request.getParameter("days"));

        LeaveRequest leaveRequest =
                new LeaveRequest(employeeId, leaveType, days);

        boolean approved =
                leaveService.applyLeave(leaveRequest);

        response.setContentType("text/html");

        if (approved) {

            response.getWriter().println("""
                    <html>
                    <body>
                        <h1>Leave Application</h1>
                        <p>Leave request approved successfully.</p>
                        <a href="apply-leave">
                            Apply another leave
                        </a>
                    </body>
                    </html>
                    """);

        } else {

            response.getWriter().println("""
                    <html>
                    <body>
                        <h1>Leave Application</h1>
                        <p>Leave request rejected.</p>
                        <p>Leave must be between 1 and 10 days.</p>
                        <a href="apply-leave">
                            Try again
                        </a>
                    </body>
                    </html>
                    """);
        }
    }
}
