Feature: Contacts page

  Scenario: Default page number
    Given the user is on the login page
    And the user enters the driver information
    When the user navigates to "Customers" "Contacts"
    Then default page should be 1

  Scenario: Verify Create Calender Event
    Given the user is on the login page
    And the user enters the sales manager information
    When the user navigates to "Activities" "Calendar Events"
    Then the title contains "Calendar"


  Scenario: Menu Options sales manager
    Given the user logged in as "sales manager"
    Then the user should see following options
      | Dashboards         |
      | Fleet              |
      | Customers          |
      | Sales              |
      | Activities         |
      | Marketing          |
      | Reports & Segments |
      | System             |

  Scenario: Menu Options driver
    Given the user logged in as "driver"
    Then the user should see following options
      | Fleet      |
      | Customers  |
      | Activities |
      | System     |

  Scenario: login as a given user
    Given the user is on the login page
    When the user logs in using following credentials
      | username  | user10      |
      | password  | UserUser123 |
      | firstname | John        |
      | lastname  | Doe         |
    Then the user should be able to login





