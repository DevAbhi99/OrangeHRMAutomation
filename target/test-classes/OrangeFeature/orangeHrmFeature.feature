#Author: Abhigyan Khaund

@regression
Feature: Feature to test the functionalities of Orange HRM Website

@tc001_login
Scenario Outline: To validate the login functionality of the website

Given the user is on the login page of the website
When the user provides valid username <username> and valid password <password>
And the user clicks on the login button
Then the user gets acccess to the landing page of the website

 Examples:
 | username | password |
 | Admin | admin123 |
 

@tc002_jobSearch
Scenario: To validate the job list in the website and find if QA jobs are present in the list

Given the user is on the landing page of the website
When the user clicks on the Admin tab
And the user clicks on the job drop down and the clicks on Job titles tab
Then list of jobs are displayed

@tc003_logout
Scenario: To validate the logout functionality of the website

Given the user is on the landing page of the website
When the user clicks on the profile tab on the right top corner 
And the user clicks on the logout button
Then the user gets logged out and redirected to the login page 

 