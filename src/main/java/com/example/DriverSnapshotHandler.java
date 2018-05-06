package com.example;

/** 
 * Example of a class under test
 */
public class DriverSnapshotHandler {
    
    public String getImageURL() {
        return FormatterService.getInstance().formatTachoIcon();
    }
}
