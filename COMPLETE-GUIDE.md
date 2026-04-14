# =====================================================================
#   COMPLETE GUIDE - DO ANY JAVA CI/CD PROJECT FROM SCRATCH
#   Your Laptop Credentials & Step-by-Step Commands
# =====================================================================

## YOUR CREDENTIALS (Save this!)

| Service    | Username          | Password           |
|------------|-------------------|--------------------|
| GitHub     | Tythebuilder      | (your GitHub login)|
| DockerHub  | sabarishselva23   | Sabarish@2005      |
| Jenkins    | admin             | db5081e8d70d4648a44608adb8335372 |

---

## STEP 0 - START JENKINS (Do this first, every time)

Double-click this file on your Desktop:
  START-JENKINS.bat

Then open browser: http://localhost:8080
Login: admin / db5081e8d70d4648a44608adb8335372

---

## STEP 1 - COPY THE TEMPLATE

1. Go to Desktop → Copy the "PROJECT-TEMPLATE" folder
2. Paste it and rename it to your project (e.g. "simple-voting-system")
3. Open PowerShell in that new folder (Shift+Right Click → Open PowerShell)

---

## STEP 2 - CHANGE THESE 4 THINGS IN THE FILES

### In pom.xml:
  Line: <artifactId>YOUR-PROJECT-NAME</artifactId>
  Change to: <artifactId>simple-voting-system</artifactId>

  Line: <mainClass>com.demo.YourProgram</mainClass>
  Change to: <mainClass>com.demo.VotingSystem</mainClass>

### In Dockerfile:
  Line: COPY target/YOUR-PROJECT-NAME-1.0.jar app.jar
  Change to: COPY target/simple-voting-system-1.0.jar app.jar

### In deployment.yaml:
  Replace ALL instances of YOUR-PROJECT-NAME with: simple-voting-system
  (Use Ctrl+H in VS Code to find and replace all at once)

### In Jenkinsfile:
  Replace ALL instances of YOUR-PROJECT-NAME with: simple-voting-system
  (Use Ctrl+H in VS Code to find and replace all at once)

### Rename the Java files:
  src/main/java/com/demo/YourProgram.java    → VotingSystem.java
  src/test/java/com/demo/YourProgramTest.java → VotingSystemTest.java

---

## STEP 3 - WRITE YOUR JAVA CODE

### Inside YourProgram.java (renamed) - Write your logic:
  - Read the problem statement
  - Write methods that solve it
  - Write a main() that shows the output

### Inside YourProgramTest.java (renamed) - Write JUnit tests:
  - Use @Test annotation above each test method
  - Use assertTrue(), assertFalse(), assertEquals(), assertThrows()

---

## STEP 4 - RUN AND TEST LOCALLY

Open PowerShell in your project folder and run:

  # Compile and run tests
  mvn clean test

  # If tests pass (BUILD SUCCESS), build the JAR
  mvn clean package

  # Run the app
  java -jar target/simple-voting-system-1.0.jar

---

## STEP 5 - PUSH TO GITHUB

1. Go to https://github.com → Login as Tythebuilder
2. Click "+" → New Repository
3. Name it exactly: simple-voting-system
4. Select Public → DO NOT add README → Click Create repository

Then in PowerShell (inside your project folder):

  git init
  git add .
  git commit -m "Initial commit"
  git branch -M main
  git remote add origin https://github.com/Tythebuilder/simple-voting-system.git
  git push -u origin main

GitHub will ask for login:
  Username: Tythebuilder
  Password: (your GitHub password - the browser will help)

---

## STEP 6 - RUN JENKINS PIPELINE

1. Go to http://localhost:8080
2. Login: admin / db5081e8d70d4648a44608adb8335372
3. Click "New Item" on left menu
4. Name: simple-voting-system-CICD
5. Select "Pipeline" → Click OK
6. Scroll down to "Pipeline" section
7. Copy EVERYTHING from your Jenkinsfile and paste it in the Script box
8. Click Save
9. Click "Build Now" on the left

Watch the Stage View turn green:
  Clone → Build → Test → Docker Build → Docker Push → K8s Deploy

---

## STEP 7 - VERIFY EVERYTHING WORKED

Open PowerShell anywhere and run:

  # See your running pods
  kubectl get pods

  # See your services
  kubectl get svc

  # Expected output: 2 pods with STATUS = Running

---

## WHAT TO SHOW YOUR FACULTY (4 Steps)

### 1. Java Program Execution:
  Open PowerShell → navigate to your project folder → run:
  java -jar target/simple-voting-system-1.0.jar

### 2. JUnit Testing:
  mvn test
  (Show the BUILD SUCCESS and Tests run: X, Failures: 0)

### 3. CI/CD Pipeline:
  Open http://localhost:8080 → your pipeline → show green Stage View

### 4. Docker + Kubernetes:
  kubectl get pods  (show 2 Running pods)
  kubectl get svc   (show NodePort service)
  Open https://hub.docker.com/u/sabarishselva23 (show your image)

---

## COMMON ERRORS AND FIXES

| Error                          | Fix                                              |
|--------------------------------|--------------------------------------------------|
| mvn not found                  | Open new PowerShell (env vars now permanent)     |
| java not found                 | Open new PowerShell (env vars now permanent)     |
| Jenkins not opening            | Double-click START-JENKINS.bat on Desktop        |
| docker: command not found      | Open Docker Desktop app and wait for it to start |
| kubectl not found              | Enable Kubernetes in Docker Desktop settings     |
| git push asks for password     | Use your GitHub personal access token            |
| Jenkins credential error       | Manage Jenkins → Credentials → check dockerhub-creds exists |

---

## FILE STRUCTURE (Same for EVERY project)

your-project-name/
├── pom.xml                         ← Maven config
├── Dockerfile                      ← Docker packaging
├── deployment.yaml                 ← Kubernetes config
├── Jenkinsfile                     ← CI/CD pipeline
├── .gitignore                      ← ignore target/
└── src/
    ├── main/java/com/demo/
    │   └── YourProgram.java        ← YOUR CODE HERE
    └── test/java/com/demo/
        └── YourProgramTest.java    ← YOUR TESTS HERE
