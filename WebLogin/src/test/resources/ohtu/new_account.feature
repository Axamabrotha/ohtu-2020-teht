Feature: A new user account can be created if a proper unused username and password are given

    Scenario: creation is successful with valid username and password
        Given command new user is selected
        When  a valid username "liisa" and password "salainen1" and matching password confirmation "salainen1" are entered
        Then  a new user is created

    Scenario: creation fails with too short username and valid password
        Given command new user is selected
        When  too short username "ax" and valid password "4x4m4br07h4" with matching password confirmation "4x4m4br07h4" are entered
        Then user is not created and error "username should have at least 3 characters" is reported   

    Scenario: creation fails with correct username and too short password
        Given command new user is selected
        When  valid username "axamabrotha" and too short password "ax" with matching password confirmation "ax" are entered
        Then user is not created and error "password should have at least 8 characters" is reported   

    Scenario: creation fails when password and password confirmation do not match
        Given command new user is selected
        When  valid username "axamabrotha" and valid password "4x4m4br07h4" are entered but password and password confirmation "axamabrotha" do not match
        Then user is not created and error "password and password confirmation do not match" is reported   

    Scenario: user can login with successfully generated account
        Given user with username "lea" with password "salainen1" is successfully created
        And new user logs out and selects login
        When  user with username "lea" and password "salainen1" logs in
        Then  the new user is logged in successfully

    Scenario: user can not login with account that is not successfully created
        Given user with username "aa" and password "bad" is tried to be created
        And   user goes to login
        When  user with username "aa" and password "bad" tries to log in
        Then  user cannot log in with inexisting account and error message is given