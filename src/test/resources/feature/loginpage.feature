Feature: Verifying adactin details

  Scenario Outline: Verify select hotel
    Given User is on the adactin page
    When User should enter the "<userName>" and "<password>"
    When User should search hotel by "<location>", "<hotels>","<room>","<roomNo>","<adult>","<child>"
    Then User should verify "Select Hotel"
    Then User should close the browser

    Examples: 
      | userName   | password | location | hotels      | room     | roomNo  | adult   | child   |
      | prasannavk | 6D1WWD   | Sydney   | Hotel Creek | Standard | 2 - Two | 2 - Two | 2 - Two |

  Scenario Outline: Verify select hotel with mandotory
    Given User is on the adactin page
    When User should enter the "<userName>" and "<password>"
    And User should search hotel by with mandatory field"<location>", "<roomNo>","<adult>"
    Then User should verify "Select Hotel"
    Then User should close the browser
    

    Examples: 
      | userName   | password | location | roomNo  | adult   |
      | prasannavk | 6D1WWD   | Sydney   | 2 - Two | 2 - Two |

  Scenario Outline: Verify date checking
    Given User is on the adactin page
    When User should enter the "<userName>" and "<password>"
    When User should search hotel by with date "<location>", "<hotels>","<room>","<roomNo>", "<checkin>", "<checkout>", "<adult>","<child>"
    Then User should verify checkin error "Check-In Date shall be before than Check-Out Date"
    Then User should verify checkout error "Check-Out Date shall be after than Check-In Date"
    Then User should close the browser

    Examples: 
      | userName   | password | location | hotels      | room     | roomNo  | adult   | child   | checkin    | checkout   |
      | prasannavk | 6D1WWD   | Sydney   | Hotel Creek | Standard | 2 - Two | 2 - Two | 2 - Two | 11/08/2021 | 10/08/2021 |

  Scenario Outline: Verify select hotel with mandotory
    Given User is on the adactin page
    When User should enter the "<userName>" and "<password>"
    When User should click search
    Then User should verify loaction error "Please Select a Location"
    Then User should close the browser

    Examples: 
      | userName   | password | location | hotels      | room     | roomNo  | adult   | child   | first    | last  | add     | cc               | name | month   | year | cvv | checkin    | checkout   |
      | prasannavk | 6D1WWD   | Sydney   | Hotel Creek | Standard | 2 - Two | 2 - Two | 2 - Two | Prasanna | Kumar | Chennai | 1231231231231231 | VISA | January | 2022 | 996 | 11/08/2021 | 10/08/2021 |
