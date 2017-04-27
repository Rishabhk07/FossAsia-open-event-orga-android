package org.fossasia.fossasiaorgaandroidapp.Utils;

/**
 * Created by rishabhkhanna on 25/04/17.
 */

public class Constants {
    //url to login organiser
    public static final String LoginUrl = "http://open-event-dev.herokuapp.com/api/v1/login";
    //Logged in user events
    public static final String userEvents = "http://open-event-dev.herokuapp.com/api/v1/users/me/events";
    //users events api
    public static final String userDetails = "http://open-event-dev.herokuapp.com/api/v1/users";
    //event details
    public static final String eventDetails = "http://open-event-dev.herokuapp.com/api/v1/events/";
    // attendees toggle
    public static final String attendeesToggle = "/attendees/check_in_toggle/";
    //event details tickets
    public static final String tickets = "?include=tickets";
    //Attendees details
    public static final String attendees = "/attendees";
    //SharedPrefs key
    public static final String sharedPrefsToken = "token";
    //SharedPrefs db Name
    public static final String fossPrefs = "FossPrefs";

}
