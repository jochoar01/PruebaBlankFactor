Feature: Validacion Facebook

  Como usuario quiero leer chistes de Testers
  @FullCheckOutHappyPath
  Scenario Outline: Ingresar a la categoria comics desde la pantalla home

    Given  User can navegate to principal Blankfactor Page
    When   Open Blog section and scroll down to post
    Then   Verify the page is in "<Url>" , "<author>" and "<date>"
    Then   Returns to blog page page and print

    Examples:
      | Url                                                                   | author         | date                       |
      | https://blankfactor.com/insights/blog/fintech-in-latin-america/       | Sofia Gonzalez | August 13, 2021 - 10:04 am |
      #| https://blankfactdhvjdhor.com/insights/blog/fintech-in-latin-america/ |                |                            |




