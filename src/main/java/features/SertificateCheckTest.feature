@CERTIFICATE
Feature: CheckCert

  Scenario: Positive cheсk
    When I send certificate number "45924126"
    Then Verification  certificate "true"

  Scenario: Positive cheсk
    When I send certificate number "45126"
    Then Verification  certificate "false"

  Scenario: Negative cheсk
    When I send certificate number "94358473743781235"
    Then Verification  certificate "false"

  Scenario: Positive cheсk
    When I send certificate number "00000000"
    Then Verification  certificate "false"

  Scenario: Positive check
    When I send certificate number "84858872"
    Then Verification  certificate "true"