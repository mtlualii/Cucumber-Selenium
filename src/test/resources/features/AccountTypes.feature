Feature: Account types
  @wip
  Scenario:  Driver user
    Given the user logged in as "driver"
    When the user navigates to "Activities" "Calendar Events"
    Then the title contains "Calendar Events - Activities"
  @wip
  Scenario: Sales manager user
    Given the user logged in as "sales manager"
    When the user navigates to "Customers" "Accounts"
    Then the title contains "Accounts - CustomersS"
  @wip
  Scenario: Store manager user
    Given the user logged in as "store manager"
    When the user navigates to "Customers" "Contacts"
    Then the title contains "Contacts - Customers"


  Scenario Outline: Login with different accounts
    Given the user logged in as "<userType>"
    When the user navigates to "<tab>" "<module>"
    Then the title contains "<title>"

    Examples:
      | userType      | tab        | module          | title                        |
      | driver        | Activities | Calendar Events | Calendar Events - Activities |
      | store manager | Customers  | Accounts        | Accounts - Customers         |
      | sales manager | Customers  | Contacts        | Contacts - Customers         |
