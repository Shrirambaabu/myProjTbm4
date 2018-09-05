package com.freshlancers.sws.ui.services;

import com.freshlancers.sws.ui.models.Assignment;
import com.freshlancers.sws.ui.models.CalendarEvents;
import com.freshlancers.sws.ui.models.Events;
import com.freshlancers.sws.ui.models.MarkSheet;
import com.freshlancers.sws.ui.models.Notification;
import com.freshlancers.sws.ui.models.Payment;
import com.freshlancers.sws.ui.models.TimeTable;
import com.prolificinteractive.materialcalendarview.CalendarDay;

import org.joda.time.LocalDate;
import org.joda.time.Period;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ashith VL on 12/4/2017.
 */

public class DataService {
    private static final DataService ourInstance = new DataService();

    private DataService() {
    }

    static DataService getInstance() {
        return ourInstance;
    }

    public static ArrayList<Notification> getNotificationList() {

        ArrayList<Notification> notificationArrayList = new ArrayList<>();

        notificationArrayList.add(new Notification("Assignment", "5m", "Mathematics",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry." +
                        " Lorem Ipsum has been the industry's standard dummy text ever since the 1500s," +
                        " when an unknown printer took a galley of type and scrambled it to make a type specimen book."));

        notificationArrayList.add(new Notification("Assignment", "6m", "MarkSheet",
                "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s"));

        notificationArrayList.add(new Notification("Assignment", "5m", "Payment",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry."));
        notificationArrayList.add(new Notification("Assignment", "6m", "MarkSheet",
                "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s"));

        notificationArrayList.add(new Notification("Assignment", "5m", "Payment",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry."));

        return notificationArrayList;
    }

    public static ArrayList<Events> getEvents() {

        ArrayList<Events> eventsArrayList = new ArrayList<>();

        eventsArrayList.add(new Events("Event Name", "Lorem Ipsum is simply dummy text of the printing and typesetting industry." +
                " Lorem Ipsum has been the industry's standard dummy text ever since the 1500s," +
                " when an unknown printer took a galley of type and scrambled it to make a type specimen book.", "April 13, 2017",
                "School Auditorium"));
        eventsArrayList.add(new Events("Event Name", "Lorem Ipsum is simply dummy text of the printing and typesetting industry." +
                " Lorem Ipsum has been the industry's standard dummy text ever since the 1500s," +
                " when an unknown printer took a galley of type and scrambled it to make a type specimen book.", "April 14, 2017",
                "School Auditorium"));
        eventsArrayList.add(new Events("Event Name", "Lorem Ipsum is simply dummy text of the printing and typesetting industry." +
                " Lorem Ipsum has been the industry's standard dummy text ever since the 1500s," +
                " when an unknown printer took a galley of type and scrambled it to make a type specimen book.", "April 15, 2017",
                "School Auditorium"));
        eventsArrayList.add(new Events("Event Name", "Lorem Ipsum is simply dummy text of the printing and typesetting industry." +
                " Lorem Ipsum has been the industry's standard dummy text ever since the 1500s," +
                " when an unknown printer took a galley of type and scrambled it to make a type specimen book.", "April 15, 2017",
                "School Auditorium"));

        return eventsArrayList;

    }

    public static Collection<? extends MarkSheet> getMarks() {
        ArrayList<MarkSheet> markSheetArrayList = new ArrayList<>();

        markSheetArrayList.add(new MarkSheet("English", "60", "Pass"));
        markSheetArrayList.add(new MarkSheet("Mathematics", "60", "Pass"));
        markSheetArrayList.add(new MarkSheet("Science", "20", "Fail"));
        markSheetArrayList.add(new MarkSheet("Social Studies", "60", "Pass"));
        markSheetArrayList.add(new MarkSheet("Hindi", "60", "Pass"));
        markSheetArrayList.add(new MarkSheet("Language", "70", "Pass"));
        markSheetArrayList.add(new MarkSheet("Total", "340", "Fail"));

        return markSheetArrayList;

    }

    public static String[] getExamTypes() {

        String[] arrays = new String[3];

        arrays[0] = " -- Select Exam Type -- ";
        arrays[1] = "Quarterly Exam";
        arrays[2] = "Half Yearly Exam";

        return arrays;

    }

    public static Collection<? extends Payment> getCurrentPaymentList() {

        ArrayList<Payment> paymentArrayList = new ArrayList<>();

        paymentArrayList.add(new Payment("Payment Name", "June 17 2017",
                "Due :June 26 2017", "Rs: 20,300", "Pending"));

        paymentArrayList.add(new Payment("Payment Name", "June 16 2017",
                "Due :June 26 2017", "Rs: 1,000", "Pending"));

        paymentArrayList.add(new Payment("Payment Name", "June 12 2017",
                "Due :June 26 2017", "Rs: 13,800", "Pending"));

        return paymentArrayList;

    }

    public static Collection<? extends Payment> getHistoryPaymentList() {

        ArrayList<Payment> paymentArrayList = new ArrayList<>();

        paymentArrayList.add(new Payment("Payment Name", "June 6 2017",
                "Due :June 26 2017", "Rs: 10,300", "Done"));

        paymentArrayList.add(new Payment("Payment Name", "June 4 2017",
                "Due :June 26 2017", "Rs: 20,000", "Done"));

        paymentArrayList.add(new Payment("Payment Name", "June 2 2017",
                "Due :June 26 2017", "Rs: 40,600", "Done"));

        return paymentArrayList;

    }

    public static Collection<? extends Assignment> getAssignments() {

        ArrayList<Assignment> assignmentArrayList = new ArrayList<>();

        assignmentArrayList.add(new Assignment("06", "June", "Assignment Name", "Mathematics"));
        assignmentArrayList.add(new Assignment("07", "June", "Assignment Name", "English"));
        assignmentArrayList.add(new Assignment("08", "June", "Assignment Name", "Science"));
        assignmentArrayList.add(new Assignment("09", "June", "Assignment Name", "Mathematics"));
        assignmentArrayList.add(new Assignment("16", "June", "Assignment Name", "Tamil"));

        return assignmentArrayList;

    }

    public static Collection<? extends String> getDownloadLink() {

        ArrayList<String> strings = new ArrayList<>();

        strings.add("https://www.google.com");
        strings.add("https://www.yahoo.com");
        strings.add("https://www.amazon.com");
        strings.add("https://www.flipkart.com");
        strings.add("https://www.snapdeal.com");

        return strings;

    }

    public static ArrayList<CalendarDay> getDays() {

        ArrayList<CalendarDay> days = new ArrayList<>();

        LocalDate localDateOne = new LocalDate(2017, 12, 7);
        LocalDate localDateTwo = new LocalDate(2017, 12, 13);
        LocalDate localDateThree = new LocalDate(2017, 12, 26);
        LocalDate localDateFour = new LocalDate(2018, 1, 12);
        LocalDate localDateSix = new LocalDate(2018, 1, 27);

        days.add(CalendarDay.from(localDateOne.toDate()));
        days.add(CalendarDay.from(localDateTwo.toDate()));
        days.add(CalendarDay.from(localDateThree.toDate()));
        days.add(CalendarDay.from(localDateFour.toDate()));
        days.add(CalendarDay.from(localDateSix.toDate()));

        return days;
    }

    public static Collection<? extends CalendarEvents> getCalenderEvents() {

        ArrayList<CalendarEvents> calendarEvents = new ArrayList<>();

        calendarEvents.add(new CalendarEvents("Event Name", "Lorem Ipsum is simply dummy text of the printing and typesetting industry." +
                " Lorem Ipsum has been the industry's standard dummy text ever since the 1500s," +
                " when an unknown printer took a galley of type and scrambled it to make a type specimen book."));

        calendarEvents.add(new CalendarEvents("Event Name", "Lorem Ipsum is simply dummy text of the printing and typesetting industry." +
                " when an unknown printer took a galley of type and scrambled it to make a type specimen book."));

        return calendarEvents;
    }

    public static Collection<? extends TimeTable> getTimeTable() {
        ArrayList<TimeTable> timeTables = new ArrayList<>();

        timeTables.add(new TimeTable("Mathematics", "10:00 - 11:00", "Abhinav Grewal"));
        timeTables.add(new TimeTable("Science", "11:00 - 12:00", "Jawant Muni"));
        timeTables.add(new TimeTable("Social Studies", "11:00 - 1:00", "Raj Sarkar"));
        timeTables.add(new TimeTable("English", "1:00 - 2:00", "Upasana Dani"));
        timeTables.add(new TimeTable("Tamil", "2:00 - 3:00", "Abhaniav Sigh"));

        return timeTables;
    }
    public static ArrayList<CalendarDay> getAttendanceDays(String status) {

        LocalDate localDateOne;
        ArrayList<CalendarDay> days = new ArrayList<>();

        switch (status) {
            case "Present":
                localDateOne = new LocalDate(2017, 12, 1);
                break;
            case "Absent":
                localDateOne = new LocalDate(2017, 12, 2);
                break;
            case "Late":
                localDateOne = new LocalDate(2017, 12, 4);
                break;
            case "Excuse":
                localDateOne = new LocalDate(2017, 12, 5);
                break;
            case "Holiday":
                localDateOne = new LocalDate(2017, 12, 6);
                break;
            default:
                localDateOne = new LocalDate(2017, 12, 8);
                break;
        }

        for (int i = 0; i < 7; i++) {
            days.add(CalendarDay.from(localDateOne.toDate()));
            localDateOne = localDateOne.plusDays(5);
        }
        return days;
    }
}
