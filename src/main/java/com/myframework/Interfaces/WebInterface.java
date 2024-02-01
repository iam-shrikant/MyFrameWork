/*
@author : Shrikant
*/

package com.myframework.Interfaces;
public interface WebInterface {
    // initiate browser to launch website provided in URL
    void launchWebsite(String url);

    // close all browser,tab or windows associated with test
    void exitTest();


    void implicitilyWait(int seconds);

    void pageLoadTimeout(int seconds);

    void maximizeScreen();
}
