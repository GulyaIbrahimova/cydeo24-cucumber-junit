Feature: Librarian login functionality
  Agile story: As a User I should be able to login LibraryCT
  I should be able to enter valid credentials,
  and click sign in button,
  and I should be able to see 3 models in the page

Scenario:As a  Librarian should be able to login LibraryCT
  Given User is on the Library login page
  When User enters valid email address and password
  And User clicks on Sing in button
  Then User should be able to see three models on the page