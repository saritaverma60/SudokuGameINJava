# 🎮 SUDOKUFX
**SudokuFX** is java based Sudoku game which is aimed to be desiged using JavaFX.<br>
The project is in intial development. Please read the following instructions carefully:-

## 📥 Installation
<!-- Add installation steps and documenations after first game realese -->

## 🎯 Objective
<!--Create objective of the project -->
The objective of the project is to create a nice looking sudoku player application. The project development includes following sub-steps:
- **Appealing UI** 🛠
  - Welcome screeen 🛠
  - username Pop-up 🛠
  - Main game play screen 🛠<!-- include main-play UI with play/pause/restart popup-->
  - Leaderboards screen ❌
- **Sudoku Generation** ❌
  - Using Web API ❌
  - Using self implemeted Generating Class ❌
- **Functionality Development** ❌
  - Integration of UI with Sudoku generator ❌
  - Player Managemnet ❌<!-- allow player name, highscore/leaderboards(implement using JDBC) etc. features-->
  - Game play management ❌<!-- allow restart, save, load and configure game difficulty and time of game play-->
  

## 🤝 Contributions

The project SudokuFX is open for contributions and useful contributions are appreciable. You can also open an issue for any bug or for any desired features that shoud be included.
<br>
***Existing Contributors*** are contribuing directly to project. Rest are under ***New Contributor Category*** . Following includes the steps to contribute.

### New Contributors

- Fork the SudokuFX repository

- Clone the repository to your local machine using(optional-- for non-UI edits)

      git clone https://github.com/saritaverma60/SudokuGameINJava.git

- Make your edits (For non-UI based edits, you may do directly using github codespaces)

- Commit you changes using following with relevent message at `<msg>`

      git comit -m "<msg>"

- Push the changes if editted in local using following then Open the pull request.

      git push.

### Existing Contributors
Exiting contributors are directly contributing to project and don't need to fork the repo or open pull requests. They are free to make and commit changes. To do so:

- Clone the repository to your local machine using(optional-- for non-UI edits)

      git clone https://github.com/saritaverma60/SudokuGameINJava.git

- Make your edits (For non-UI based edits, you may do directly using github codespaces)

- Commit you changes using following with relevent message at `<msg>`

      git comit -m "<msg>"

- Push the changes if editted in local using following.

      git push

Note: Request to [Contacts](#contacts) to gain internal contribitor access. (Only available to PMKVY students).

## 🚀 Getting Started
The java project is developed using gradle build tool. You do not need any extenal dependency or libraries for project, Gradle will manage all.<br>
Only ensure that you have:
- JDK 17 or above

### Build Project
Run the following after Cloning the project to your local machine. Replace the `gardlew` with `gradle` if running on Linux or Mac

      gradlew build 

this will create all necessary files and folder for project building.

### Running Project

Use follwoing to run the gradle project. Replace `gradlew` with `gradle` on Linux or Mac.

      gradlew run

### Creating Sharable Jar
The [build.gradle](app/build.gradle) contains code block to make a sharable Jar with all dependency included. This Jar is created and stored in [app/build/libs](app/build/libs) folder with SudokuFX name. <br>
Run the following to create a sharable jar. Replace `gradlew` with `gradle` on Linux or Mac.


      gradlew createJar


## 📂File structure
<!--Explain what each file is for with liks to the file-->
### Directories
- [app](app): holds directories and files relevent to application.
  - [java](app/src/main/java): consists java files and hodls logical insterest.
  - [resources](app/src/main/resources): consists Image directories and XMLs of UI interest
- [gradle](gradle): holds gradle config files

### Files

- **Main Classes**
  - [Launcher.java](app/src/main/java/io/github/dvyadav/sudokufx/Launcher.java): Entrypoint in Jar and invokes the application.
  - [Main.java](app/src/main/java/io/github/dvyadav/sudokufx/Main.java): Initilizes the app UI, manages the app window.

- **Controller Classes**
  - [GameGridController.java](app/src/main/java/io/github/dvyadav/sudokufx/GameGridController.java): holds definitions for controls on `GameGrid.fxml`
  - [UsernamePopupUIController.java](app/src/main/java/io/github/dvyadav/sudokufx/UsernamePopupUIController.java): holds definitions for controls on `UsernamePopupUI.fxml`
  - [WelcomePageUIController.java](app/src/main/java/io/github/dvyadav/sudokufx/WelcomePageUIController.java): holds definitons for controls on `WelcomePageUI.fxml`

- **XMLs**
  - [GameGrid.fxml](app/src/main/resources/io/github/dvyadav/sudokufx/GameGridUI.fxml): Actual GamePlay UI
  - [UsernamePopup.fxml](app/src/main/resources/io/github/dvyadav/sudokufx/UsernamePopupUI.fxml): User Name input UI
  - [WelcomePage.fxml](app/src/main/resources/io/github/dvyadav/sudokufx/WelcomePageUI.fxml): Landing Page UI of application

- **Gradle-Specific**
  - [build.gradle](app/build.gradle): Manages project dependecies.
  - [gradle-wrapper.properties](gradle/wrapper/gradle-wrapper.properties): defines gradle settings e.g. version etc.
  - [settings.gradle](settings.gradle): project settings for gradle interest.
## 👩‍👦‍👦 Contacts
<!--add contributor/owners' contacts-->
### Sarita Verma
- Role: Owner / Project Manager
- Email:
  
#### Divyanshu Yadav
- Role: Contributor
- Email: [divyanshuy858@gmail.com](mailto:divyanshuy858@gmail.com)
- Linkedin: [DVyadav2307](https://www.linkedin.com/in/dvyadav2307)

#### Neeraj Sharma
- Role: Contributor
- Email: [neerajsharma198118131@gmail.com](mailto:neerajsharma198118131@gmail.com)
- Linkedin: [neeraj-sharma-08874124b](https://www.linkedin.com/in/neeraj-sharma-08874124b?utm_source=share&utm_campaign=share_via&utm_content=profile&utm_medium=android_app)
