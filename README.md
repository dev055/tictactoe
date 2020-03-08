# TicTacToe project

## Rules
	
- X always goes first.
- Players cannot play on a played position.
- Players alternate placing X’s and O’s on the board until either:
	- One player has three in a row, horizontally, vertically or diagonally
	- All nine squares are filled.
- If a player is able to draw three X’s or three O’s in a row, that player wins.
- If all nine squares are filled and neither player has three in a row, the game is a draw.

## Run the project : 

### clone project from github 
  from this link: https://github.com/dev055/tictactoe.git 

### download Android studio ide from this link
  from this link: https://developer.android.com/studio
 
### Open the project from the ide
  Open android studio ->
  Open an existing android studio project -> 
  browse to root project -> select tictactoe

### Compile and Run the project
  - Emulator 
      - You must to create an android virtual device
        from android studio ide, tap on open AVD manager -> create virtual device... -> select hardware -> select system image -> finish 
      - run the emulator by clicking on the green play button from ide
      - if the steps are not clear you can go to this link https://developer.android.com/studio/run/managing-avds

  - Real device
    - Enable developer mode on device
            Open settings app -> about telephon -> information about software ->
	    tap on build number till you see “you are now a developer”
            -> go back to settings app -> developer options -> enable debugging (USB Debugging)
    - After this steps, You need to plug the device to android studio via an usb cable
            to run the app on device in clicking on the green play button from ide
