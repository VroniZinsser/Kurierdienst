package com.example.kurierdienst2;

import java.sql.Driver;

import android.location.Address;

public class Task {

private String taskId;
private String data;
private String time;
private String status;
private Address startAddress;
private Address endAddress;
private Driver driver;


public Task (String id, String data, String time, Address start, Address end) {
taskId = id;
this.data = data;
this.time = time;
startAddress = start;
endAddress = end;

status= "waiting";
driver = null;

}

public void setId (String id) {
taskId = id;
}

public void setData (String data) {
this.data = data;
}

public void setTime () {

}

public void setStart (Address start) {
startAddress = start;
}

public void setEnd (Address end) {
endAddress = end;
}


}