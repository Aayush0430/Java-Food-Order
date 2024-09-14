public static int getEquivalentChoiceNumber(int menuChoice) {
        int equivalentChoiceNumber = 0;
        // if in guest mode
        // set exit to 9
        if (MainClass.getUserMode() == "guest") {
            // 1viewbooks 2searchbook 3login 4signup 5 exit
            switch (menuChoice) {
                case 5:
                    menuChoice = 9;
                    break;
                default:
                    break;
            }
        }
        // if user mode is admin
        // set addbook=7 removebook=8 exit=9
        if (MainClass.getUserMode() == "admin") {
            // 3addbook 4removebook 5changeprivacy 6logout 7exit
            switch (menuChoice) {
                case 3:
                    menuChoice = 7;
                    break;
                case 4:
                    menuChoice = 8;
                    break;
                case 7:
                    menuChoice = 9;
                    break;
                default:
                    break;
            }
        }

        // if user mode is member
        // set changepriv=5 logout=6 exit=9
        if (MainClass.getUserMode() == "member") {
            // 3borrowedbooks 4return books 5change privacy 6logout 7exit
            switch (menuChoice) {
                // borrowed
                case 3:
                    menuChoice = 10;
                    break;
                // return books
                case 4:
                    menuChoice = 11;
                    break;
                // privacy
                case 5:
                    menuChoice = 5;
                    break;
                // logout
                case 6:
                    menuChoice = 6;
                    break;
                // exit
                case 7:
                    menuChoice = 9;
                    break;
            }
        }
        // return converted number
        equivalentChoiceNumber = menuChoice;
        return equivalentChoiceNumber;
    }
